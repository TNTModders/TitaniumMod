package com.tntmodders.titaniummod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class TitaniumModJaJpLanguageProvider extends LanguageProvider {
    public TitaniumModJaJpLanguageProvider(DataGenerator gen, String modId) {
        super(gen, modId, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add(TitaniumMod.Blocks.TITANIUM_BLOCK.get(), "チタンブロック");
        add(TitaniumMod.Items.TITANIUM_INGOT.get(), "チタンインゴット");
    }
}
