package cobalt.minecraft.entity;

import cobalt.enums.CEnumHand;
import cobalt.minecraft.entity.player.CPlayer;
import cobalt.minecraft.util.math.CPos;
import cobalt.minecraft.world.CWorld;
import lombok.Getter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.StringTextComponent;

import java.util.Optional;
import java.util.UUID;

public class CEntity {
    @Getter private final Entity mcEntity;
    @Getter private final CWorld world;

    protected CEntity(Entity entity) {
        this.mcEntity = entity;
        this.world = entity != null ? CWorld.fromMC(entity.world) : null;
    }

    public static CEntity fromMC(Entity entity) {
        return new CEntity(entity);
    }

    public double getPosX() {
        return mcEntity.getX();
    }
    public double getPosY() {
        return mcEntity.getY();
    }
    public double getPosZ() {
        return mcEntity.getZ();
    }

    public CPos getPosition() {
        return new CPos(getPosX(), getPosY(), getPosZ());
    }

    public void sendMessage(String message) {
        mcEntity.sendMessage(new StringTextComponent(message), getUniqueID());
    }

    public boolean attackFrom(DamageSource source, float amount) {
        return mcEntity.isAttackable();
    }

    public String getName() {
        return mcEntity.getName().getString();
    }

    public UUID getUniqueID() {
        return mcEntity.getUUID();
    }

    public void dropItem(ItemStack stack, float offsetY) {
        mcEntity.entityDropItem(stack, offsetY);
    }

    public boolean isPlayer() {
        return this.mcEntity instanceof PlayerEntity;
    }

    public Optional<CPlayer> asPlayer() {
        if (this.mcEntity instanceof PlayerEntity) {
            return Optional.of((CPlayer)this);
        } else {
            return Optional.empty();
        }
    }
}
