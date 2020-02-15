package com.tntmodders.titaniummod;

import net.minecraft.advancements.criterion.MinMaxBounds;
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
        ShapedRecipeBuilder.shapedRecipe(TitaniumMod.Blocks.TITANIUM_BLOCK)
                .key('#', TitaniumMod.Items.TITANIUM_INGOT)
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_at_least_9_titanium_ingot", hasItem(MinMaxBounds.IntBound.atLeast(9), TitaniumMod.Items.TITANIUM_INGOT))
                .build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(TitaniumMod.Items.TITANIUM_INGOT, 9)
                .addIngredient(TitaniumMod.Blocks.TITANIUM_BLOCK)
                .setGroup("titanium_ingot")
                .addCriterion("has_at_least_9_titanium_ingot", hasItem(MinMaxBounds.IntBound.atLeast(9), TitaniumMod.Items.TITANIUM_INGOT))
                .addCriterion("has_titanium_block", hasItem(TitaniumMod.Blocks.TITANIUM_BLOCK))
                .build(consumer, "titaniummod:titanium_ingot_from_titanium_block");
    }
}
