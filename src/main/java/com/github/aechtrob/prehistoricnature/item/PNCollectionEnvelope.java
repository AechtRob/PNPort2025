package com.github.aechtrob.prehistoricnature.item;

import com.github.aechtrob.prehistoricnature.block.interfaces.IEnvelopable;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.sounds.SoundSource;

import java.util.Arrays;
import java.util.List;

public class PNCollectionEnvelope extends Item {
    public PNCollectionEnvelope(Properties properties) {
        super(properties);
    }

    private static ItemStack getProperties(final ItemStack stack) {
        ItemContainerContents contents = stack.getOrDefault(
                DataComponents.CONTAINER,
                null
        );
        if (contents == null) {
            return ItemStack.EMPTY;
        }
        if (contents.stream().count() == 0) {
            return ItemStack.EMPTY;
        }
        return contents.getStackInSlot(0);
    }

    private static void setProperties(final ItemStack stack, final ItemStack properties) {
        ItemStack contentsStack = properties.copyWithCount(1);
        List<ItemStack> items = Arrays.asList(contentsStack);
        ItemContainerContents contents = ItemContainerContents.fromItems(items);
        stack.set(DataComponents.CONTAINER, contents);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        if (context.getLevel().isClientSide) {
            return super.useOn(context);
        }

        //First - if the envelope is empty:
        ItemStack stack = context.getItemInHand();
        if (stack.getItem() != this) {
            return super.useOn(context);
        }
        if (getProperties(stack).isEmpty()) {
            //Try to collect:
            BlockState blockStateClicked = context.getLevel().getBlockState(context.getClickedPos());
            if (blockStateClicked.getBlock() instanceof IEnvelopable) {
                ItemStack collectStack = ((IEnvelopable)blockStateClicked.getBlock()).envelopeMimicsItemPlacement();
                if (!collectStack.isEmpty()) {
                    ItemStack stackCollected = new ItemStack(this, 1);
                    setProperties(stackCollected, collectStack);
                    if (!context.getPlayer().isCreative()) {
                        stack.shrink(1);
                    }
                    SoundEvent soundevent = SoundEvents.ITEM_PICKUP;
                    context.getLevel().playSound(null, context.getClickedPos(), soundevent, SoundSource.NEUTRAL, 1.0F, 1.0F);
                    boolean addInv = context.getPlayer().getInventory().add(stackCollected);
                    if (!addInv) {
                        ItemEntity itemEntity = new ItemEntity(context.getLevel(), context.getPlayer().getX(), context.getPlayer().getY() + 0.5, context.getPlayer().getZ(), stackCollected);
                        context.getLevel().addFreshEntity(itemEntity);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
            return super.useOn(context);
        }
        ItemStack stackClick = getProperties(stack);
        InteractionResult result = stackClick.getItem().useOn(context);
        if (!context.getPlayer().isCreative() && result == InteractionResult.SUCCESS) {
            SoundEvent soundevent = SoundEvents.GRASS_PLACE;
            context.getLevel().playSound(null, context.getClickedPos(), soundevent, SoundSource.NEUTRAL, 1.0F, 1.0F);
            boolean addInv = context.getPlayer().getInventory().add(new ItemStack(ModItems.COLLECTION_ENVELOPE.get(), 1));
            if ((!addInv)) {
                ItemStack envelopeReturn = new ItemStack(this, 1);
                ItemEntity itemEntity = new ItemEntity(context.getLevel(), context.getPlayer().getX(), context.getPlayer().getY() + 0.5, context.getPlayer().getZ(), envelopeReturn);
                context.getLevel().addFreshEntity(itemEntity);
            }
        }
        return result;
    }


}