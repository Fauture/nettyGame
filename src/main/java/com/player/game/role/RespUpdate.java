package com.player.game.role;

import com.player.framework.annotation.message.MessageIgnore;
import com.player.framework.annotation.message.MessageMeta;
import com.player.framework.serializer.Message;
import com.player.server.Cmd;
import com.player.server.Module;
import java.util.List;

//@MessageIgnore()
@MessageMeta(cmd = Cmd.ORIGINAL,module = Module.MSG_UPDATE)
public class RespUpdate extends Message {
    private int roleId;
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

    public void setList(List<FieldValue> list) {
        this.list = list;
    }

    public RespUpdate() {}

    public RespUpdate(int roleId, List<FieldValue> list) {
        this.roleId = roleId;
        this.list = list;
    }
}
