package com.gmail.fedmanddev;

import org.bukkit.plugin.java.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import java.lang.reflect.*;
import org.bukkit.craftbukkit.v1_7_R4.inventory.*;
import net.minecraft.server.v1_7_R4.*;

public final class VillagerTradeApi extends JavaPlugin
{
    public void onEnable() {
        System.out.print("[VillagerTradeApi] Enabled VillagerTradeApi by Fedmand");
    }
    
    public static void clearTrades(final Villager villager) {
        final EntityVillager entityVillager = ((CraftVillager)villager).getHandle();
        try {
            final Field recipes = entityVillager.getClass().getDeclaredField("bu");
            recipes.setAccessible(true);
            final MerchantRecipeList list = new MerchantRecipeList();
            recipes.set(entityVillager, list);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public static void addTrade(final Villager villager, final VillagerTrade villagerTrade) {
        final EntityVillager entityVillager = ((CraftVillager)villager).getHandle();
        try {
            final Field recipes = entityVillager.getClass().getDeclaredField("bu");
            recipes.setAccessible(true);
            final MerchantRecipeList list = (MerchantRecipeList)recipes.get(entityVillager);
            if (VillagerTrade.hasSecondaryItem(villagerTrade)) {
                final ItemStack item1 = CraftItemStack.asNMSCopy(VillagerTrade.getPrimaryItem(villagerTrade));
                final ItemStack item2 = CraftItemStack.asNMSCopy(VillagerTrade.getSecondaryItem(villagerTrade));
                final ItemStack rewardItem = CraftItemStack.asNMSCopy(VillagerTrade.getRewardItem(villagerTrade));
                list.a(new MerchantRecipe(item1, item2, rewardItem));
            }
            else {
                final ItemStack item1 = CraftItemStack.asNMSCopy(VillagerTrade.getPrimaryItem(villagerTrade));
                final ItemStack rewardItem2 = CraftItemStack.asNMSCopy(VillagerTrade.getRewardItem(villagerTrade));
                list.a(new MerchantRecipe(item1, rewardItem2));
            }
            recipes.set(entityVillager, list);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
