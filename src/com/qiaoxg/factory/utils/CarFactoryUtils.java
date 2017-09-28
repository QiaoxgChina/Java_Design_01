package com.qiaoxg.factory.utils;

import com.qiaoxg.factory.bean.BMW;
import com.qiaoxg.factory.bean.Car;
import com.qiaoxg.factory.bean.Golf;
import com.qiaoxg.factory.bean.Mazada;
import com.qiaoxg.factory.bean.People;

/**
 * 车工厂，不管什么样的人进来都能找到自己想乘坐的车
 * 
 * @author admin
 * 
 */
public class CarFactoryUtils {

	private static BMW bmw;
	private static Golf golf;
	private static Mazada mazada;

	/**
	 * 乘车
	 * 
	 * @param p
	 * @return
	 */
	public static String toTakeCar(People p) {
		String msg = "";
		if (p.getWantTake() == Contants.CAR_TYPE_BMW) {
			if (bmw == null) {
				bmw = BMW.getInatance();
			}
			boolean isTaked = !bmw.run(p);
			if (isTaked) {
				msg = "BMW 正在使用";
			}
		} else if (p.getWantTake() == Contants.CAR_TYPE_GOLF) {
			if (golf == null) {
				golf = new Golf();
			}
			boolean isTaked = !golf.run(p);
			if (isTaked) {
				msg = "Golf 正在使用";
			}
		} else if (p.getWantTake() == Contants.CAR_TYPE_MAZADA) {
			if (mazada == null) {
				mazada = new Mazada();
			}
			boolean isTaked = !mazada.run(p);
			if (isTaked) {
				msg = "Mazada 正在使用";
			}
		} else {
			msg = "么有该乘客想要乘坐的车：" + p.getWantTake();
		}
		return msg;

	}

	/**
	 * 利用反射机制
	 * 
	 * @param clazz
	 * @return
	 */
	public static Object getClass(Class<? extends Car> clazz) {
		Object obj = null;

		try {
			obj = Class.forName(clazz.getName()).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return obj;
	}

}
