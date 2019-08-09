package net.redstoneparadox.nicetohave.mixin.recipe;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BrewingRecipeRegistry.class)
public interface BrewingRecipeRegistryAccessor{

    @Invoker
    @SuppressWarnings("PublicStaticMixinMember")
    public static void invokeRegisterPotionRecipe(Potion potion, Item item, Potion potion2){
        //NOOP
    }

}
