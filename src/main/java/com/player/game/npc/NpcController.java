package com.player.game.npc;

import com.alibaba.fastjson.JSONObject;
import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;
import com.player.server.message.RespMsg;


@Controller
public class NpcController {

    @RequestMapping
    public void resNpcContent(IdSession session, ResNpcContent request) {
        System.err.println(JSONObject.toJSONString(request));
        if ("钱大富".equals(request.getName())) {
            request.setName("钱小富");
            request.setText(request.getText() + "[钱]");
        }
        session.send(request);
    }

    @RequestMapping
    public void reqNpcTalk(IdSession session, ReqNpcTalk request) {
        System.err.println("1_" + JSONObject.toJSONString(request));
        session.c_send(request);
        npcTalk(session, request.getNpcTalk());
    }

    @RequestMapping
    public void reqNpcTalk(IdSession session, ReqNpcTalk_2 request) {
        System.err.println("2_" + JSONObject.toJSONString(request));
        session.c_send(request);
        npcTalk(session, request.getNpcTalk());
    }

    public void npcTalk(IdSession session, NpcTalk request) {
        if ("钱".equals(request.getMsg())) {
//            RespNpcLeave respNpcLeave = new RespNpcLeave();
//            respNpcLeave.setNpcId(request.getNpcId());
//            session.send(respNpcLeave);
            session.send(new RespMsg("测试消息"));
        }

    }


}
