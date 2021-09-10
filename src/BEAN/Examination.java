package BEAN;

public class Examination {
	private int idexamination;
	private String examinationname;
	private String examinationimage;
	private int checked;
	public Examination() {
		super();
	}
	public Examination(int idexamination, String examinationname, String examinationimage) {
		super();
		this.idexamination = idexamination;
		this.examinationname = examinationname;
		this.examinationimage = examinationimage;
	}
	public int getIdexamination() {
		return idexamination;
	}
	public void setIdexamination(int idexamination) {
		this.idexamination = idexamination;
	}
	public String getExaminationname() {
		return examinationname;
	}
	public void setExaminationname(String examinationname) {
		this.examinationname = examinationname;
	}
	public String getExaminationimage() {
		return examinationimage;
	}
	public void setExaminationimage(String examinationimage) {
		this.examinationimage = examinationimage;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	
	
}
