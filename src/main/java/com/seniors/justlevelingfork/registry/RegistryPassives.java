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

public class RegistryPassives {
    // 创建被动技能的注册表
    public static final ResourceKey<Registry<Passive>> PASSIVES_KEY = ResourceKey.createRegistryKey(new ResourceLocation(JustLevelingFork.MOD_ID, "passives"));
    public static final DeferredRegister<Passive> PASSIVES = DeferredRegister.create(PASSIVES_KEY, JustLevelingFork.MOD_ID);
    public static final Supplier<IForgeRegistry<Passive>> PASSIVES_REGISTRY = PASSIVES.makeRegistry(() -> new RegistryBuilder<Passive>().disableSaving());

    // 初始化方法（留空，不注册任何被动技能）
    public static void load(IEventBus eventBus) {
        PASSIVES.register(eventBus);
    }
}
