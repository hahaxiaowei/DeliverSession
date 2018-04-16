package com.cienet.enity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * @program: session-client
 * @description: 对象工厂
 * @author: SunWei
 * @create: 2018-04-15 13:45
 **/

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the generated package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeliverySession_QNAME = new QName("", "DeliverySession");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeliverySessionCreationType }
     *
     */
    public static DeliverySessionCreationType createDeliverySessionCreationType() {
        return new DeliverySessionCreationType();
    }

    public static DeliverySessionCreationType createDeliverySessionCreationType(long deliverySessionId){
        DeliverySessionCreationType deliverySessionCreationType = new DeliverySessionCreationType();
        deliverySessionCreationType.setDeliverySessionId(deliverySessionId);
        deliverySessionCreationType.setAction(ActionType.START);
        deliverySessionCreationType.setVersion("01");
        return deliverySessionCreationType;
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliverySessionCreationType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "DeliverySession")
    public static JAXBElement<DeliverySessionCreationType> createDeliverySession(DeliverySessionCreationType value) {
        return new JAXBElement<DeliverySessionCreationType>(_DeliverySession_QNAME, DeliverySessionCreationType.class, null, value);
    }
}
