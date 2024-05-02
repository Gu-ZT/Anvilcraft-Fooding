package dev.anvilcraft.fooding.events.effects;

import dev.anvilcraft.fooding.events.tag.ModFoodTags;
import dev.anvilcraft.fooding.init.others.ModPlayerStatistics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Seafood implements FoodType{

    @Override
    public ResourceLocation getCunterResourceLocation() {
        return ModPlayerStatistics.SEAFOODCOUNTER;
    }

    @Override
    public ResourceLocation getJudgeResourceLocation() {
        return ModPlayerStatistics.SEAFOODJUDGE;
    }
    @Override
    public void effect(@NotNull ItemStack itemStack,Level level, ServerPlayer serverPlayer){
        if (itemStack.is(ModFoodTags.SEAFOOD)){
            int l = 0;
            int num=serverPlayer.getStats().getValue(Stats.CUSTOM,getCunterResourceLocation());
            for (;num>=1;num=num/ FoodType.judgeNum){
                l=l+1;
            }
            if (serverPlayer.getStats().getValue(Stats.CUSTOM,getJudgeResourceLocation())==1){
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.SATURATION,10*l,1));
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE,15*l,1));
            }
            if (serverPlayer.getStats().getValue(Stats.CUSTOM,getJudgeResourceLocation())==2){
                float currentHealth = serverPlayer.getHealth();
                float newHealth = currentHealth - 2.0f*l;
                serverPlayer.setHealth(newHealth);
                serverPlayer.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,20*l,1));
            }
        }
    }
}
