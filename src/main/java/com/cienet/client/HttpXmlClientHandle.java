package com.cienet.client;

import com.cienet.enity.ObjectFactory;
import com.cienet.httpenity.HttpXmlRequest;
import com.cienet.httpenity.HttpXmlResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by sunwei on 2018-04-16 Time:16:46:41
 */
public class HttpXmlClientHandle extends SimpleChannelInboundHandler {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        HttpXmlRequest request = new HttpXmlRequest(null, ObjectFactory.createDeliverySessionCreationType(123));
        ctx.writeAndFlush(request);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    protected void messageReceived(ChannelHandlerContext ctx,Object o) throws Exception {
        HttpXmlResponse msg = (HttpXmlResponse)o;
        System.out.println("The client receive response of http header is : " + msg.getHttpResponse().headers().names());
        System.out.println("The client receive response of http body is : " + msg.getResult());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }
}
