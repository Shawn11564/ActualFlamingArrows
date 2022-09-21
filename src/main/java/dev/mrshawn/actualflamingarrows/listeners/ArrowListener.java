package dev.mrshawn.actualflamingarrows.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowListener implements Listener {

	@EventHandler
	public void onArrowHit(ProjectileHitEvent event) {
		if (event.getHitBlock() == null || event.getHitBlockFace() == null) {
			return;
		}

		if (event.getEntity().getType() != EntityType.ARROW) {
			return;
		}

		AbstractArrow arrow = (AbstractArrow) event.getEntity();

		if (arrow.getFireTicks() <= 0) {
			return;
		}

		Block hitBlock = event.getHitBlock();
		Block adjacentBlock = hitBlock.getRelative(event.getHitBlockFace());

		if (adjacentBlock.getType().isAir()) {
			adjacentBlock.setType(Material.FIRE);

			// make fire appear on the side of the block it hit

			if (event.getHitBlockFace().getOppositeFace() == BlockFace.DOWN) {
				return;
			}

			if (!(adjacentBlock.getBlockData() instanceof Fire)) {
				return;
			}

			Fire fire = (Fire) adjacentBlock.getBlockData();
			fire.setFace(event.getHitBlockFace().getOppositeFace(), true);
			adjacentBlock.setBlockData(fire);
		}
	}

}
