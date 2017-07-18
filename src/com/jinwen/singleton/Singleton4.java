package com.jinwen.singleton;

/**
 * 双重校验锁
 * 
 * author：JIN   
 * time：2017年7月18日 下午6:48:20   
 * @version
 */
public class Singleton4 {
	
	private volatile static Singleton4 instance;
	
	//构造
	private Singleton4(){
		
	}
	
	//静态的获取对象实例的方法
	public static Singleton4 getInstance(){
		
		// 两重判断， 第一重是为了避免不必要的同步，因为频繁的锁会降低系统的性能
		// 第二重是在instance在null情况下才会创建实例
		if(instance == null){
			synchronized (Singleton4.class) {
				if(instance == null){
					instance = new Singleton4();  
				}
			}
		}
		
		return instance;
	}
}
