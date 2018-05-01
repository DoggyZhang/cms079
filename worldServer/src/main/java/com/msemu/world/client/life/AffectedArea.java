package com.msemu.world.client.life;

import com.msemu.commons.data.templates.skill.SkillInfo;
import com.msemu.commons.utils.types.Rect;
import com.msemu.world.client.character.AttackInfo;
import com.msemu.world.client.character.Character;
import com.msemu.world.client.character.skills.Option;
import com.msemu.world.client.character.skills.Skill;
import com.msemu.world.client.character.skills.TemporaryStatManager;
import com.msemu.world.client.life.skills.MobTemporaryStat;
import com.msemu.world.data.SkillData;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Weber on 2018/4/11.
 */
public class AffectedArea extends Life {

    @Getter
    @Setter
    private Rect rect;
    @Getter
    @Setter
    private int charID, skillID, force, option, elemAttr, idk;
    @Getter
    @Setter
    private byte slv, mobOrigin;
    @Getter
    @Setter
    private short delay;
    @Getter
    @Setter
    private boolean flip;

    public AffectedArea(int objectId) {
        super(objectId);
    }

    public static AffectedArea getAffectedArea(AttackInfo attackInfo) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(attackInfo.skillId);
        aa.setSlv(attackInfo.slv);
        aa.setElemAttr(attackInfo.elemAttr);
        aa.setForce(attackInfo.force);
        aa.setOption(attackInfo.option);
        return aa;
    }

    public static AffectedArea getPassiveAA(int skillID, byte slv) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(skillID);
        aa.setSlv(slv);

        return aa;
    }

    public void handleMobInside(Mob mob) {
        Character chr = getField().getCharByID(getCharID());
        if(chr == null) {
            return;
        }
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        int skillID = getSkillID();
        Skill skill = chr.getSkill(getSkillID());
        byte slv = getSlv();
        SkillInfo si = SkillData.getInstance().getSkillInfoById(skillID);
        MobTemporaryStat mts = mob.getTemporaryStat();
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch(skillID) {
//            case Magician.POISON_MIST:
//            case Archer.FLAME_SURGE:
//            case Kanna.NIMBUS_CURSE:
//                if(!mts.hasBurnFromSkill(skillID)) {
//                    mts.createAndAddBurnedInfo(getCharID(), skill, 1);
//                }
//                break;
//            case Shade.SPIRIT_TRAP:
//                o.nOption = 1;
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.Freeze, o);
//                break;
//            case Thief.FRAILTY_CURSE:
//                o.nOption = si.getValue(SkillStat.y, slv);
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.Speed, o);
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.PAD, o);
//                mts.addStatOptionsAndBroadcast(MobStat.PDR, o);
//                mts.addStatOptionsAndBroadcast(MobStat.MAD, o);
//                mts.addStatOptionsAndBroadcast(MobStat.MDR, o);
//                break;
//            case Zero.TIME_DISTORTION:
//                o.nOption = 1;
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.Freeze, o);
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.AddDamParty, o1);
//                o1.nOption = 1;
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobStat.MagicCrash, o1);
//                break;
        }
    }

    public void handleCharInside(Character chr) {
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        if(tsm.hasAffectedArea(this)) {
            return;
        }
        tsm.addAffectedArea(this);
        int skillID = getSkillID();
        byte slv = getSlv();
        SkillInfo si = SkillData.getInstance().getSkillInfoById(skillID);
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch(skillID) {
//            case Zero.TIME_DISTORTION:
//                o1.nOption = 1;
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                //tsm.putCharacterStatValue(DISPEL, o1);  TODO Removes Debuffs
//                o2.nReason = skillID;
//                o2.nValue = si.getValue(indieBooster, slv);
//                o2.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBooster, o2); //Indie
//                break;
//            case BlazeWizard.BURNING_CONDUIT:
//                o1.nReason = skillID;
//                o1.nValue = si.getValue(indieDamR, slv);
//                o1.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieDamR, o1); //Indie
//                o2.nReason = skillID;
//                o2.nValue = si.getValue(indieBooster, slv);
//                o2.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBooster, o2); //Indie
//                break;
//            case Kanna.BELLFLOWER_BARRIER:
//                o1.nReason = skillID;
//                o1.nValue = si.getValue(bdR, slv);
//                o1.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBDR, o1); //Indie
//                break;
//            case Kanna.BLOSSOM_BARRIER:
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                tsm.putCharacterStatValue(DamageReduce, o1);
//                o2.nOption = si.getValue(SkillStat.y, slv);
//                o2.rOption = skillID;
//                tsm.putCharacterStatValue(AsrR, o2);
//                tsm.putCharacterStatValue(TerR, o2);
//                break;
//            case Aran.MAHAS_DOMAIN:
//                // 20% HP/MP Recovery
//                // Dispel
//                break;
        }
        tsm.sendSetStatPacket();
    }
}