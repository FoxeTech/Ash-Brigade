package com.github.brigade.ui.screen;

import com.github.brigade.map.MapPoint;
import com.github.brigade.ui.util.MouseInput;
/**
 * 
 * @author Matt
 *
 */
public abstract class Screen {
<<<<<<< HEAD
	
	private String screenName;
	
	public Screen(String screenName){
		this.screenName = screenName;
	}
	
	public String getScreenName(){
		return screenName;
	}
	
=======
	/**
	 * Updates the state of the screen such as keyboard input
	 */
>>>>>>> origin/master
	public void update() {
		if (MouseInput.hasClickedLeft()) {
			onClick(MouseInput.LEFT, MouseInput.getX(), MouseInput.getY(), !MouseInput.isLeftDown());
		}
		if (MouseInput.hasClickedRight()) {
			onClick(MouseInput.RIGHT, MouseInput.getX(), MouseInput.getY(), !MouseInput.isRightDown());
		}
		if (MouseInput.hasClickedMiddle()) {
			onClick(MouseInput.MIDDLE, MouseInput.getX(), MouseInput.getY(), !MouseInput.isMiddleDown());
		}
	}

	public abstract void render();
	
	public abstract void render(MapPoint[][] data);

	/**
	 * Called when the mouse is clicked on the screen.
	 * 
	 * @param mouseID
	 *            <ul>
	 *            <li>0 = Left</li>
	 *            <li>1 = Right</li>
	 *            <li>2 = Middle</li>
	 *            </ul>
	 * @param x
	 *            Mouse X
	 * @param y
	 *            Mouse Y
	 * @param isMouseReleasing
	 *            <ul>
	 *            <li>False - Mouse is down</li>
	 *            <li>True - Mouse is up</li>
	 *            </ul>
	 */
	protected void onClick(int mouseID, int x, int y, boolean isMouseReleasing) {
	}
}
