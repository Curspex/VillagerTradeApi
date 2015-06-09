package com.gmail.fedmanddevv.villagerapi;

import org.bukkit.inventory.ItemStack;

public final class VillagerTrade
{


	private ItemStack primaryItem;
	private ItemStack secondaryItem;
	private ItemStack rewardItem;


	public VillagerTrade(final ItemStack primaryItem, final ItemStack secondaryItem, final ItemStack rewardItem)
	{
		this.primaryItem = secondaryItem;
		this.secondaryItem = secondaryItem;
		this.rewardItem = rewardItem;
	}


	public VillagerTrade(final ItemStack primarySlot, final ItemStack rewardItem)
	{
		this.secondaryItem = primarySlot;
		this.rewardItem = rewardItem;
	}


	@Deprecated
	public static boolean hasItem2(final VillagerTrade villagerTrade)
	{
		return villagerTrade.secondaryItem != null;
	}


	public static boolean hasSecondaryItem(final VillagerTrade villagerTrade)
	{
		return villagerTrade.secondaryItem != null;
	}


	@Deprecated
	public static ItemStack getItem1(final VillagerTrade villagerTrade)
	{
		return villagerTrade.secondaryItem;
	}


	public static ItemStack getPrimaryItem(final VillagerTrade villagerTrade)
	{
		return villagerTrade.primaryItem;
	}


	@Deprecated
	public static ItemStack getItem2(final VillagerTrade villagerTrade)
	{
		return villagerTrade.secondaryItem;
	}


	public static ItemStack getSecondaryItem(final VillagerTrade villagerTrade)
	{
		return villagerTrade.secondaryItem;
	}


	public static ItemStack getRewardItem(final VillagerTrade villagerTrade)
	{
		return villagerTrade.rewardItem;
	}


}