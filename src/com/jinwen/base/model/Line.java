package com.jinwen.base.model;

public class Line {
	
	private int id;   //暂时没有用到，保留
	
	private Point pA;
	private Point pB;
	
	public Line(){
		
	}
	
	public Line(Point pA,Point pB){
		this.pA = pA;
		this.pB = pB;
	}
	

}
