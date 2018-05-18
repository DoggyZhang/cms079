package com.msemu.world.client.guild;

import com.msemu.commons.database.Schema;
import com.msemu.commons.network.packets.OutPacket;
import com.msemu.commons.utils.types.FileTime;
import com.msemu.core.network.GameClient;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Weber on 2018/4/13.
 */
@Schema
@Entity
public class GuildSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private int id;
    @Column(name = "skillID")
    @Getter
    @Setter
    private int skillID;
    @Column(name = "level")
    @Getter
    @Setter
    private short level;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "expireDate")
    private FileTime expireDate;

    @Column(name = "buyCharacterName")
    @Getter
    @Setter
    private String buyCharacterName;

    @Column(name = "extendCharacterName")
    @Getter
    @Setter
    private String extendCharacterName;

    public void encode(OutPacket<GameClient> outPacket) {
        // GUILDDATA::SKILLENTRY::Decode
        outPacket.encodeShort(getLevel());
        outPacket.encodeFT(getExpireDate());
        outPacket.encodeString(getBuyCharacterName());
        outPacket.encodeString(getExtendCharacterName());
    }

}
