package com.msemu.world.client.character.effect;

import com.msemu.commons.network.packets.OutPacket;
import com.msemu.core.network.GameClient;
import com.msemu.world.enums.UserEffectType;

/**
 * Created by Weber on 2018/5/3.
 */
public class FieldExpItemConsumedUserEffect implements IUserEffect {

    private int expValue;

    public FieldExpItemConsumedUserEffect(int expValue) {
        this.expValue = expValue;
    }

    @Override
    public UserEffectType getType() {
        return UserEffectType.FieldExpItemConsumed;
    }

    @Override
    public void encode(OutPacket<GameClient> outPacket) {
        outPacket.encodeInt(expValue);
    }
}
