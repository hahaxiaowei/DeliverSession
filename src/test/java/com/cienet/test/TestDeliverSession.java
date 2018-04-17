package com.cienet.test;

import com.cienet.enity.ActionType;
import com.cienet.enity.DeliverySessionCreationType;
import org.jibx.runtime.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by sunwei on 2018-04-16 Time:17:13:50
 */
public class TestDeliverSession {
    private IBindingFactory factory = null;
    private StringWriter writer = null;
    private StringReader reader = null;
    private final static String CHARSET_NAME = "UTF-8";

    private String encode2Xml(DeliverySessionCreationType deliverySessionCreationType) throws JiBXException, IOException {
        factory = BindingDirectory.getFactory(DeliverySessionCreationType.class);
        writer = new StringWriter();
        IMarshallingContext mctx = factory.createMarshallingContext();
        mctx.setIndent(2);
        mctx.marshalDocument(deliverySessionCreationType, CHARSET_NAME, null, writer);
        String xmlStr = writer.toString();
        writer.close();
        System.out.println(xmlStr.toString());
        return xmlStr;
    }

    private DeliverySessionCreationType decode2Order(String xmlBody) throws JiBXException {
        reader = new StringReader(xmlBody);
        IUnmarshallingContext uctx = factory.createUnmarshallingContext();
        DeliverySessionCreationType order = (DeliverySessionCreationType) uctx.unmarshalDocument(reader);
        return order;
    }

    public static void main(String[] args) throws JiBXException, IOException {
        TestDeliverSession test = new TestDeliverSession();
        DeliverySessionCreationType deliverySessionCreationType = new DeliverySessionCreationType();
        deliverySessionCreationType.setVersion("01");
        deliverySessionCreationType.setDeliverySessionId(001);
        deliverySessionCreationType.setAction(ActionType.START);
        String body = test.encode2Xml(deliverySessionCreationType);
        DeliverySessionCreationType deliverySessionCreationType1 = test.decode2Order(body);
        System.out.println(deliverySessionCreationType1);
    }
}
