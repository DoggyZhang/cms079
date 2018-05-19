package com.msemu.commons.data.wz.structures;

/**
 * Created by Weber on 2018/4/20.
 */
public class Foothold {

    public int x1, x2, y1, y2;
    public int prev, next;
    public int num, layer;

    public Foothold(int x1, int x2, int y1, int y2, int num, int layer)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        next = 0;
        prev = 0;
        this.num = num;
        this.layer = layer;
    }

    public boolean IsWall()
    {
        return x1 == x2;
    }
}
