package beatBeat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	//JZOOM MP3 ��� ���̺귯���� �ִ� Ŭ���� 
	private Player player;
	
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	// ���� ������ ���Ͽ� ���� �ҽ� ���ͼ� �÷��̾ ����
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
	
	//����ǰ� �ִ� ������ ���� ���ġ�� ����Ǵ��� �˷��ش�.
	//��Ʈ ����߸� �� �ð� ����ϱ����� ���
	public int getTime() {
		//1. ��ȿ���˻�
		if(player == null)
			return 0;
		
		//2. ��ġ�� �޾ƿ´�.
		return player.getPosition();
	}
	
	//�������� ������ ���� �ǵ��� �ϴ� �Լ�
	public void close() {
		//1. ������ ���ְ�
		isLoop = false;
		//2. ���̺귯���� �ݾ��ش���
		player.close();
		//3. ������ ����
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
			//isLoop���� true�ϵ��� ���ѹݺ�
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
