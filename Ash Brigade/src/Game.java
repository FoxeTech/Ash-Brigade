
public class Game {
	
	private enum State{INTRO,MAIN_MENU,GAME,OPTIONS_MENU};
	private State state = State.INTRO;
	private final int width;
	private final int height;
	
	public Game(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void update(){
		if(state == State.INTRO){
			
		}else if(state == State.MAIN_MENU){
			
		}else if(state == State.GAME){
			
		}else if(state == State.OPTIONS_MENU){
			
		}
	}
	
	public void render(){
		if(state == State.INTRO){
			
		}else if(state == State.MAIN_MENU){
			
		}else if(state == State.GAME){
			
		}else if(state == State.OPTIONS_MENU){
			
		}
	}
	
	
}
