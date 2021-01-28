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
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(TitaniumMod.Blocks.TITANIUM_BLOCK.get())
                .key('#', TitaniumMod.Items.TITANIUM_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_titanium_ingot", hasItem(TitaniumMod.Items.TITANIUM_INGOT.get()))
                .build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(TitaniumMod.Items.TITANIUM_INGOT.get(), 9)
                .addIngredient(TitaniumMod.Blocks.TITANIUM_BLOCK.get())
                .setGroup("titanium_ingot")
                .addCriterion("has_titanium_block", hasItem(TitaniumMod.Blocks.TITANIUM_BLOCK.get()))
                .build(consumer, "titaniummod:titanium_ingot_from_titanium_block");
    }
}
