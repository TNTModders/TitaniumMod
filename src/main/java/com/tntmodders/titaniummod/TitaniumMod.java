package com.tntmodders.titaniummod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// 「META-INF/mods.toml」に記載されたMOD IDと一致する必要がある。
@Mod("titaniummod")
public class TitaniumMod {
    /**
     * ロガーのインスタンス。
     */
    private static final Logger LOGGER = LogManager.getLogger();

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new Block(Block.Properties
                    .create(Material.IRON, MaterialColor.IRON)
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1))
                    .setRegistryName("titanium_block"));
        }

        @SuppressWarnings("ConstantConditions")
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(Blocks.TITANIUM_BLOCK, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS))
                    .setRegistryName("titanium_block"));
            event.getRegistry().register(new Item(new Item.Properties()
                    .group(ItemGroup.MATERIALS))
                    .setRegistryName("titanium_ingot"));
        }
    }

    @ObjectHolder("titaniummod")
    public static class Blocks {
        public static final Block TITANIUM_BLOCK = null;
    }

    @ObjectHolder("titaniummod")
    public static class Items {
        public static final Item TITANIUM_BLOCK = null;
        public static final Item TITANIUM_INGOT = null;
    }
}
