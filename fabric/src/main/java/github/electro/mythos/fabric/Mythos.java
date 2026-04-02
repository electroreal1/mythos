package github.electro.mythos.fabric;

import net.fabricmc.api.ModInitializer;

public final class Mythos implements ModInitializer {
    @Override
    public void onInitialize() {
        github.electro.mythos.Mythos.init();
    }
}
