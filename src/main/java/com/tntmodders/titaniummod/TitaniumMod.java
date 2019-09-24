package com.tntmodders.titaniummod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new Item(new Item.Properties()
                    .group(ItemGroup.MATERIALS))
                    .setRegistryName("titanium_ingot"));
        }
    }

    @ObjectHolder("titaniummod")
    public static class Items {
        public static final Item TITANIUM_INGOT = null;
    }
}
