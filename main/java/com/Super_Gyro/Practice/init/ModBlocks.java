package com.Super_Gyro.Practice.init;

import com.Super_Gyro.Practice.Reference;
import com.Super_Gyro.Practice.blocks.BlockBasic;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {
	
	static Block tutorialblock;
	static Block tutorialore;
	static Block tutorialoremultiple;
	
	public static void init() {
		tutorialblock = new BlockBasic("tutorialblock", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setLightLevel(1.0f);
		tutorialblock.setHarvestLevel("pickaxe", 2);
		tutorialore = new BlockBasic("tutorialore", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		tutorialore.setHarvestLevel("pickaxe", 2);
		tutorialoremultiple = new BlockBasic("tutorialoremultiple", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		tutorialoremultiple.setHarvestLevel("pickaxe", 2);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(tutorialblock);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(tutorialblock).setRegistryName(tutorialblock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialore).setRegistryName(tutorialore.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialoremultiple).setRegistryName(tutorialoremultiple.getRegistryName()));	
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(tutorialblock));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
