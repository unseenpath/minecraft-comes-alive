package cobalt.minecraft.entity;

import cobalt.enums.CEnumHand;
import cobalt.minecraft.item.CItemStack;
import lombok.Getter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class CLivingEntity extends CEntity {
    @Getter private LivingEntity mcEntity;
    @Getter private World mcWorld;

    protected CLivingEntity(LivingEntity entity) {
        super(entity);
        this.mcEntity = entity;
        this.mcWorld = entity.level;
    }

    public static CLivingEntity fromMC(LivingEntity entity) {
        return new CLivingEntity(entity);
    }
    public CItemStack getHeldItem(CEnumHand hand) {
        return CItemStack.fromMC(mcEntity.getMainHandItem());
    }
}
