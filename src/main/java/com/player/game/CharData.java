package com.player.game;

import com.player.game.role.FieldValue;
import com.player.game.role.ResSkill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharData {

    private int id;

    private Map<Integer, ResSkill> skill = new HashMap<>();

    private List<FieldValue> field = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FieldValue> getField() {
        return field;
    }

    public void setField(List<FieldValue> field) {
        this.field = field;
    }

    public Map<Integer, ResSkill> getSkill() {
        return skill;
    }

    public void setSkill(Map<Integer, ResSkill> skill) {
        this.skill = skill;
    }

    public void addSkill(int id, ResSkill resSkill) {
        skill.put(id, resSkill);
    }
}
