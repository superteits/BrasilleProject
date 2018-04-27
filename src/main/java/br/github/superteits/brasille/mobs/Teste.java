package br.github.superteits.brasille.mobs;

import net.minecraft.server.v1_11_R1.EntityZombie;
import net.minecraft.server.v1_11_R1.World;

public class Teste extends EntityZombie{

	public Teste(World world) {
		super(world);
		this.setCustomName("Reflection Success");
		this.getBukkitEntity().addScoreboardTag("Exp:3");
		this.getBukkitEntity().addScoreboardTag("debug1");
		this.getBukkitEntity().addScoreboardTag("debug2");
		for(String tag : this.getBukkitEntity().getScoreboardTags()) {
			System.out.println(tag);
		}
		
	}

	/*public Teste(Location loc) {
		super(((CraftWorld)loc.getWorld()).getHandle());
		this.setPosition(loc.getX(), loc.getY(),loc.getZ());
		this.setSize(0.5f, 0.5f);
	}*/

}
