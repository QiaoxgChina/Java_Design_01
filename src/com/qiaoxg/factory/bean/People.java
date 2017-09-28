package com.qiaoxg.factory.bean;

public class People {

	private String name;// 姓名
	private int wantTake;// 想坐的车类型
	private int takeTime;// 坐多长时间

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWantTake() {
		return wantTake;
	}

	public void setWantTake(int wantTake) {
		this.wantTake = wantTake;
	}

	public int getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(int takeTime) {
		this.takeTime = takeTime;
	}

}
