package com.tntmodders.titaniummod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

@Mod(TitaniumMod.MOD_ID)
public class TitaniumMod {
    public static final String MOD_ID = "titaniummod";

    public TitaniumMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Blocks.register(modEventBus);
        Items.register(modEventBus);
        modEventBus.addListener(this::registerProviders);
    }

    private void registerProviders(GatherDataEvent event) {
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

    public static class Blocks {
        private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
        public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(AbstractBlock.Properties
                .of(Material.METAL, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
        ));

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }

        public static Collection<RegistryObject<Block>> getEntries() {
            return BLOCKS.getEntries();
        }
    }

    public static class Items {
        private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final RegistryObject<Item> TITANIUM_BLOCK = ITEMS.register("titanium_block", () -> new BlockItem(Blocks.TITANIUM_BLOCK.get(), new Item.Properties()
                .tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()
                .tab(ItemGroup.TAB_MATERIALS)));

        public static void register(IEventBus eventBus) {
            ITEMS.register(eventBus);
        }
    }
}
