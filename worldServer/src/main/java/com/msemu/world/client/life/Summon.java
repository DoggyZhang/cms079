package com.msemu.world.client.life;

import com.msemu.commons.data.enums.SkillStat;
import com.msemu.commons.data.templates.skill.SkillInfo;
import com.msemu.commons.utils.types.Position;
import com.msemu.world.client.character.AvatarLook;
import com.msemu.world.client.character.Character;
import com.msemu.world.data.SkillData;
import com.msemu.world.enums.Stat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weber on 2018/4/11.
 */
public class Summon extends Life {

    @Getter
    @Setter
    private int charID, skillID, bulletID, maxHP, hp;
    @Getter
    private int summonTerm;
    @Getter
    @Setter
    private byte charLevel, slv, assistType, enterType, teslaCoilState, moveAbility;
    @Getter
    @Setter
    private boolean flyMob, beforeFirstAttack, jaguarActive, attackActive;
    @Getter
    @Setter
    private short curFoothold;
    @Getter
    @Setter
    private AvatarLook avatarLook;
    @Getter
    List<Position> teslaCoilPositions = new ArrayList<>();
    @Getter
    @Setter
    private Position[] kishinPositions = new Position[2];

    public Summon(int objectId) {
        super(objectId);
    }

    public void setSummonTerm(int summonTerm) {
        this.summonTerm = 1000 * summonTerm;
    }

    public static Summon getSummonBy(Character character, int skillID, byte slv) {
        SkillInfo si = SkillData.getInstance().getSkillInfoById(skillID);
        Summon summon = new Summon(-1);
        summon.setCharID(character.getId());
        summon.setSkillID(skillID);
        summon.setSlv(slv);
        summon.setSummonTerm(si.getValue(SkillStat.time, slv));
        summon.setCharLevel((byte) character.getStat(Stat.LEVEL));
        summon.setPosition(character.getPosition().deepCopy());
        summon.setMoveAction((byte) 1);
        summon.setCurFoothold((short) character.getField().findFootHoldBelow(summon.getPosition()).getId());
        summon.setMoveAbility((byte) 1);
        summon.setAssistType((byte) 1);
        summon.setEnterType((byte) 1);
        summon.setBeforeFirstAttack(false);
        summon.setTemplateId(skillID);
        summon.setAttackActive(true);
        return summon;
    }
}