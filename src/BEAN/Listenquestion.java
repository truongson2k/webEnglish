package BEAN;

public class Listenquestion {
	
	private int idlistenquestion;
	private int num;
	private String imagename;
	private String audiomp3;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctanswer;
	private int idlistenexercise;
	public Listenquestion(int idlistenquestion, int num, String imagename, String audiomp3, String question,
			String option1, String option2, String option3, String option4, String correctanswer,
			int idlistenexercise) {
		super();
		this.idlistenquestion = idlistenquestion;
		this.num = num;
		this.imagename = imagename;
		this.audiomp3 = audiomp3;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctanswer = correctanswer;
		this.idlistenexercise = idlistenexercise;
	}
	public Listenquestion() {
		super();
	}
	public int getIdlistenquestion() {
		return idlistenquestion;
	}
	public void setIdlistenquestion(int idlistenquestion) {
		this.idlistenquestion = idlistenquestion;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getAudiomp3() {
		return audiomp3;
	}
	public void setAudiomp3(String audiomp3) {
		this.audiomp3 = audiomp3;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public int getIdlistenexercise() {
		return idlistenexercise;
	}
	public void setIdlistenexercise(int idlistenexercise) {
		this.idlistenexercise = idlistenexercise;
	}
	
	
}
