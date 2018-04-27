package br.github.superteits.brasille.mobs;

import java.util.Set;

import br.teits.brasille.utils.ReflectionHandler;
import net.minecraft.server.v1_11_R1.EntityPig;
import net.minecraft.server.v1_11_R1.GenericAttributes;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.PathfinderGoalSelector;
import net.minecraft.server.v1_11_R1.World;


public class PorcoDoTutorial extends EntityPig{

	public PorcoDoTutorial(World world) {
		super(world);
		this.setCustomName("Porco do Tutorial");
		this.getBukkitEntity().addScoreboardTag("Exp:3");
		this.expToDrop = 0;
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(5.0D);
		this.getAttributeInstance(GenericAttributes.maxHealth).setValue(50.0D);
		this.setHealth(50.0F);
		((Set<?>)ReflectionHandler.getPrivateField("b", PathfinderGoalSelector.class, goalSelector)).clear();
		((Set<?>)ReflectionHandler.getPrivateField("b", PathfinderGoalSelector.class, targetSelector)).clear();
		((Set<?>)ReflectionHandler.getPrivateField("c", PathfinderGoalSelector.class, goalSelector)).clear();
		((Set<?>)ReflectionHandler.getPrivateField("c", PathfinderGoalSelector.class, targetSelector)).clear();
		this.a(this.getBoundingBox().grow(0.0D, 2.0D, 0.0D));
		NBTTagCompound compound = new NBTTagCompound();
		this.c(compound);
		compound.setString("DeathLootTable", "brasille:entities/porcoDoTutorial");
		this.a(compound);
	}
	
	/*@EventHandler
    @Override
	public void onDeath(EntityDeathEvent death) {
		if(death.getEntity().getCustomName() != null) {
			if(death.getEntity().getKiller() != null) {
				if(death.getEntity().getCustomName().equals(getName())) {
					System.out.println("porco");
					//LevelHandler.rewardExp(death.getEntity().getKiller(), 3);
					if(ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 25)
						death.getDrops().add(BrasilleItems.ArcoDoAprendiz.createItem());
					//MachadoDoAprendiz
					else if(ThreadLocalRandom.current().nextInt(1, 100 + 1) >= 26 && ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 50)
						death.getDrops().add(BrasilleItems.MachadoDoAprendiz.createItem());
					//EspadaDoAprendiz
					else if(ThreadLocalRandom.current().nextInt(1, 100 + 1) >= 51 && ThreadLocalRandom.current().nextInt(1, 100 + 1) <= 75)
						death.getDrops().add(BrasilleItems.EspadaDoAprendiz.createItem());
					//CaldeiraoDoAprendiz
					else
						death.getDrops().add(BrasilleItems.CaldeiraoDoAprendiz.createItem());
				}
			}
		}
	}
	

	public void createEntity(World world, Location location) {
		Pig pig = (Pig) world.spawnEntity(location, EntityType.PIG);
		pig.setCustomName("Porco do Tutorial");
		pig.setCustomNameVisible(true);
		pig.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(5.0D);
	}
	
	public String getName() {
		return "Porco do Tutorial";
	}*/

}
