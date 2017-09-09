package beatBeat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	//JZOOM MP3 재생 라이브러리에 있는 클래스 
	private Player player;
	
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	// 뮤직 생성자 파일에 뮤직 소스 얻어와서 플레이어에 저장
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//실행되고 있는 음악이 현재 어떤위치에 실행되는지 알려준다.
	//노트 떨어뜨릴 때 시간 계산하기위해 사용
	public int getTime() {
		//1. 유효성검사
		if(player == null)
			return 0;
		
		//2. 위치를 받아온다.
		return player.getPosition();
	}
	
	//언제든지 음악이 종료 되도록 하는 함수
	public void close() {
		//1. 루프를 꺼주고
		isLoop = false;
		//2. 라이브러리를 닫아준다음
		player.close();
		//3. 쓰레드 정지
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			//isLoop값이 true일동안 무한반복
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
		}catch(Exception e) {
			e.printStackTrace( );
		}
	}
}
