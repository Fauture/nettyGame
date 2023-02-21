package com.player.game.role;

import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;

import java.util.List;

//@MessageIgnore()
@MessageMeta(cmd = Cmd.ORIGINAL, module = Module.MSG_UPDATE_IMPROVEMENT)
public class ResUpdateImprovement extends Message {
    /**
     * id
     */
    private int roleId;
    /**
     * 属性数据
     */
    private List<FieldValue> list;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<FieldValue> getList() {
        return list;
    }

    /**
     * 查询属性
     * @param id
     * @return
     */
    public FieldValue getField(int id) {
        for (FieldValue field : list) {
            if (field.getField() == (short) id) {
                return field;
            }
        }
        return null;
    }

    public void setList(List<FieldValue> list) {
        this.list = list;
    }

    public ResUpdateImprovement() {
    }

    public ResUpdateImprovement(int roleId, List<FieldValue> list) {
        this.roleId = roleId;
        this.list = list;
    }
}
