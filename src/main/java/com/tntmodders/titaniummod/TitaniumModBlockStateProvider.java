package com.tntmodders.titaniummod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class TitaniumModBlockStateProvider extends BlockStateProvider {
    public TitaniumModBlockStateProvider(DataGenerator gen, String modId, ExistingFileHelper exFileHelper) {
        super(gen, modId, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(TitaniumMod.Blocks.TITANIUM_BLOCK);
    }
}
