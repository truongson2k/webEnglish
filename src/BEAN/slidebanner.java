package BEAN;

public class slidebanner {
	private int idslidebanner;
	private String slidename;
	private String slidecontent;
	 private String slideimage;
	
	public slidebanner() {
		super();
	}
	public slidebanner(int idslidebanner, String slidename, String slidecontent, String slideimage) {
		super();
		this.idslidebanner = idslidebanner;
		this.slidename = slidename;
		this.slidecontent = slidecontent;
		this.slideimage = slideimage;
	}
	public int getIdslidebanner() {
		return idslidebanner;
	}
	public void setIdslidebanner(int idslidebanner) {
		this.idslidebanner = idslidebanner;
	}
	public String getSlidename() {
		return slidename;
	}
	public void setSlidename(String slidename) {
		this.slidename = slidename;
	}
	public String getSlidecontent() {
		return slidecontent;
	}
	public void setSlidecontent(String slidecontent) {
		this.slidecontent = slidecontent;
	}
	public String getSlideimage() {
		return slideimage;
	}
	public void setSlideimage(String slideimage) {
		this.slideimage = slideimage;
	}
	 
}
