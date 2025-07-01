package com.github.aechtrob.prehistoricnature.item;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemHandlerHelper;

import java.util.Random;

public class PNCollectionEnvelope extends Item {
    public PNCollectionEnvelope(Properties properties) {
        super(properties);
    }

//    @Override
//    public InteractionResult useOn(UseOnContext context) {
//        ItemStack itemstack = context.getItemInHand();
//        Player player = context.getPlayer();
//        RandomSource rand = context.getLevel().random;
//        Level worldIn = context.getLevel();
//
//        // First check if there is some tag
//        // If there is, and there is item associated,
//        // just mirror what would happen if the item was clicked
//        // - seeds as well as placing items like lilypads
//
//
//
//        if (itemstack.hasTagCompound()) {
//            NBTTagCompound compound = itemstack.getTagCompound();
//            //System.err.println("NBT: " + compound.toString());
//        }
//
//        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
//        {
//            return EnumActionResult.FAIL;
//        }
//        //else
//        if (itemstack.hasTagCompound()) {
//            if (itemstack.getTagCompound().getString("plant") != null) {
//                if (!itemstack.getTagCompound().getString("plant").equalsIgnoreCase("")) {
//                    ResourceLocation locationBlock = new ResourceLocation(itemstack.getTagCompound().getString("plant"));
//                    Block plantBlock = ForgeRegistries.BLOCKS.getValue(locationBlock);
//
//                    int offsetY = itemstack.getTagCompound().getInteger("offsetY");
//                    boolean willEmpty = rand.nextInt(3) == 0;
//                    if (plantBlock != null && plantBlock != Blocks.AIR) {
//                        boolean doPlacer = false;
//                        //System.err.println("Block: " + plantBlock);
//                        if (plantBlock instanceof SeedSporeReedBase) {
//                            SeedSporeReedBase blockPlant = (SeedSporeReedBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                doPlacer = true;
//                                //System.err.println("Item: " + itemPlant);
//                            }
//                        }
//                        else if (plantBlock instanceof SeedSporeBushBase) {
//                            SeedSporeBushBase blockPlant = (SeedSporeBushBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                doPlacer = true;
//                            }
//                        }
//                        else if (plantBlock instanceof SeedSporeLeavesBase) {
//                            SeedSporeLeavesBase blockPlant = (SeedSporeLeavesBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                doPlacer = true;
//                            }
//                        }
//
//                        //If it's a vine:
//                        if (plantBlock instanceof BlockVine) {
//                            if (offsetY < 1) {
//                                offsetY = 1;
//                            }
//                            IBlockState plantBlockState = plantBlock.getDefaultState().withProperty(BlockVine.UP, false)
//                                    .withProperty(BlockVine.NORTH, false)
//                                    .withProperty(BlockVine.SOUTH, false)
//                                    .withProperty(BlockVine.EAST, false)
//                                    .withProperty(BlockVine.WEST, false);
//                            switch (facing.getIndex()) {
//                                case 2:
//                                    plantBlockState = plantBlockState.withProperty(BlockVine.SOUTH, true);
//                                    break;
//                                case 5:
//                                    plantBlockState = plantBlockState.withProperty(BlockVine.WEST, true);
//                                    break;
//                                case 3:
//                                    plantBlockState = plantBlockState.withProperty(BlockVine.NORTH, true);
//                                    break;
//                                case 4:
//                                    plantBlockState = plantBlockState.withProperty(BlockVine.EAST, true);
//                                    break;
//                                default:
//                                    return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
//                            }
//                            //Get the block clicked on:
//                            if (plantBlockState != null) {
//                                if (worldIn.isEmptyBlock(pos.offset(facing, offsetY)) &&
//                                        plantBlockState.getBlock().canPlaceBlockOnSide(worldIn, pos.offset(facing, offsetY), facing)
//                                ) {
//                                    //We can plant this vine here!
//                                    SoundEvent soundevent = SoundEvents.BLOCK_GRASS_PLACE;
//                                    player.level().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                                    worldIn.setBlock(pos.offset(facing, offsetY), plantBlockState);
//                                    plantBlockState.getBlock().onBlockAdded(worldIn, pos.offset(facing, offsetY), plantBlockState);
//                                    ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                                    if (!player.isCreative() && willEmpty) {
//                                        itemstack.shrink(1);
//                                        ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                                    }
//                                    return EnumActionResult.SUCCESS;
//                                }
//                            }
//                        }
//
//                        //If it's a moss or other directional block:
//                        else if (plantBlock instanceof SeedSporeFacingBlockBase) {
//                            if (worldIn.isEmptyBlock(pos.offset(facing))
//                                    && plantBlock.canPlaceBlockOnSide(worldIn, pos.offset(facing), facing)
//                            ) {
//                                //We can plant this here!
//                                SoundEvent soundevent = SoundEvents.BLOCK_GRASS_PLACE;
//                                player.level().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                                worldIn.setBlock(pos.offset(facing), plantBlock.getDefaultState()
//                                        .withProperty(SeedSporeFacingBlockBase.FACING, facing));
//                                plantBlock.onBlockAdded(worldIn, pos.offset(facing), plantBlock.getDefaultState());
//                                ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                                if (!player.isCreative() && willEmpty) {
//                                    itemstack.shrink(1);
//                                    ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                                }
//                                return EnumActionResult.SUCCESS;
//
//                            }
//                        }
//                        //If it's a floater:
//                        else if (plantBlock instanceof SeedSporeLilyPadBase) {
//                            SeedSporeLilyPadBase blockPlant = (SeedSporeLilyPadBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            ActionResult<ItemStack> result = itemPlant.onItemRightClick(worldIn, player, hand);
//                            //We can plant this here!
//                            ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                            if (!player.isCreative() && willEmpty && result.getType() == EnumActionResult.SUCCESS) {
//                                itemstack.shrink(1);
//                                ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                            }
//                            if (result.getType() == EnumActionResult.SUCCESS) {
//                                return EnumActionResult.SUCCESS;
//                            }
//
//                        }
//                        //If it's not a vine or floater, check if it has a special placing item (some do):
//                        else if (doPlacer && plantBlock instanceof SeedSporeReedBase) {
//                            SeedSporeReedBase blockPlant = (SeedSporeReedBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                EnumActionResult result = itemPlant.onItemUse(player, worldIn, pos, hand, facing, 0.5F, 0F, 0.5F);
//                                ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                                if (!player.isCreative() && willEmpty && result == EnumActionResult.SUCCESS) {
//                                    itemstack.shrink(1);
//                                    ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                                }
//                                if (result == EnumActionResult.SUCCESS) {
//                                    return EnumActionResult.SUCCESS;
//                                }
//                            }
//                        }
//                        else if (doPlacer && plantBlock instanceof SeedSporeBushBase) {
//                            SeedSporeBushBase blockPlant = (SeedSporeBushBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                EnumActionResult result = itemPlant.onItemUse(player, worldIn, pos, hand, facing, 0.5F, 0F, 0.5F);
//                                ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                                if (!player.isCreative() && willEmpty && result == EnumActionResult.SUCCESS) {
//                                    itemstack.shrink(1);
//                                    ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                                }
//                                if (result == EnumActionResult.SUCCESS) {
//                                    return EnumActionResult.SUCCESS;
//                                }
//                            }
//                        }
//                        else if (doPlacer && plantBlock instanceof SeedSporeLeavesBase) {
//                            SeedSporeLeavesBase blockPlant = (SeedSporeLeavesBase) plantBlock;
//                            Item itemPlant = blockPlant.blockItem(); //The item used to place this block
//                            if (itemPlant != null) {
//                                EnumActionResult result = itemPlant.onItemUse(player, worldIn, pos, hand, facing, 0.5F, 0F, 0.5F);
//                                ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                                if (!player.isCreative() && willEmpty && result == EnumActionResult.SUCCESS) {
//                                    itemstack.shrink(1);
//                                    ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                                }
//                                if (result == EnumActionResult.SUCCESS) {
//                                    return EnumActionResult.SUCCESS;
//                                }
//                            }
//                        }
//                        //Or just do the block standards:
//                        else if (facing == EnumFacing.UP && worldIn.isAirBlock(pos.up(offsetY))
//                                && plantBlock.canPlaceBlockAt(worldIn, pos.up(offsetY))
//                        ) {
//                            //We can plant this here!
//                            SoundEvent soundevent = SoundEvents.BLOCK_GRASS_PLACE;
//                            player.getEntityWorld().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                            worldIn.setBlockState(pos.up(offsetY), plantBlock.getDefaultState());
//                            plantBlock.onBlockAdded(worldIn, pos.up(offsetY), plantBlock.getDefaultState());
//                            ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                            if (!player.isCreative() && willEmpty) {
//                                itemstack.shrink(1);
//                                ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                            }
//                            return EnumActionResult.SUCCESS;
//                        }
//
//                    }
//                    //Vanilla ferns:
//                    else if (facing == EnumFacing.UP && worldIn.isAirBlock(pos.up(offsetY))
//                            && Blocks.DOUBLE_PLANT.getStateFromMeta(3).getBlock().canPlaceBlockAt(worldIn, pos.up(offsetY))
//                            && itemstack.getTagCompound().getString("plant").equalsIgnoreCase("large_fern")) {
//                        //We can plant this here!
//                        SoundEvent soundevent = SoundEvents.BLOCK_GRASS_PLACE;
//                        player.getEntityWorld().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                        worldIn.setBlockState(pos.up(offsetY), Blocks.DOUBLE_PLANT.getStateFromMeta(3));
//                        Blocks.DOUBLE_PLANT.getStateFromMeta(3).getBlock().onBlockPlacedBy(worldIn, pos.up(offsetY), Blocks.DOUBLE_PLANT.getStateFromMeta(3), player, itemstack);
//                        ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                        if (!player.isCreative() && willEmpty) {
//                            itemstack.shrink(1);
//                            ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                        }
//                        return EnumActionResult.SUCCESS;
//                    }
//                    else if (facing == EnumFacing.UP && worldIn.isAirBlock(pos.up(offsetY))
//                            && Blocks.TALLGRASS.getStateFromMeta(2).getBlock().canPlaceBlockAt(worldIn, pos.up(offsetY))
//                            && itemstack.getTagCompound().getString("plant").equalsIgnoreCase("small_fern")) {
//                        //We can plant this here!
//                        SoundEvent soundevent = SoundEvents.BLOCK_WATERLILY_PLACE;
//                        player.getEntityWorld().playSound(player, player.getPosition(), soundevent, SoundCategory.BLOCKS, 1.0F, 1.0F);
//                        worldIn.setBlockState(pos.up(offsetY), Blocks.TALLGRASS.getStateFromMeta(2));
//                        ItemStack envelope = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                        if (!player.isCreative() && willEmpty) {
//                            itemstack.shrink(1);
//                            ItemHandlerHelper.giveItemToPlayer(player, envelope);
//                        }
//                        return EnumActionResult.SUCCESS;
//                    }
//                }
//            }
//        }
//
//        if (harvest(itemstack, worldIn, pos, player))
//        {
//            //Update it so that sporing things might stop sporing:
//            worldIn.scheduleUpdate(pos, worldIn.getBlockState(pos).getBlock(), 1);
//
//            return EnumActionResult.SUCCESS;
//        }
//        return EnumActionResult.PASS;
//    }
//
//    public static boolean harvest(ItemStack stack, Level worldIn, BlockPos target, Player player)
//    {
//        if (stack.hasTagCompound()) {
//            if (stack.getTagCompound().getString("plant") != null) {
//                if (!stack.getTagCompound().getString("plant").equalsIgnoreCase("")) {
//                    return false;
//                }
//            }
//        }
//
//        BlockState iblockstate = worldIn.getBlockState(target);
//        Block blockTarget = iblockstate.getBlock();
//        String nbtBlock = "";
//
//        if (!worldIn.isClientSide) {
//            boolean collected = false;
//            ItemEntity entityToSpawn = null;
//            int nbtOffsetY = 0;
//            ItemStack spores = null;
//
//            if (blockTarget instanceof SeedSporeBushBase) {
//                SeedSporeBushBase blockEnvelope = (SeedSporeBushBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeLeavesBase) {
//                SeedSporeLeavesBase blockEnvelope = (SeedSporeLeavesBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeReedBase) {
//                SeedSporeReedBase blockEnvelope = (SeedSporeReedBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeBlockBase) {
//                if (blockTarget == BlockLycopiaTop.block) {
//                    if (iblockstate.getValue(BlockLycopiaTop.VAR) != 0 && iblockstate.getValue(BlockLycopiaTop.VAR) != 1) {
//                        return false;
//                    }
//                }
//                SeedSporeBlockBase blockEnvelope = (SeedSporeBlockBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeVineBase) {
//                SeedSporeVineBase blockEnvelope = (SeedSporeVineBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeLilyPadBase) {
//                SeedSporeLilyPadBase blockEnvelope = (SeedSporeLilyPadBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//            else if (blockTarget instanceof SeedSporeFacingBlockBase) {
//                SeedSporeFacingBlockBase blockEnvelope = (SeedSporeFacingBlockBase) blockTarget;
//                nbtBlock = blockEnvelope.planted().getRegistryName().toString();
//                nbtOffsetY = blockEnvelope.offsetY();
//                collected = true;
//            }
//
//            //Vanilla ferns:
//            else if (blockTarget == Blocks.DOUBLE_PLANT.getStateFromMeta(3).getBlock() && LepidodendronConfig.doPropagationVanilla) {
//                nbtBlock = "large_fern";
//                nbtOffsetY = 1;
//                collected = true;
//            }
//            else if (blockTarget == Blocks.TALLGRASS.getStateFromMeta(2).getBlock() && LepidodendronConfig.doPropagationVanilla) {
//                nbtBlock = "small_fern";
//                nbtOffsetY = 1;
//                collected = true;
//            }
//            //Vanilla vines:
//            else if (blockTarget == Blocks.VINE && LepidodendronConfig.doPropagationVanilla) {
//                nbtBlock = "minecraft:vine";
//                nbtOffsetY = 0;
//                collected = true;
//            }
//
//            if (collected) {
//                stack.shrink(1);
//                spores = new ItemStack(ItemCollectionEnvelope.block, (int) (1));
//                if (!spores.hasTagCompound()) {
//                    spores.setTagCompound(new NBTTagCompound());
//                }
//                spores.getTagCompound().setString("plant", nbtBlock);
//                spores.getTagCompound().setInteger("offsetY", nbtOffsetY);
//                ItemHandlerHelper.giveItemToPlayer(player, spores);
//
//                return true;
//            }
//        }
//
//        return false;
//    }

}