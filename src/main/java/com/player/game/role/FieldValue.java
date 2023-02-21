package com.player.game.role;

import com.player.framework.annotation.ValueField;

public class FieldValue {

    /**
     * 属性id
     */
    private short field;
    /**
     * 属性类型 1字节 2短整 3整数 4文本
     */
    @ValueField()
    private byte type;
    /**
     * 属性值
     */
    private Object value;

    public FieldValue(int fieldId, int type, Object value) {
        this.field = (short) fieldId;
        this.type = (byte) type;
        this.value = value;
    }


    public FieldValue() {
    }

    public short getField() {
        return field;
    }

    public void setField(short field) {
        this.field = field;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
