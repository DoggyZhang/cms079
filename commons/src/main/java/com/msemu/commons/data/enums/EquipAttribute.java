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

package com.msemu.commons.data.enums;

/**
 * Created by Weber on 2018/4/13.
 */
public enum EquipAttribute {
    // 封印
    LOCKED(0x1),
    // 防滑
    SPIKES(0x02),
    // 防寒
    COLD(0x04),
    // 不可交易
    UNTRADABLE(0x8),
    // 只能交易一次
    KARMA(0x10),
    // 已經裝備獲得魅力
    CHARM_EQUIPPED(0x20),
    // 機器人激活
    ANDROID_ACTIVATED(0x40),
    // 道具最下方的"製作者:"
    CRAFTED(0x80),
    // 裝備防爆
    PROTECTION_SCROLL(0x100),
    // 幸運捲軸
    LUCKY_DAY(0x200),
    // 可以在帳號內交換1次
    KARMA_ACC(0x1000),
    // 保護升級次數
    UPGRADE_COUNT_PROTECTION(0x2000),
    // 捲軸防護
    SCROLL_PROTECTION(0x4000),
    // 套用恢復捲軸效果
    RETURN_SCROLL(0x8000),

    // 楓方塊可剪刀一次狀態
    MAPLE_CUBE(0x40000000),;
    private int value;

    EquipAttribute(final int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
