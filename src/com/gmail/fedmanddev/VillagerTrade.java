package com.gmail.fedmanddev;

import org.bukkit.inventory.*;

public final class VillagerTrade
{
    private ItemStack item1;
    private ItemStack item2;
    private ItemStack rewardItem;
    
    public VillagerTrade(final ItemStack item1, final ItemStack item2, final ItemStack rewardItem) {
        this.item1 = item1;
        this.item2 = item2;
        this.rewardItem = rewardItem;
    }
    
    public VillagerTrade(final ItemStack item1, final ItemStack rewardItem) {
        this.item1 = item1;
        this.rewardItem = rewardItem;
    }
    
    public static boolean hasItem2(final VillagerTrade villagerTrade) {
        return villagerTrade.item2 != null;
    }
    
    public static ItemStack getItem1(final VillagerTrade villagerTrade) {
        return villagerTrade.item1;
    }
    
    public static ItemStack getItem2(final VillagerTrade villagerTrade) {
        return villagerTrade.item2;
    }
    
    public static ItemStack getRewardItem(final VillagerTrade villagerTrade) {
        return villagerTrade.rewardItem;
    }
}
