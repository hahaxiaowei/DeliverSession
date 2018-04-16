package com.cienet.httpaction;

import com.cienet.httpenity.HttpXmlRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;

import java.util.List;

import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpHeaders.Names.*;
import static io.netty.handler.codec.http.HttpVersion.*;

/**
 * Created by sunwei on 2018-04-16 Time:16:27:16
 */
public class HttpXmlRequestDecoder extends AbstractHttpXmlDecoder {
    public HttpXmlRequestDecoder(Class clazz) {
        this(clazz, false);
    }
    //HttpXmlRequestDecoder有两个参数，分别为需要解码的对象的类型信息和是否打印HTTP消息体码流的码流开关，码流开关默认关闭。
    public HttpXmlRequestDecoder(Class clazz, boolean isPrint) {
        super(clazz, isPrint);
    }

    @Override
    protected void decode(ChannelHandlerContext arg0, Object o, List arg2) throws Exception {
        FullHttpRequest arg1 = (FullHttpRequest)o;
        //首先对HTTP请求消息本身的解码结果进行判断，如果已经解码失败，再对消息体进行二次解码已经没有意义。
        if (!arg1.getDecoderResult().isSuccess()) {
            //如果HTTP消息本身解码失败，则构造处理结果异常的HTTP应答消息返回给客户端。
            sendError(arg0, BAD_REQUEST);
            return;
        }
        //通过HttpXmlRequest和反序列化后的Order对象构造HttpXmlRequest实例，最后将它添加到解码结果List列表中。
        HttpXmlRequest request = new HttpXmlRequest(arg1, decode0(arg0,arg1.content()));
        arg2.add(request);
    }

    private static void sendError(ChannelHandlerContext ctx,
                                  HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                status, Unpooled.copiedBuffer("Failure: " + status.toString()
                + "\r\n", CharsetUtil.UTF_8));
        response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
