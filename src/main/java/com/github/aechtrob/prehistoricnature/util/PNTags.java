package com.github.aechtrob.prehistoricnature.util;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class PNTags {

    public static class Blocks {

    }

    public static class Items {
        public static final TagKey<Item> REVIVED_PLANT = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "revived_plant"));
        public static final TagKey<Item> REVIVED_STATIC = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "revived_static"));
        public static final TagKey<Item> REVIVED_VERTEBRATE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "revived_vertebrate"));
        public static final TagKey<Item> REVIVED_INVERTEBRATE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "revived_invertebrate"));
        public static final TagKey<Item> REVIVABLE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "revivable"));

        public static final TagKey<Item> FOSSIL_CARBONIFEROUS_PLANT = ItemTags.create(ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "fossil_carboniferous_plant"));

    }

}
