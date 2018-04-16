package com.cienet.server;

import com.cienet.enity.ActionType;
import com.cienet.enity.DeliverySessionCreationType;
import com.cienet.httpenity.HttpXmlRequest;
import com.cienet.httpenity.HttpXmlResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.ArrayList;
import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by sunwei on 2018-04-16 Time:16:33:31
 */
public class HttpXmlServerHandler extends SimpleChannelInboundHandler {

    public void messageReceived(final ChannelHandlerContext ctx, Object object) throws Exception {
        HttpXmlRequest xmlRequest = (HttpXmlRequest)object;
        HttpRequest request = xmlRequest.getRequest();
        DeliverySessionCreationType deliverySessionCreationType = (DeliverySessionCreationType) xmlRequest.getBody();
        System.out.println("Http server receive request : " + deliverySessionCreationType);
        dobusiness(deliverySessionCreationType);
        ChannelFuture future = ctx.writeAndFlush(new HttpXmlResponse(null,deliverySessionCreationType));
        if (!isKeepAlive(request)) {
            future.addListener(new GenericFutureListener() {
                public void operationComplete (Future future)throws Exception {
                    ctx.close();
                }
            });
        }
    }

    private void dobusiness(DeliverySessionCreationType deliverySessionCreationType) {
        deliverySessionCreationType.setDeliverySessionId(01);
        deliverySessionCreationType.setAction(ActionType.START);
        deliverySessionCreationType.setVersion("01");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            sendError(ctx, INTERNAL_SERVER_ERROR);
        }
    }

    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                status, Unpooled.copiedBuffer("失败: " + status.toString()
                + "\r\n", CharsetUtil.UTF_8));
        response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }
}
