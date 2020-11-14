package atj;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "styleBean", eager = true)
@SessionScoped
public class StyleBean{
	private String backgroundColor;
	private String keyColor;
	private String resultColor;
	private String resultBackgroundColor;
	private String fontFamily;
	
	private int activeBorderBackgroundColor;
	private int activeBorderKeyColor;
	private int activeBorderResultBackgroundColor;
	private int activeBorderResultColor;
	
	public String getBackgroundColor() {
		return backgroundColor;
	}
	
	public String setBackgroundColor(String backgroundColor, int activeBorder) {
		this.backgroundColor = backgroundColor;
		this.activeBorderBackgroundColor = activeBorder;
		return "viewProperties";
	}
	
	public String getKeyColor() {
		return keyColor;
	}
	
	public void setKeyColor(String keyColor, int activeBorder) {
		this.keyColor = keyColor;
		this.activeBorderKeyColor = activeBorder;
	}
	
	public String getResultColor() {
		return resultColor;
	}
	
	public void setResultColor(String resultColor, int activeBorder) {
		this.resultColor = resultColor;
		this.activeBorderResultColor = activeBorder;
	}
	
	public String getResultBackgroundColor() {
		return resultBackgroundColor;
	}
	
	public void setResultBackgroundColor(String resultBackgroundColor, int activeBorder) {
		this.resultBackgroundColor = resultBackgroundColor;
		this.activeBorderResultBackgroundColor = activeBorder;
	}
	
	public String getFontFamily() {
		return fontFamily;
	}
	
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	
	public String goBack() {
		return "Keyboard";
	}
	
	public String refresh() {
		return "viewProperty";
	}
	
	public String borderBackgroundActivate(int input) {
		if(input==activeBorderBackgroundColor) {
			return "border:3px solid white;";
		}
		else return "";
	}
	
	public String borderKeyActivate(int input) {
		if(input==activeBorderKeyColor) {
			return "border:3px solid white;";
		}
		else return "";
	}
	
	public String borderResultBackgroundActivate(int input) {
		if(input==activeBorderResultBackgroundColor) {
			return "border:3px solid white;";
		}
		else return "";
	}
	
	public String borderResultActivate(int input) {
		if(input==activeBorderResultColor) {
			return "border:3px solid white;";
		}
		else return "";
	}
	
	public void defaultStyle() {
		this.backgroundColor = "default";
		this.keyColor = "default";
		this.resultColor = "default";
		this.resultBackgroundColor = "default";
		this.fontFamily = "Calibri";
		
		this.activeBorderBackgroundColor = 0;
		this.activeBorderKeyColor = 0;
		this.activeBorderResultBackgroundColor = 0;
		this.activeBorderResultColor = 0;
	}
}
