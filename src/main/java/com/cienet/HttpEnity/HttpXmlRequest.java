package com.cienet.HttpEnity;

import io.netty.handler.codec.http.FullHttpRequest;
import lombok.Data;

/**
 * Created by sunwei on 2018-04-16 Time:15:50:14
 * 用于实现和协议栈之间的解耦
 */
@Data
public class HttpXmlRequest {

    //它包含两个成员变量FullHttpRequest和编码对象Object，用于实现和协议栈之间的解耦。
    private FullHttpRequest request;
    private Object body;

    public HttpXmlRequest(FullHttpRequest request, Object body) {
        this.body = body;
        this.request = request;
    }
}
