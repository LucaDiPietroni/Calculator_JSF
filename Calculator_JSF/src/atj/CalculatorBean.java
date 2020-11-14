package atj;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CalculatorBean implements Serializable{
	private static final long serialVersionUID = -3512401082776903678L;
	private String buttValue = "";
	private String visibleValue = "";
	private Calculations calcObject = new Calculations();
	
	@PostConstruct
	public void initialize() {
		System.out.println(CalculatorBean.class.getSimpleName() + " was constructed");
	}

	public String getButtValue() {
		return buttValue;
	}

	public void setButtValue(String buttValue) {
		this.buttValue = buttValue;
	}
	
	public String getVisibleValue() {
		return visibleValue;
	}

	public void setVisibleValue(String visibleValue) {
		this.visibleValue = visibleValue;
	}
	
	public void numberPressed(String buttonValue) {
		if(calcObject.isFirstValueAResult()) {
			calcObject = new Calculations();
    	}
		
		if(calcObject.isFirstValueActive()) {
			calcObject.setFirstValue(calcObject.getFirstValue() + buttonValue);
			
		} else {
			calcObject.setSecondValue(calcObject.getSecondValue() + buttonValue);
			
		}
		this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
	}

	public String clearVisibleValue() {
		calcObject = new Calculations();
		this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
		return "Keyboard";
	}
	
	public void dotPressed(String buttonValue) {
		if (!Pattern.compile("[^\\.]+\\.[^\\.]*")
				.matcher(calcObject.getFirstValue())
				.matches() 
				&& calcObject.isFirstValueActive()
				&& !calcObject.getFirstValue().equals("")
				&& !calcObject.getFirstValue().equals("-")) {
			calcObject.setFirstValue(calcObject.getFirstValue() + buttonValue);
			
		} else if (!Pattern.compile("[^\\.]+\\.[^\\.]*")
				.matcher(calcObject.getSecondValue())
				.matches() 
				&& !calcObject.isFirstValueActive()
				&& !calcObject.getSecondValue().equals("")
				&& !calcObject.getSecondValue().equals("-")) {
			calcObject.setSecondValue(calcObject.getSecondValue() + buttonValue);
		}
		
		this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
	}
	
	public String signPressed(String buttonValue) {
		try {
			if(!calcObject.getFirstValue().equals("")) {
				calcObject.setFirstValueAResult(false);
	    		
	    		if (Pattern.compile(".*\\.")
	    		.matcher(calcObject.getFirstValue())
	    		.matches()) {
	    			throw new Exception();
	    	    			
	    	    } else if (Pattern.compile(".*\\.")
	    	    .matcher(calcObject.getSecondValue())
	    	    .matches()) {
	    	    	throw new Exception();
	    	    	
	    	    } else if (calcObject.isFirstValueActive()) {
	    	    	calcObject.setSign(buttonValue);
	    	    	calcObject.setFirstValueActive(false);
	    			
	    		} else if (!calcObject.isFirstValueActive() && calcObject.getSecondValue().equals("")) {
	    			calcObject.setSign(buttonValue);
	    			
	    		} else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
	    			String resultOfCounting = (calcObject.counting());
	    			calcObject = new Calculations();
	    			calcObject.setFirstValue(resultOfCounting);
	    			calcObject.setSign(buttonValue);
	    			calcObject.setFirstValueActive(false);
	    			
	    		}
			}
			
			this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
			return "Keyboard";
			
		}catch (Exception e) {
			e.printStackTrace();
	    	return "KeyboardErr";
		}
	}
	
	public String squarePressed() {
		try {
			if(!calcObject.getFirstValue().equals("")) {
				if (Pattern.compile(".*\\.")
			    	    .matcher(calcObject.getFirstValue())
			    	    .matches()) {
			    			throw new Exception();
			    	    	    			
			    	    } else if (Pattern.compile(".*\\.")
			    	    .matcher(calcObject.getSecondValue())
			    	    .matches()) {
			    	    	throw new Exception();
			    	    	    	    	
			    	    } else if (calcObject.isFirstValueActive()
			    	    		|| (!calcObject.isFirstValueActive() && calcObject.getSecondValue().equals(""))) {
			    	    	String resultOfCounting = (calcObject.squareValues());
			    	    	calcObject = new Calculations();
			    	    	calcObject.setFirstValue(resultOfCounting);
			    	    	calcObject.setFirstValueAResult(true);
			    	    	
			    	    } else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
			    	    	String resultOfCounting = (calcObject.counting());
			    	    	calcObject = new Calculations();
			    	    	calcObject.setFirstValue(resultOfCounting);
			    	    	resultOfCounting = (calcObject.squareValues());
			    	    	System.out.println(resultOfCounting);
			    	    	calcObject = new Calculations();
			    	    	calcObject.setFirstValue(resultOfCounting);
			    	    	calcObject.setFirstValueAResult(true);
			    	    }
			}
			
			this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
			return "Keyboard";
			
		}catch (Exception e) {
			e.printStackTrace();
	    	return "KeyboardErr";
		}
	}
	
	public void plusMinusChanger() {
		if (calcObject.isFirstValueActive()) {
			calcObject.setFirstValue(calcObject.changeMinus(calcObject.getFirstValue()));
		} else {
			calcObject.setSecondValue(calcObject.changeMinus(calcObject.getSecondValue()));
		}
		
		this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
	}
	
	public String equalPressed() {
		try {
			if (Pattern.compile(".*\\.")
					.matcher(calcObject.getFirstValue())
					.matches()) {
		    			throw new Exception();
		    			
		    		} else if (Pattern.compile(".*\\.")
		    		.matcher(calcObject.getSecondValue())
		    		.matches()) {
		    			throw new Exception();
		    	    	
		    	    } else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
		    	    	String resultOfCounting = (calcObject.counting());
		    	    	System.out.println(resultOfCounting);
		    	    	calcObject = new Calculations();
		    	    	calcObject.setFirstValue(resultOfCounting);
		    	    	calcObject.setFirstValueAResult(true);
		    	    }
			
			this.setVisibleValue(calcObject.getFirstValue() + calcObject.getSign() + calcObject.getSecondValue());
			return "Keyboard";
			
		}catch (Exception e) {
			e.printStackTrace();
	    	return "KeyboardErr";
		}
	}
	
	public String goPropertiesMenu() {
		return "viewProperties";
	}
}
