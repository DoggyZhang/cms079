/*
 * MIT License
 *
 * Copyright (c) 2018 msemu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.msemu.world.enums;

import com.msemu.world.constants.FieldConstants;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weber on 2018/5/12.
 */
public enum QuickMoveInfo {

    弓箭手村(100000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    魔法森林(101000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    勇士之村(102000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    墮落城市(103000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    維多利亞港(104000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    奇幻村(105000000, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    鯨魚號(120000100, QuickMoveNpcInfo.大陸移動碼頭.getValue() | QuickMoveNpcInfo.計程車.getValue()),
    耶雷弗(130000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    瑞恩(140000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    天空之城(200000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    玩具城(220000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    地球防禦總部(221000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    童話村(222000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    水世界(230000000, 0),
    神木村(240000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    桃花仙境(250000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    靈藥幻境(251000000, 0),
    納希沙漠(260000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    瑪迦提亞城(261000000, 0),
    埃德爾斯坦(310000000, QuickMoveNpcInfo.大陸移動碼頭.getValue()),
    萬神殿(400000000, 0);
    @Getter
    public final static long GLOBAL_NPC
            = QuickMoveNpcInfo.次元傳送門.getValue()
            | QuickMoveNpcInfo.聚合功能.getValue();
    @Getter
    private final int fieldID;
    @Getter
    private final long npcFlag;
    @Getter
    private final long generalNpc
            = QuickMoveNpcInfo.怪物公園.getValue()
            | QuickMoveNpcInfo.次元之鏡.getValue()
            | QuickMoveNpcInfo.自由市場.getValue()
            | QuickMoveNpcInfo.梅斯特鎮.getValue()
            | QuickMoveNpcInfo.打工.getValue()
            | QuickMoveNpcInfo.皇家美髮.getValue()
            | QuickMoveNpcInfo.皇家整形.getValue()
            | QuickMoveNpcInfo.琳.getValue()
            //            | QuickMoveNpcInfo.楓之谷拍賣場.getValue()
            | QuickMoveNpcInfo.初音未來.getValue();

    QuickMoveInfo(int fieldID, long npcFlag) {
        this.fieldID = fieldID;
        this.npcFlag = npcFlag | generalNpc;
    }

    public static QuickMoveInfo getByFieldID(int fieldID) {
        for (QuickMoveInfo qm : QuickMoveInfo.values()) {
            if (qm.getFieldID() == fieldID) {
                return qm;
            }
        }
        return null;
    }

    public static List<QuickMoveNpcInfo> getVisibleQuickMoveNpcs(int fieldID) {
        QuickMoveInfo quickMoveInfo = QuickMoveInfo.getByFieldID(fieldID);
        List<QuickMoveNpcInfo> quickMoveNpcInfos = new ArrayList<>();
        if (quickMoveInfo != null) {
            for (QuickMoveInfo qm : QuickMoveInfo.values()) {
                if (qm.getFieldID() == fieldID) {
                    long npcs = qm.getNpcFlag();
                    for (QuickMoveNpcInfo npc : QuickMoveNpcInfo.values()) {
                        if (npc.check(npcs) && npc.show(fieldID) && !npc.check(QuickMoveInfo.GLOBAL_NPC)) {
                            quickMoveNpcInfos.add(npc);
                        }
                    }
                    break;
                }
            }
            if (QuickMoveInfo.GLOBAL_NPC != 0 && !FieldConstants.isBossMap(fieldID) && !FieldConstants.isTutorialMap(fieldID) && (fieldID / 100 != 9100000 || fieldID == 910000000)) {
                for (QuickMoveNpcInfo npc : QuickMoveNpcInfo.values()) {
                    if (npc.check(QuickMoveInfo.GLOBAL_NPC) && npc.show(fieldID)) {
                        quickMoveNpcInfos.add(npc);
                    }
                }
            }
        }
        return quickMoveNpcInfos;
    }
}
