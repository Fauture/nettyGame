package com.player.game.role;

import com.player.framework.annotation.ListField;
import com.player.framework.annotation.StringField;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;

import java.util.List;

//@MessageIgnore()
@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.MSG_UPDATE_SKILLS)
public class ResSkill extends Message {

    /**
     * 角色id或宠物id
     */
    private int id = 0;
    /**
     * 技能数据列表
     */
    @ListField()
    private List<ResSkill.Skill> Skill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResSkill.Skill> getSkill() {
        return Skill;
    }

    public void setSkill(List<ResSkill.Skill> skill) {
        Skill = skill;
    }

    public static class Skill {
        public Skill() {
        }
        private short no;
        private int attrib;
        @StringField()
        private String name;
        private short value1;
        private short level;
        private short value3;
        private int value4;
        private int value5;
        private int value6;
        private int value7;
        private int value8;
        private int value9;
        private byte value10;
        private int value11;
        private int value12;
        private int value14;
        @StringField()
        private String value15;
        private byte value16;
        @ListField()
        private List<ResSkill.Sk> sk;
        private short value17;
        private short value18;
        private byte value19;

        public short getNo() {
            return no;
        }

        public void setNo(short no) {
            this.no = no;
        }

        public int getAttrib() {
            return attrib;
        }

        public void setAttrib(int attrib) {
            this.attrib = attrib;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public short getLevel() {
            return level;
        }

        public void setLevel(short level) {
            this.level = level;
        }

    }
    public static class Sk {
        public Sk() {
        }

        /**
         * 学习消耗所需类型
         */
        @StringField()
        private String name;
        /**
         * 学习消耗所需数值
         */
        private int value1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue1() {
            return value1;
        }

        public void setValue1(int value1) {
            this.value1 = value1;
        }
    }
}
