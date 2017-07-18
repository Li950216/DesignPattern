package com.jinwen.singleton;

/**
 * 懒汉式单例模式
 * 
 * author：JIN   
 * time：2017年7月18日 下午6:39:35   
 * @version
 */
public class Singleton2 {
	
	private static Singleton2 instance = null;
	
	//构造函数私有
	private Singleton2(){
		
	}
	
	//静态的获取对象实例的方法
	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();   //如果对象为null，则在这里调用私有的构造方法new对象  否则直接返回对象
		}
		return instance;
	}
	
}
