package br.github.superteits.brasille.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.server.v1_11_R1.Entity;
import net.minecraft.server.v1_11_R1.EntityTypes;

public class ReflectionHandler {
	//Method to get private and internal minecraft methods
	public static Method getPrivateMethod(String name, Class<?> theclass, Class<?>... params) {
		try {
			Method method = theclass.getDeclaredMethod(name, params);
			method.setAccessible(true);
			return method;
		}
		catch(NoSuchMethodException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	////Method to get private and internal minecraft fields
	public static Object getPrivateField(String name, Class<?> theclass, Object fi) {
		try {
			Field field = theclass.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(fi);
		}
		catch(NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
		catch(IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Method to add mobs to register
	public static void addMob(int id, String key, Class<? extends Entity> theclass, String name) {
		try{
		getPrivateMethod("a", EntityTypes.class, int.class, String.class, Class.class, String.class)
			.invoke(EntityTypes.class, id, key, theclass, name);
		}
		catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		catch(InvocationTargetException i) {
			i.printStackTrace();
		}
	}
	

}
