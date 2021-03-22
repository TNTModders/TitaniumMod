package com.tntmodders.titaniummod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class TitaniumModEnUsLanguageProvider extends LanguageProvider {
    public TitaniumModEnUsLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(TitaniumMod.Blocks.TITANIUM_BLOCK.get(), "Block of Titanium");
        add(TitaniumMod.Items.TITANIUM_INGOT.get(), "Titanium Ingot");
    }
}
