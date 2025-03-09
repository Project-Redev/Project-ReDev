package net.roadkill.redev.common.entity.arrows;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.roadkill.redev.ReDev;
import net.roadkill.redev.core.init.ItemInit;
import org.joml.Vector3f;

public class BouncingArrowEntity extends CustomArrowsBaseEntity {


  public Integer NrOfBounces =0;
    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ItemInit.BOUNCING_ARROW.get());
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInit.BOUNCING_ARROW.get());
    }




  public BouncingArrowEntity(EntityType type, Level level) {
      super(type, level);
      this.setBaseDamage(this.getBaseDamage() + 2.0d);

  }


    @Override
    protected void setInGround(boolean p_381705_) {
        if(this.NrOfBounces > 5)
             super.setInGround(p_381705_);
    }

    @Override
    protected void onHitBlock(BlockHitResult result)
    {
        if(this.NrOfBounces++ < 5)
        {
       var realVectorsDir = new Vector3f((float)this.getDeltaMovement().x,(float)this.getDeltaMovement().y,(float)this.getDeltaMovement().z);
       var realVectorsNormal = snapToCardinal(realVectorsDir).normalize();

        var RealReflectedVec =  realVectorsDir.reflect(realVectorsNormal).normalize();//.mul(new Vector3f((float)this.getDeltaMovement().x,
               // (float)this.getDeltaMovement().y, (float)this.getDeltaMovement().z));
            ReDev.LOGGER.debug("ARROW HIT");
            this.setDeltaMovement(  RealReflectedVec.x ,RealReflectedVec.y ,RealReflectedVec.z );
            this.setPos(this.position().add( new Vec3  (RealReflectedVec.x ,RealReflectedVec.y ,RealReflectedVec.z ).normalize()));//;

        }
        else {
             if (!this.isInGround()) this.level().explode(this, Explosion.getDefaultDamageSource(this.level(), this), null, this.getX(), this.getY(0.0625), this.getZ(),3, false, Level.ExplosionInteraction.TNT);

            super.onHitBlock(result);
        }

    }
    public static Vector3f snapToCardinal(Vector3f v) {
        float absX = Math.abs(v.x);
        float absY = Math.abs(v.y);
        float absZ = Math.abs(v.z);

        Vector3f snapped = new Vector3f(0, 0, 0);

        if (absX > absY && absX > absZ) {
            snapped.x = Math.signum(v.x);  // East (+1) or West (-1)
        } else if (absZ > absX && absZ > absY) {
            snapped.z = Math.signum(v.z);  // North (+1) or South (-1)
        } else {
            snapped.y = Math.signum(v.y);  // Up (+1) or Down (-1)
        }
        return snapped;
    }

}
