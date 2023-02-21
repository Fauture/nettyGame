package com.player.game.npc;

import com.alibaba.fastjson.JSONObject;
import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;
import com.player.game.chat.RespMsg;


@Controller
public class NpcController {

    /**
     * 打开npc对话
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void resNpcContent(IdSession session, ResNpcContent request) {
        System.err.println(JSONObject.toJSONString(request));
        if ("钱大富".equals(request.getName())) {
            request.setName("钱小富");
            request.setText(request.getText() + "[钱]");
            session.send(request);
        } else if ("活动大使".equals(request.getName())) {
            request.setText("当前NPC不可用[离开]");
            session.send(request);
        } else {
            session.send(request);
        }

    }

    @RequestMapping
    public void reqNpcTalk(IdSession session, ReqNpcTalk request) {
        System.err.println("1_" + JSONObject.toJSONString(request));
        npcTalk(session, request.getNpcTalk(), 1);
    }

    @RequestMapping
    public void reqNpcTalk(IdSession session, ReqNpcTalk_2 request) {
        System.err.println("2_" + JSONObject.toJSONString(request));
        npcTalk(session, request.getNpcTalk(), 2);
    }

    /**
     * 对话选项
     *
     * @param session
     * @param request 该条不能重复
     * @param type    包头类型,有好几种对话选项包头
     */
    public void npcTalk(IdSession session, NpcTalk request, int type) {
        if ("钱".equals(request.getMsg())) {
            session.send(new RespMsg("测试消息"));
//            RespUpdate respUpdate = new RespUpdate();
//            respUpdate.setRoleId(38921);
//            respUpdate.setList(new LinkedList<>());
//            respUpdate.getList().add(new FieldValue(27, 3, 10000));
//            session.send(respUpdate);
//            System.err.println(JSONObject.toJSONString(respUpdate));
        } else {
            session.c_send(type == 1 ? new ReqNpcTalk(request) : new ReqNpcTalk_2(request));
        }

    }


}
