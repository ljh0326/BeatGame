package beatBeat;

//�ϳ��� ����� ������ �������°�
public class Track {

	private String titleImage; // ����κ�
	private String startImage; // ���Ӽ��� âǥ��
	private String gameImgae; // �ش� �� �������� �� ǥ��
	private String startMusic; // ���Ӽ��� ����
	private String gameMusic; // �ش�� �������� �� ����
	private String titleName; //�� ����
	
	public Track(String titleImage, String startImage, String gameImgae, String startMusic, String gameMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImgae = gameImgae;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
	public String getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}

	public String getStartImage() {
		return startImage;
	}

	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}

	public String getGameImgae() {
		return gameImgae;
	}

	public void setGameImgae(String gameImgae) {
		this.gameImgae = gameImgae;
	}

	public String getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}

	public String getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

}
