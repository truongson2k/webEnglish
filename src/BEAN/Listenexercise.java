package BEAN;

public class Listenexercise {
	
	private int idlistenexercise ;
	private String listenexercisename ;
	private String listenexerciseimage ;
	private int checklisten;
	
	public Listenexercise() {
		super();
	}

	public Listenexercise(int idlistenexercise, String listenexercisename, String listenexerciseimage,
			int checklisten) {
		super();
		this.idlistenexercise = idlistenexercise;
		this.listenexercisename = listenexercisename;
		this.listenexerciseimage = listenexerciseimage;
		this.checklisten = checklisten;
	}

	public int getIdlistenexercise() {
		return idlistenexercise;
	}

	public void setIdlistenexercise(int idlistenexercise) {
		this.idlistenexercise = idlistenexercise;
	}

	public String getListenexercisename() {
		return listenexercisename;
	}

	public void setListenexercisename(String listenexercisename) {
		this.listenexercisename = listenexercisename;
	}

	public String getListenexerciseimage() {
		return listenexerciseimage;
	}

	public void setListenexerciseimage(String listenexerciseimage) {
		this.listenexerciseimage = listenexerciseimage;
	}

	public int getChecklisten() {
		return checklisten;
	}

	public void setChecklisten(int checklisten) {
		this.checklisten = checklisten;
	}
	
	
}
