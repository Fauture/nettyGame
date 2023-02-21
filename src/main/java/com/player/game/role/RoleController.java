package com.player.game.role;

import com.alibaba.fastjson.JSONObject;
import com.player.framework.annotation.message.Controller;
import com.player.framework.annotation.message.RequestMapping;
import com.player.framework.net.IdSession;


@Controller
public class RoleController {

    /**
     * 角色数据
     *
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void resUpdate(IdSession session, ResUpdate request) {
        session.send(request);
        session.getCharData().setId(request.getRoleId());
        /**好像只有整体数据才会有名字,所以用是否存在名字判断**/
        if (request.getField(1) != null) {
            /**查询角色名称**/
            System.err.println(request.getField(1).getValue());
            session.getCharData().setField(request.getList());
        }
        System.err.println(JSONObject.toJSONString(request));
    }

    /**
     * 附加数据
     *
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void resUpdateImprovement(IdSession session, ResUpdateImprovement request) {
        session.send(request);
        System.err.println(JSONObject.toJSONString(request));
    }

    /**
     * 拥有技能
     *
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void resSkill(IdSession session, ResSkill request) {
        session.send(request);
//        session.getCharData().addSkill(request.getId(),request);
        System.err.println(JSONObject.toJSONString(request));
    }

    /**
     * 学习技能
     *
     * @param session
     * @param request 该条不能重复
     */
    @RequestMapping
    public void reqUpSkill(IdSession session, ReqUpSkill request) {
        session.c_send(request);
        System.err.println(JSONObject.toJSONString(request));

    }

}
