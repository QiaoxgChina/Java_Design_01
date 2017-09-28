package com.qiaoxg.factory.utils;

import com.qiaoxg.factory.bean.BMW;
import com.qiaoxg.factory.bean.Car;
import com.qiaoxg.factory.bean.Golf;
import com.qiaoxg.factory.bean.Mazada;
import com.qiaoxg.factory.bean.People;

/**
 * ������������ʲô�����˽��������ҵ��Լ�������ĳ�
 * 
 * @author admin
 * 
 */
public class CarFactoryUtils {

	private static BMW bmw;
	private static Golf golf;
	private static Mazada mazada;

	/**
	 * �˳�
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
				msg = "BMW ����ʹ��";
			}
		} else if (p.getWantTake() == Contants.CAR_TYPE_GOLF) {
			if (golf == null) {
				golf = new Golf();
			}
			boolean isTaked = !golf.run(p);
			if (isTaked) {
				msg = "Golf ����ʹ��";
			}
		} else if (p.getWantTake() == Contants.CAR_TYPE_MAZADA) {
			if (mazada == null) {
				mazada = new Mazada();
			}
			boolean isTaked = !mazada.run(p);
			if (isTaked) {
				msg = "Mazada ����ʹ��";
			}
		} else {
			msg = "ô�иó˿���Ҫ�����ĳ���" + p.getWantTake();
		}
		return msg;

	}

	/**
	 * ���÷������
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
