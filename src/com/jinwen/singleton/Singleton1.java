package com.jinwen.singleton;

/**
 * 饿汉式
 * author：JIN   
 * time：2017年7月18日 下午6:33:19   
 * @version
 */
public class Singleton1{
	
	private static final Singleton1 instance = new Singleton1();
	
	/**
	 * 构造函数设成私有，只允许获取实例的方法调用
	 */
	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance(){
		return instance;
	}
	
	/**
	 * 饿汉式单例模式    线程安全     测试在Client类中
	 */
}
