import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
/*This is temp code it will be improved!*/
public class Window {

	public Window(){
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		while(!Display.isCloseRequested()){
			Display.update();
		}
		Display.destroy();
		
	}
	
	public static void main(String[] args){
		new Window();
	}
}
