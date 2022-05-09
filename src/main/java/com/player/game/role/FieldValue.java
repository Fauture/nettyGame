package com.player.game.role;

import com.player.framework.annotation.ValueField;

public class FieldValue {

    private short field;
    @ValueField()
    private byte type;
    private Object value;

    public FieldValue(int fieldId, int type, Object value) {
        this.field = (short) fieldId;
        this.type = (byte) type;
        this.value = value;
    }

//    public FieldValue(int fieldId, Object value) {
//        this.type = (short) fieldId;
//        byte fieldType = SpringUtils.getBean(AttrService.class).getAttrType(fieldId);
//        if (fieldType == 0) {//等于0说明配置不对 抛出异常看看是什么属性
//            try {
//                throw new Exception(String.format("属性ID[%d]的类型不正确!!!", fieldId));
//            } catch (Exception e) {
//                LoggerFactory.getLogger(this.getClass()).error("属性ID={}没有设置类型={}",fieldId, Lang.getStackTrace(e));
//            }
//        }
//        this.VT = fieldType;
//        this.value = value;
//    }

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
