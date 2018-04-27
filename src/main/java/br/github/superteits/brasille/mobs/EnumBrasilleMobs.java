package br.github.superteits.brasille.mobs;

import br.github.superteits.brasille.utils.ReflectionHandler;

public enum EnumBrasilleMobs {
	
	PorcoDoTutorial(90, "porcodotutorial", PorcoDoTutorial.class, "PorcoDoTutorial");
	
	int id;
	String key;
	Class<? extends Entity> theclass;
	String name;
	
	EnumBrasilleMobs(int id, String key, Class<? extends Entity> theclass, String name) {
		this.id = id;
		this.key = key;
		this.theclass = theclass;
		this.name = name;
	}
	
	public static void registerMobs() {
		ReflectionHandler.addMob(PorcoDoTutorial.id, PorcoDoTutorial.key, PorcoDoTutorial.theclass, PorcoDoTutorial.name);
	}

}
