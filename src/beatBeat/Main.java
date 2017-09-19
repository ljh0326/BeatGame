package beatBeat;

public class Main {

	/*
	 * 배경화면 만든다. wallpaperswide.com
	 */
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	//노드 스피드
	public static final int NOTE_SPEED = 7;
	//얼마 주기로 노트가 떨어질 지 
	public static final int SLEEP_TIME = 7;
	//판정바에 도달하는 시간
	public static final int REACH_TIME = 1;
	
	public static void main(String[] args) {
		new BeatGame();

	}
}
