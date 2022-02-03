package com.falsepattern.jarloader.plugin;

import net.minecraft.launchwrapper.Launch;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import ru.timeconqueror.spongemixins.MinecraftURLClassPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.nio.file.Files.walk;

public class MixinPlugin implements IMixinConfigPlugin {

    static {
        try {
            System.out.println("Loading all jars!");
            walk(new File(Launch.minecraftHome, "mods/").toPath())
                    .map(Path::toFile)
                    .filter((file) -> file.getName().endsWith(".jar"))
                    .forEach(pathToJar -> {
                        try {
                            MinecraftURLClassPath.addJar(pathToJar);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoad(String mixinPackage) {

    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    // This method return a List<String> of mixins. Every mixins in this list will be loaded.
    @Override
    public List<String> getMixins() {
        return Collections.emptyList();
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
