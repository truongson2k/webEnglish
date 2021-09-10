package BEAN;

public class Grammarguideline {
	private int idgrammar;
	private String grammarname;
	private String grammarimage;
	private String content;
	public Grammarguideline() {
		super();
	}
	public Grammarguideline(int idgrammar, String grammarname, String grammarimage, String content) {
		super();
		this.idgrammar = idgrammar;
		this.grammarname = grammarname;
		this.grammarimage = grammarimage;
		this.content = content;
	}
	public int getIdgrammar() {
		return idgrammar;
	}
	public void setIdgrammar(int idgrammar) {
		this.idgrammar = idgrammar;
	}
	public String getGrammarname() {
		return grammarname;
	}
	public void setGrammarname(String grammarname) {
		this.grammarname = grammarname;
	}
	public String getGrammarimage() {
		return grammarimage;
	}
	public void setGrammarimage(String grammarimage) {
		this.grammarimage = grammarimage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
