package com.tntmodders.titaniummod;

import net.minecraft.data.*;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class TitaniumModRecipeProvider extends RecipeProvider {
    public TitaniumModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(TitaniumMod.Blocks.TITANIUM_BLOCK.get())
                .define('#', TitaniumMod.Items.TITANIUM_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_titanium_ingot", has(TitaniumMod.Items.TITANIUM_INGOT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(TitaniumMod.Items.TITANIUM_INGOT.get(), 9)
                .requires(TitaniumMod.Blocks.TITANIUM_BLOCK.get())
                .group("titanium_ingot")
                .unlockedBy("has_titanium_block", has(TitaniumMod.Blocks.TITANIUM_BLOCK.get()))
                .save(consumer, "titaniummod:titanium_ingot_from_titanium_block");
    }
}
