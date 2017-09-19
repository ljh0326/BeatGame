package beatBeat;

//하나의 곡에대한 정보를 가져오는것
public class Track {

	private String titleImage; // 제목부분
	private String startImage; // 게임선택 창표지
	private String gameImgae; // 해당 곡 진행했을 떄 표지
	private String startMusic; // 게임선택 음악
	private String gameMusic; // 해당곡 실행했을 때 음악
	private String titleName; //곡 제목
	
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
