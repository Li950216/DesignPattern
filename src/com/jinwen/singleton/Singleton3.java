package com.jinwen.singleton;

/**
 * 静态内部类
 * 
 * author：JIN   
 * time：2017年7月18日 下午6:44:35   
 * @version
 */
public class Singleton3 {
	
	private static class SingletonHolder{
		private static final Singleton3 instance = new Singleton3();
	}
	
	private Singleton3(){
		
	}

	//静态的获取对象实例的方法
	public static final Singleton3 getInstance(){
		return SingletonHolder.instance;
	}
}
