package github.electro.mythos.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import github.electro.mythos.ability.unique_skills.Hyperborean;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class SkillRegistry {

    public static final RegistrySupplier<ManasSkill> HYPERBOREAN = register("hyperborean", Hyperborean::new);

    private static <E extends ManasSkill> RegistrySupplier<E> register(String name, Supplier<E> supplier) {
        return io.github.manasmods.manascore.skill.impl.SkillRegistry.SKILLS.register(ResourceLocation.fromNamespaceAndPath("mythos", name), supplier);
    }

    public static void init() {
    }
}
