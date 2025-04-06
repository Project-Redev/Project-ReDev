package net.roadkill.redev.common.entity.arrows;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.roadkill.redev.core.init.ItemInit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Doesnt update the chunks after placing the amethysts
public class HomingArrowEntity extends CustomArrowsBaseEntity {



    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.AMETHYST_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.AMETHYST_ARROW.get());
    }




    public HomingArrowEntity(EntityType type, Level level) {
        super(type, level);
        this.setBaseDamage(this.getBaseDamage() + 2.0d);

    }

    @Override
    protected void onHitBlock(BlockHitResult result)
    {
       var pos = result.getBlockPos();
       AABB area = new AABB(pos.offset(-2,-2,-2).getCenter(), pos.offset(2,2,2).getCenter());
        Map<Vec3i, BlockState> states = new HashMap<>();

        for(int x = (int) area.minX; x <= (int)area.maxX ; x+=1)
           for(int y = (int) area.minY; y <= (int)area.maxY ; y+=1)
               for(int z = (int) area.minZ; z <= (int)area.maxZ ; z+=1)
               {
                   states.put(new Vec3i(x,y,z) ,level().getBlockState(new BlockPos(x,y,z)));
               }

        Map<Vec3i, BlockState> validStates = new HashMap<>();

        states.forEach((key,state)->{
            var blockBelow = states.get(new Vec3i(key.getX(),key.getY()-1, key.getZ() ));
            if(state==null || blockBelow== null)
                return;
            if(state.isAir() && !blockBelow.isAir() && random.nextIntBetweenInclusive(0,10) <= 2)
            {
                validStates.put(key,state);
            }
        });

        Set<Vec3i> ChunkToUpdate = new HashSet<>();
        validStates.forEach((key,state) ->
        {
            level().setBlock(new BlockPos(key), Blocks.AMETHYST_CLUSTER.defaultBlockState(), 0 );
            ChunkToUpdate.add(key);

        });
        //Level updejt chunks form teh ChunkToUpdate set on client
        if(level().isClientSide)
        {
            ChunkToUpdate.forEach((key) ->
            {
                level().getChunkAt(new BlockPos(key)).tryMarkSaved();
            });

        }

        this.discard();
    }



}
