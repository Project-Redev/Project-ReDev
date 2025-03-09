package net.roadkill.redev.core.damageTypes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.roadkill.redev.ReDev;

public class DamageTypes {

    public static final ResourceKey<DamageType> IGNORE_ARMOR =
            ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(ReDev.MOD_ID, "ignore_armor"));


}
