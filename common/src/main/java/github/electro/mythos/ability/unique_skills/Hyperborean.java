package github.electro.mythos.ability.unique_skills;

import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.registry.skill.ResistanceSkills;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Hyperborean extends Skill {
    public Hyperborean() {
        super(SkillType.UNIQUE);
    }

    @Override
    public @Nullable MutableComponent getName() {
        return Component.literal("Hyperborean");
    }

    @Override
    public MutableComponent getSkillDescription() {
        return Component.literal("Born in harshly cold conditions, you've been attuned to the element of ice.");
    }

    @Override
    public boolean canTick(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        if (TensuraDamageHelper.isCold(source)) {
            float originalDmg = Objects.requireNonNull(amount.get()).floatValue();
            amount.set(originalDmg * (instance.isMastered(owner) ? 2 : 1));
            return true;
        }
        return true;
    }

    @Override
    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        if (instance.isTemporarySkill()) return;

        SkillHelper.learnSkill(entity, ResistanceSkills.COLD_RESISTANCE.get());
    }

    @Override
    public boolean onTouchEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        if (!instance.isToggled()) return false;
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 2));
        return true;
    }
}
