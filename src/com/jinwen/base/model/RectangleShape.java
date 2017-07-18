package com.jinwen.base.model;


/**
 * 矩形类
 * @author JIN
 *
 */
public class RectangleShape {
	
	private Line line1;
	private Line line2;
	private Line line3;
	private Line line4;
	
	public RectangleShape(){
		
	}
	
	public RectangleShape(Line line1,Line line2,Line line3,Line line4){
		
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.line4 = line4;
	}
	

}
