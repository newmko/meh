package org.hasoi.meh.client.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    @Inject(method = "getName", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void getName(RegistryEntry<Enchantment> enchantment, int level, CallbackInfoReturnable<Text> cir, MutableText mutableText){
        if (((Enchantment)enchantment.value()).getMaxLevel() == level) {
            mutableText.setStyle(Style.EMPTY.withColor(Formatting.GOLD));
        } else if(((Enchantment)enchantment.value()).getMaxLevel() < level) {
            mutableText.setStyle(Style.EMPTY.withColor(Formatting.GOLD).withFormatting(Formatting.BOLD));
        }
    }

}

