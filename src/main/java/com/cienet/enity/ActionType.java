package com.cienet.enity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @program: session-client
 * @description: ActionType的 Java 类
 * @author: SunWei
 * @create: 2018-04-15 13:41
 **/
@XmlType(name = "ActionType")
@XmlEnum
public enum ActionType {

    @XmlEnumValue("Start")
    START("Start"),
    @XmlEnumValue("Stop")
    STOP("Stop");
    private final String value;

    ActionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActionType fromValue(String v) {
        for (ActionType c: ActionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
