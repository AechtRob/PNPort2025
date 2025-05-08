package com.github.aechtrob.prehistoricnature.block.blockbase;

import com.github.aechtrob.prehistoricnature.PrehistoricNature;
import com.github.aechtrob.prehistoricnature.entity.block.blockentitybase.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

public class PNStandingSignBlock extends StandingSignBlock {
    public PNStandingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        LootParams lootparams = params.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
        ServerLevel serverlevel = lootparams.getLevel();
        ResourceKey<LootTable> loottableKey = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PrehistoricNature.MODID, "blocks/lepidodendron_sign"));
        LootTable loottable = serverlevel.getServer().reloadableRegistries().getLootTable(loottableKey);
        return loottable.getRandomItems(lootparams);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModSignBlockEntity(pos, state);
    }
}
