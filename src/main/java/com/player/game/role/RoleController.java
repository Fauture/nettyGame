package com.player.game.role;

import com.alibaba.fastjson.JSONObject;
import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;


@Controller
public class RoleController {

    @RequestMapping
    public void resUpdate(IdSession session, RespUpdate request) {
//        session.send(request);

        System.err.println(JSONObject.toJSONString(request));
    }

}
