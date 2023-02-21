package com.player.server;

public interface Module {

    /**
     * npc对话
     */
    int MSG_MENU_LIST = 8247;
    /**
     * 点击npc选项
     */
    int CMD_SELECT_MENU_ITEM = 4162;
    /**
     * 点击npc选项
     */
    int CMD_SELECT_MENU_ITEM_2 = 12490;
    /**
     * 关闭NPC对话框
     */
    int MSG_MENU_CLOSED = 11731;
    /**
     * 返回横幅提示
     */
    int MSG_DIALOG_OK = 8165;
    /**
     * 聊天
     */
    int CMD_CHAT_EX = 15076;
    /**
     * 角色属性
     */
    int MSG_UPDATE = 14833;
    /**
     * 技能
     */
    int MSG_UPDATE_SKILLS = 10273;
    /**
     * 附加属性 有角色 有宠物
     */
    int MSG_UPDATE_IMPROVEMENT = 64001;
    /**
     * 学习技能
     */
    int CMD_UP_SKILLS = 8546;//学技能

}
