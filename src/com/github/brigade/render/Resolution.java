package com.github.brigade.render;

public enum Resolution {
	X800x600(800,600), 
	X1024x600(1024,600), 
	X1024x768(1024,768), 
	X1200x900(1200,900), 
	X1280x720(1280,720), 
	X1366x768(1366,763), 
	X1400x900(1400,900), 
	X1600x900(1600,900), 
	X1600x1200(1600,1200), 
	X1920x1080(1920,1080), 
	X1920x1200(1920,1200), 
	X2560X1600(2560,1600), 
	X2560X1440(2560,1440), 
	X2560x1600(2560,1600), 
	X3840x2160(3840,2160), 
	X4096x2160(4096,2160);
	
	int width, height;
	Resolution(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}
