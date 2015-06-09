package com.gmail.fedmanddevv.villagerapi;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R4.EntityVillager;
import net.minecraft.server.v1_7_R4.ItemStack;
import net.minecraft.server.v1_7_R4.MerchantRecipe;
import net.minecraft.server.v1_7_R4.MerchantRecipeList;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftVillager;
import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
import org.bukkit.entity.Villager;

public final class VillagerTradeApi extends JavaPlugin
{


	public static void clearTrades(final Villager villager)
	{

		final EntityVillager entityVillager = ((CraftVillager)villager).getHandle();

		try
		{
			final Field recipes = entityVillager.getClass().getDeclaredField("bu");
			recipes.setAccessible(true);
			recipes.set(entityVillager, new MerchantRecipeList());
		}

		catch (Exception exc) {
			exc.printStackTrace();
		}

	}


	public static void addTrade(final Villager villager, final VillagerTrade villagerTrade)
	{

		final EntityVillager entityVillager = ((CraftVillager)villager).getHandle();

		try
		{
			final Field recipes = entityVillager.getClass().getDeclaredField("bu");
			recipes.setAccessible(true);
			final MerchantRecipeList list = (MerchantRecipeList)recipes.get(entityVillager);
			final ItemStack primaryItem = CraftItemStack.asNMSCopy(VillagerTrade.getPrimaryItem(villagerTrade));

			if (VillagerTrade.hasSecondaryItem(villagerTrade))
			{
				final ItemStack secondaryItem = CraftItemStack.asNMSCopy(VillagerTrade.getSecondaryItem(villagerTrade));
				final ItemStack rewardItem = CraftItemStack.asNMSCopy(VillagerTrade.getRewardItem(villagerTrade));
				list.a(new MerchantRecipe(primaryItem, secondaryItem, rewardItem));
			}

			else
			{
				final ItemStack rewardItem = CraftItemStack.asNMSCopy(VillagerTrade.getRewardItem(villagerTrade));
				list.a(new MerchantRecipe(primaryItem, rewardItem));
			}

			recipes.set(entityVillager, list);
		}

		catch (Exception exc)
		{
			exc.printStackTrace();
		}

	}


}