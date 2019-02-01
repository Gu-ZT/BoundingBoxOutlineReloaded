package com.irtimaled.bbor.client;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerData {
    private static double x;
    private static double y;
    private static double z;
    private static double activeY;

    static void setPlayerPosition(double partialTicks, EntityPlayer entityPlayer) {
        x = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * partialTicks;
        y = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * partialTicks;
        z = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * partialTicks;
    }

    static void setActiveY() {
        activeY = y;
    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static double getZ() {
        return z;
    }

    public static double getMaxY(double configMaxY) {
        if (configMaxY == -1) {
            return activeY;
        } else if ((configMaxY == 0) || (y < configMaxY)) {
            return y;
        }
        return configMaxY;
    }
}