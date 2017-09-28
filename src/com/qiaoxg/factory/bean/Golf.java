package com.qiaoxg.factory.bean;

public class Golf implements Car {
	
	boolean isBusy = false;

	public boolean run(final People p) {
		if (!isBusy) {
			isBusy = true;
			Thread thread = new Thread(new Runnable() {

				public void run() {
					for (int i = p.getTakeTime(); i > 0; i--) {
						System.out.println(p.getName() + " : 开始乘坐Golf，还有 "
								+ i + " 秒结束！");
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					isBusy = false;

				}
			});
			thread.start();
		} else {
			System.out.println(p.getName() + " : 正在乘坐Golf，请稍后！");
		}
		
		return isBusy;
	}
}
