package com.cienet.enity;

import javax.xml.bind.annotation.*;

/**
 * @program: session-client
 * @description: DeliverySessionCreationType complex type的 Java 类
 * @author: SunWei
 * @create: 2018-04-15 13:43
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverySessionCreationType", propOrder = {
        "deliverySessionId",
        "action",
        "tmgiPool",
        "tmgi",
        "startTime",
        "stopTime"
})
public class DeliverySessionCreationType {

    @XmlElement(name = "DeliverySessionId")
    @XmlSchemaType(name = "unsignedInt")
    protected long deliverySessionId;
    @XmlElement(name = "Action", required = true)
    @XmlSchemaType(name = "string")
    protected ActionType action;
    @XmlElement(name = "TMGIPool")
    protected String tmgiPool;
    @XmlElement(name = "TMGI")
    protected String tmgi;
    @XmlElement(name = "StartTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long startTime;
    @XmlElement(name = "StopTime")
    @XmlSchemaType(name = "unsignedInt")
    protected Long stopTime;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    /**
     * 获取deliverySessionId属性的值。
     *
     */
    public long getDeliverySessionId() {
        return deliverySessionId;
    }

    /**
     * 设置deliverySessionId属性的值。
     *
     */
    public void setDeliverySessionId(long value) {
        this.deliverySessionId = value;
    }

    /**
     * 获取action属性的值。
     *
     * @return
     *     possible object is
     *     {@link ActionType }
     *
     */
    public ActionType getAction() {
        return action;
    }

    /**
     * 设置action属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ActionType }
     *
     */
    public void setAction(ActionType value) {
        this.action = value;
    }

    /**
     * 获取tmgiPool属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTMGIPool() {
        return tmgiPool;
    }

    /**
     * 设置tmgiPool属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTMGIPool(String value) {
        this.tmgiPool = value;
    }

    /**
     * 获取tmgi属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTMGI() {
        return tmgi;
    }

    /**
     * 设置tmgi属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTMGI(String value) {
        this.tmgi = value;
    }

    /**
     * 获取startTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 设置startTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setStartTime(Long value) {
        this.startTime = value;
    }

    /**
     * 获取stopTime属性的值。
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getStopTime() {
        return stopTime;
    }

    /**
     * 设置stopTime属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setStopTime(Long value) {
        this.stopTime = value;
    }

    /**
     * 获取version属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置version属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
