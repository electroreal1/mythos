package github.electro.mythos;

import github.electro.mythos.registry.SkillRegistry;

public final class Mythos {
    public static final String MOD_ID = "Mythos"; //TODO replace template with your mod id

    public static void init() {
        SkillRegistry.init();
    }
}
