package com.qiaoxg.factory.bean;

/**
 * 采用单例模式
 * 
 * @author admin
 * 
 */
public class BMW implements Car {

	boolean isBusy = false;

	private static BMW instance;

	// 将构造函数改为private，禁止从外部进行实例化
	private BMW() {
	}

	// 同一时间只能允许一个外部对象调用此函数，加锁
	public static synchronized BMW getInatance() {
		if (instance == null) {
			instance = new BMW();
		}
		return instance;
	}

	public boolean run(final People p) {
		if (!isBusy) {
			isBusy = true;
			Thread thread = new Thread(new Runnable() {

				public void run() {
					for (int i = p.getTakeTime(); i > 0; i--) {
						System.out.println(p.getName() + " : 开始乘坐BMW，还有 " + i
								+ " 秒结束！");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					isBusy = false;

				}
			});
			thread.start();
		} else {
			System.out.println(p.getName() + " : 正在乘坐BMW，请稍后！");
		}

		return isBusy;
	}

}
