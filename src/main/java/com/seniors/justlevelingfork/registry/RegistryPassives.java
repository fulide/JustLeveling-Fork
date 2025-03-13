package com.seniors.justlevelingfork.registry;

import com.seniors.justlevelingfork.JustLevelingFork;
import com.seniors.justlevelingfork.handler.HandlerCommonConfig;
import com.seniors.justlevelingfork.handler.HandlerResources;
import com.seniors.justlevelingfork.registry.aptitude.Aptitude;
import com.seniors.justlevelingfork.registry.passive.Passive;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class RegistryPassives {
    public static final ResourceKey<Registry<Passive>> PASSIVES_KEY = ResourceKey.createRegistryKey(new ResourceLocation(JustLevelingFork.MOD_ID, "passives"));
    public static final DeferredRegister<Passive> PASSIVES = DeferredRegister.create(PASSIVES_KEY, JustLevelingFork.MOD_ID);
    public static final Supplier<IForgeRegistry<Passive>> PASSIVES_REGISTRY = PASSIVES.makeRegistry(() -> new RegistryBuilder<Passive>().disableSaving());

    // 注册一个 Passive
    private static Passive register(String name, Aptitude aptitude, ResourceLocation texture, Attribute attribute, String attributeUuid, Object attributeValue, int... levelsRequired) {
        ResourceLocation key = new ResourceLocation(JustLevelingFork.MOD_ID, name);
        return new Passive(key, aptitude, texture, attribute, attributeUuid, attributeValue, levelsRequired);
    }

    // 加载注册表
    public static void load(IEventBus eventBus) {
        PASSIVES.register(eventBus);

        // 移除默认的被动技能注册
        // PASSIVES.register("attack_damage", () -> register("attack_damage", Aptitude.COMBAT, HandlerResources.PASSIVE_ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE, Attributes.ATTACK_DAMAGE.getDescriptionId(), HandlerCommonConfig.attackDamage, 5, 10, 15, 20, 25));
        // PASSIVES.register("attack_knockback", () -> register("attack_knockback", Aptitude.COMBAT, HandlerResources.PASSIVE_ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_KNOCKBACK.getDescriptionId(), HandlerCommonConfig.attackKnockback, 5, 10, 15, 20, 25));
        // PASSIVES.register("attack_speed", () -> register("attack_speed", Aptitude.COMBAT, HandlerResources.PASSIVE_ATTACK_SPEED, Attributes.ATTACK_SPEED, Attributes.ATTACK_SPEED.getDescriptionId(), HandlerCommonConfig.attackSpeed, 5, 10, 15, 20, 25));
        // PASSIVES.register("knockback_resistance", () -> register("knockback_resistance", Aptitude.COMBAT, HandlerResources.PASSIVE_KNOCKBACK_RESISTANCE, Attributes.KNOCKBACK_RESISTANCE, Attributes.KNOCKBACK_RESISTANCE.getDescriptionId(), HandlerCommonConfig.knockbackResistance, 5, 10, 15, 20, 25));
        // PASSIVES.register("movement_speed", () -> register("movement_speed", Aptitude.AGILITY, HandlerResources.PASSIVE_MOVEMENT_SPEED, Attributes.MOVEMENT_SPEED, Attributes.MOVEMENT_SPEED.getDescriptionId(), HandlerCommonConfig.movementSpeed, 5, 10, 15, 20, 25));
        // PASSIVES.register("health", () -> register("health", Aptitude.VITALITY, HandlerResources.PASSIVE_HEALTH, Attributes.MAX_HEALTH, Attributes.MAX_HEALTH.getDescriptionId(), HandlerCommonConfig.health, 5, 10, 15, 20, 25));
        // PASSIVES.register("armor", () -> register("armor", Aptitude.VITALITY, HandlerResources.PASSIVE_ARMOR, Attributes.ARMOR, Attributes.ARMOR.getDescriptionId(), HandlerCommonConfig.armor, 5, 10, 15, 20, 25));
        // PASSIVES.register("armor_toughness", () -> register("armor_toughness", Aptitude.VITALITY, HandlerResources.PASSIVE_ARMOR_TOUGHNESS, Attributes.ARMOR_TOUGHNESS, Attributes.ARMOR_TOUGHNESS.getDescriptionId(), HandlerCommonConfig.armorToughness, 5, 10, 15, 20, 25));
        // PASSIVES.register("luck", () -> register("luck", Aptitude.LUCK, HandlerResources.PASSIVE_LUCK, Attributes.LUCK, Attributes.LUCK.getDescriptionId(), HandlerCommonConfig.luck, 5, 10, 15, 20, 25));
        // PASSIVES.register("mining_speed", () -> register("mining_speed", Aptitude.MINING, HandlerResources.PASSIVE_MINING_SPEED, ForgeMod.BLOCK_REACH.get(), ForgeMod.BLOCK_REACH.get().getDescriptionId(), HandlerCommonConfig.miningSpeed, 5, 10, 15, 20, 25));
    }

    // 根据名称获取 Passive
    public static Passive getPassive(String passiveName) {
        return PASSIVES_REGISTRY.get().getValues().stream()
                .collect(Collectors.toMap(Passive::getName, p -> p))
                .get(passiveName);
    }
}
