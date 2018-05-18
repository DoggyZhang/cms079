package com.msemu.world.enums;

import com.msemu.world.client.character.quest.req.QuestProgressItemRequirement;
import com.msemu.world.client.character.quest.req.QuestProgressLevelRequirement;
import com.msemu.world.client.character.quest.req.QuestProgressMobRequirement;
import com.msemu.world.client.character.quest.req.QuestProgressMoneyRequirement;

import java.util.Arrays;

/**
 * Created by Weber on 2018/4/13.
 */
public enum QuestProgressRequirementType {
    ITEM(0),
    LEVEL(1),
    MOB(2),
    MONEY(3);

    private byte val;

    QuestProgressRequirementType(int val) {
        this.val = (byte) val;
    }

    public static QuestProgressRequirementType getQPRTByObj(Object o) {
        return o instanceof QuestProgressItemRequirement ? ITEM :
                o instanceof QuestProgressLevelRequirement ? LEVEL :
                        o instanceof QuestProgressMobRequirement ? MOB :
                                o instanceof QuestProgressMoneyRequirement ? MONEY : null;
    }

    public static QuestProgressRequirementType getQPRTByVal(byte val) {
        return Arrays.stream(QuestProgressRequirementType.values())
                .filter(qprt -> qprt.getVal() == val).findFirst().orElse(null);
    }

    public byte getVal() {
        return val;
    }

}
