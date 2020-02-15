package com.tntmodders.titaniummod;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;

import java.util.Objects;

@MethodsReturnNonnullByDefault
public class TitaniumModItemModelProvider extends ItemModelProvider {
    public TitaniumModItemModelProvider(DataGenerator gen, String modId, ExistingFileHelper existingFileHelper) {
        super(gen, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(TitaniumMod.Blocks.TITANIUM_BLOCK);
        simpleItem(TitaniumMod.Items.TITANIUM_INGOT);
    }

    protected void simpleItem(Item item) {
        ResourceLocation name = item.getRegistryName();
        Objects.requireNonNull(name);
        singleTexture(name.getPath(), mcLoc(ITEM_FOLDER + "/generated"), "layer0", new ResourceLocation(name.getNamespace(), ITEM_FOLDER + "/" + name.getPath()));
    }

    protected void simpleBlockItem(Block block) {
        ResourceLocation name = block.getRegistryName();
        Objects.requireNonNull(name);
        withExistingParent(name.getPath(), new ResourceLocation(name.getNamespace(), BLOCK_FOLDER + "/" + name.getPath()));
    }

    @Override
    public String getName() {
        return "Titanium Mod Items";
    }
}
