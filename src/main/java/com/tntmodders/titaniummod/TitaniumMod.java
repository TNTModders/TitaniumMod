package com.tntmodders.titaniummod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TitaniumMod.MOD_ID)
public class TitaniumMod {
    public static final String MOD_ID = "titaniummod";
    private static final Logger LOGGER = LogManager.getLogger();

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEventSubscriber {
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(Blocks.TITANIUM_BLOCK);
        }

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(Items.TITANIUM_BLOCK, Items.TITANIUM_INGOT);
        }

        @SubscribeEvent
        public static void registerProviders(final GatherDataEvent event) {
            DataGenerator gen = event.getGenerator();
            if (event.includeClient()) {
                gen.addProvider(new TitaniumModBlockStateProvider(gen, MOD_ID, event.getExistingFileHelper()));
                gen.addProvider(new TitaniumModItemModelProvider(gen, MOD_ID, event.getExistingFileHelper()));
                gen.addProvider(new TitaniumModEnUsLanguageProvider(gen, MOD_ID));
                gen.addProvider(new TitaniumModJaJpLanguageProvider(gen, MOD_ID));
            }
            if (event.includeServer()) {
                gen.addProvider(new TitaniumModRecipeProvider(gen));
                gen.addProvider(new TitaniumModLootTableProvider(gen));
            }
        }
    }

    public static class Blocks {
        public static final Block TITANIUM_BLOCK = new Block(Block.Properties
                .create(Material.IRON, MaterialColor.IRON)
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1))
                .setRegistryName("titanium_block");
    }

    public static class Items {
        public static final Item TITANIUM_BLOCK = new BlockItem(Blocks.TITANIUM_BLOCK, new Item.Properties()
                .group(ItemGroup.BUILDING_BLOCKS))
                .setRegistryName("titanium_block");

        public static final Item TITANIUM_INGOT = new Item(new Item.Properties()
                .group(ItemGroup.MATERIALS))
                .setRegistryName("titanium_ingot");
    }
}
