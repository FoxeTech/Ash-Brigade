package com.github.brigade;

public class Camera {
	private int x, y;
	private int x1, y1;
	private int xoff, yoff;
	private int xsize, ysize;
	int zoom;
	float movementSpeed;
	private int totalCameraOffsetX, totalCameraOffsetY;
	private int startPositionX, startPositionY;
	
	public Camera(int x, int y, int xsize, int ysize, int zoom, float movementSpeed){
		this.x = x;
		this.y = y;
		this.xsize = xsize;
		this.ysize = ysize;
		this.zoom = zoom;
		x1 = x;
		y1 = y;
		xoff = 0;
		yoff = 0;
		totalCameraOffsetX = 0;
		totalCameraOffsetY = 0;
		startPositionX = x;
		startPositionY = y;
		this.movementSpeed = movementSpeed;
	}
	
	public void update(){
		xoff = x - x1;
		yoff = y - y1;
		totalCameraOffsetX = x - startPositionX;
		totalCameraOffsetY = y - startPositionY;
	}
	
	public void moveRight(){
		x += movementSpeed;
	}
	public void moveLeft(){
		x -= movementSpeed;
	}
	public void moveDown(){
		y -= movementSpeed;
	}
	public void moveUp(){
		y += movementSpeed;
	}
	
	public int getPositionX(){
		return x;
	}
	
	public int getPositionY(){
		return y;
	}
	public void setPositionX(int x){
		this.x = x;
	}
	
	public void setPositionY(int y){
		this.y = y;
	}
	
	public void setSizeX(int a){
		this.xsize = a;
	}
	public void setSizeY(int a){
		this.ysize = a;
	}
	public int getSizeX(){
		return xsize;
	}
	public int getSizeY(){
		return ysize;
	}
	
	public int getZoom(){
		return zoom;
	}
	
	public void setZoom(int a){
		this.zoom = a;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getTotalCameraOffsetX() {
		return totalCameraOffsetX;
	}

	public void setTotalCameraOffsetX(int totalCameraOffsetX) {
		this.totalCameraOffsetX = totalCameraOffsetX;
	}

	public int getTotalCameraOffsetY() {
		return totalCameraOffsetY;
	}

	public int getXoff() {
		return xoff;
	}

	public void setXoff(int xoff) {
		this.xoff = xoff;
	}

	public int getYoff() {
		return yoff;
	}

	public void setYoff(int yoff) {
		this.yoff = yoff;
	}

	public void setTotalCameraOffsetY(int totalCameraOffsetY) {
		this.totalCameraOffsetY = totalCameraOffsetY;
	}

	public int getStartPositionX() {
		return startPositionX;
	}

	public void setStartPositionX(int startPositionX) {
		this.startPositionX = startPositionX;
	}

	public int getStartPositionY() {
		return startPositionY;
	}

	public void setStartPositionY(int startPositionY) {
		this.startPositionY = startPositionY;
	}
}
