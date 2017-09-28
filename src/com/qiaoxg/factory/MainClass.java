package com.qiaoxg.factory;

import java.util.ArrayList;
import java.util.List;

import com.qiaoxg.factory.bean.People;
import com.qiaoxg.factory.utils.CarFactoryUtils;
import com.qiaoxg.factory.utils.Contants;

/**
 * main 方法
 * 
 * @author admin
 * 
 */
public class MainClass {

	private static List<People> peoples;

	public static void main(String[] args) {

		peoples = initPeopleList();
		toTakeCar();
	}

	private static void toTakeCar() {
		if (peoples.size() > 0) {
			People p = peoples.remove(0);
			String isTaked = CarFactoryUtils.toTakeCar(p);
			if (isTaked != null && !isTaked.equals("")) {
				peoples.add(p);
			}
			try {
				Thread.sleep(0);
				toTakeCar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("所有乘客都已经乘车完毕！！");
		}
	}

	private static List<People> initPeopleList() {

		List<People> list = new ArrayList();
		People p1 = new People();
		p1.setName("Qiaoxg");
		p1.setWantTake(Contants.CAR_TYPE_GOLF);
		p1.setTakeTime(30);

		People p2 = new People();
		p2.setName("Zhangtg");
		p2.setWantTake(Contants.CAR_TYPE_BMW);
		p2.setTakeTime(20);

		People p3 = new People();
		p3.setName("Wangxl");
		p3.setWantTake(Contants.CAR_TYPE_MAZADA);
		p3.setTakeTime(20);

		People p8 = new People();
		p8.setName("===Wangxl");
		p8.setWantTake(Contants.CAR_TYPE_GOLF);
		p8.setTakeTime(10);

		People p4 = new People();
		p4.setName("======Wangxl");
		p4.setWantTake(Contants.CAR_TYPE_MAZADA);
		p4.setTakeTime(25);

		People p5 = new People();
		p5.setName("=========Wangxl");
		p5.setWantTake(Contants.CAR_TYPE_BMW);
		p5.setTakeTime(5);

		People p6 = new People();
		p6.setName("===============Wangxl========");
		p6.setWantTake(Contants.CAR_TYPE_MAZADA);
		p6.setTakeTime(7);

		People p7 = new People();
		p7.setName("======Wangxl=======");
		p7.setWantTake(Contants.CAR_TYPE_GOLF);
		p7.setTakeTime(45);

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);

		return list;
	}
}
