package com.jinwen.singleton;

import java.util.concurrent.CountDownLatch;

public class Client {
	
	private static int count = 100;       //规定的线程数
	private static long jobCountPerThread = 1000L;      //每个线程作业数

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		test1();   // 饿汉式测试
		test2();   //懒汉式
		test3();   //静态内部类
		test4();   //双重校验锁
		test5();   //枚举
		test6();   //在同一种情况下直接传统技术new一个对象出来
	}
	
	/**
	 * 饿汉式在多线程环境下的测试函数
	 */
	public static void test1() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton1 s1 = Singleton1.getInstance();  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("饿汉式总消耗时间："+(endTime-startTime)+"ms");
	}
	
	/**
	 * 懒汉式  多线程环境下的测试
	 */
	public static void test2() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton2 s2 = Singleton2.getInstance();  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("懒汉式总消耗时间："+(endTime-startTime)+"ms");
	}
	
	/**
	 * 静态内部类  多线程环境下的测试
	 */
	public static void test3() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton3 s3 = Singleton3.getInstance();  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("静态内部类总消耗时间："+(endTime-startTime)+"ms");
	}
	
	/**
	 * 双重校验锁  多线程环境下的测试
	 */
	public static void test4() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton4 s4 = Singleton4.getInstance();  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("双重校验锁总消耗时间："+(endTime-startTime)+"ms");
	}
	
	/**
	 * 枚举  多线程环境下的测试
	 */
	public static void test5() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton5 s5 = Singleton5.INSTANCE;  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("枚举总消耗时间："+(endTime-startTime)+"ms");
	}
	
	
	/**********************多线程环境下直接new一个对象********************************/
	
	public static void test6() throws InterruptedException{
		
		long startTime = System.currentTimeMillis();     //开始时间
		final CountDownLatch countDownLatch = new CountDownLatch(count);
		
		for(int i=0;i<count;i++){
			new Thread(new Runnable() {    
                @Override  
                public void run() {  
                    // TODO Auto-generated method stub  
                    for (int i = 0; i < jobCountPerThread; i++) {  
                        Singleton s = new Singleton();  
                    }   
                    countDownLatch.countDown();  
                } 
            }).start();  
		}
		countDownLatch.await();
		long endTime = System.currentTimeMillis();
		System.out.println("传统技术直接new总的消耗时间："+(endTime-startTime)+"ms");
	}
	
}

class Singleton{
	
	public Singleton(){
		
	}
}


/**
 * 模拟应用场景：例如：KTV房间里只有一个话筒：而且有很多人都要唱歌   多线程模拟多人拿起的话筒是不是一个话筒
 */
class Person extends Thread{
	
	@Override
	public void run(){
		//System.out.println("话筒的hashCode值:"+Singleton5.INSTANCE.hashCode());		
	}
}