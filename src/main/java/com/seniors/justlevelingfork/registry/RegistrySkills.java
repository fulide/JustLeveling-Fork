package com.seniors.justlevelingfork.registry;

import com.seniors.justlevelingfork.JustLevelingFork;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

import java.util.function.Supplier;

public class RegistrySkills {
    // 创建技能的注册表
    public static final ResourceKey<Registry<Skill>> SKILLS_KEY = ResourceKey.createRegistryKey(new ResourceLocation(JustLevelingFork.MOD_ID, "skills"));
    public static final DeferredRegister<Skill> SKILLS = DeferredRegister.create(SKILLS_KEY, JustLevelingFork.MOD_ID);
    public static final Supplier<IForgeRegistry<Skill>> SKILLS_REGISTRY = SKILLS.makeRegistry(() -> new RegistryBuilder<Skill>().disableSaving());

    // 初始化方法（留空，不注册任何技能）
    public static void load(IEventBus eventBus) {
        SKILLS.register(eventBus);
    }
}
