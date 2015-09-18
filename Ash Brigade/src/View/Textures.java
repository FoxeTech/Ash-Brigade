package View;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {
	
	//create Texture variables here
	public static Texture TestTexture;//Example variable
	
	public Textures(){
		//initialize them here by using function below
		TestTexture = loadTexture("test","png");//example initialization
	}
	
	
	
	//first variable is filename, path begins in the res folder, the extension is the file extension
	//The extension Variable needs to be lower case
	public static Texture loadTexture(String key, String extension){
		try {
			return	TextureLoader.getTexture(extension, new FileInputStream(new File("res/" + key + "." + extension)));
		} catch (IOException e) {
			System.out.println("Error Loading Texture");
		}
		return null;
	}
}
