package com.qiaoxg.factory.bean;

/**
 * ���õ���ģʽ
 * 
 * @author admin
 * 
 */
public class BMW implements Car {

	boolean isBusy = false;

	private static BMW instance;

	// �����캯����Ϊprivate����ֹ���ⲿ����ʵ����
	private BMW() {
	}

	// ͬһʱ��ֻ������һ���ⲿ������ô˺���������
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
						System.out.println(p.getName() + " : ��ʼ����BMW������ " + i
								+ " �������");
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
			System.out.println(p.getName() + " : ���ڳ���BMW�����Ժ�");
		}

		return isBusy;
	}

}
