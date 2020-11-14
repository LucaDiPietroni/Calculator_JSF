package atj;

import java.util.regex.Pattern;

public class Calculations {
	public String firstValue;
	public String secondValue;
	public boolean firstValueActive;
	public String sign;
	public boolean isFirstValueAResult;
	
	public Calculations() {
		this.firstValue = "";
		this.secondValue = "";
		this.firstValueActive = true;
		this.sign = "";
		this.isFirstValueAResult = false;
	}
	
	public boolean isFirstValueAResult() {
		return isFirstValueAResult;
	}

	public void setFirstValueAResult(boolean isFirstValueAResult) {
		this.isFirstValueAResult = isFirstValueAResult;
	}
	
	public String getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	public boolean isFirstValueActive() {
		return firstValueActive;
	}
	public void setFirstValueActive(boolean firstValueActive) {
		this.firstValueActive = firstValueActive;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String addValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double doubleSecondValue = Double.parseDouble(secondValue);
			Double result = doubleFirstValue + doubleSecondValue;
			resultText = result.toString();
			if(resultText.equals("Infinity")) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String substractValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double doubleSecondValue = Double.parseDouble(secondValue);
			Double result = doubleFirstValue - doubleSecondValue;
			resultText = result.toString();
			if(resultText.equals("Infinity")) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String multiplyValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double doubleSecondValue = Double.parseDouble(secondValue);
			Double result = doubleFirstValue * doubleSecondValue;
			resultText = result.toString();
			if(resultText.equals("Infinity")) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String divideValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double doubleSecondValue = Double.parseDouble(secondValue);
			Double result = doubleFirstValue / doubleSecondValue;
			resultText = result.toString();
			if(resultText.equals("Infinity")||doubleSecondValue.equals(0.0)) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String moduloValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double doubleSecondValue = Double.parseDouble(secondValue);
			Double result = doubleFirstValue % doubleSecondValue;
			resultText = result.toString();
			if(doubleSecondValue==0) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String squareValues() throws Exception {
		String resultText;
		try {
			Double doubleFirstValue = Double.parseDouble(firstValue);
			Double result = Math.sqrt(doubleFirstValue);
			resultText = result.toString();
			if(doubleFirstValue<=0) {throw new Exception();}
			
		} catch(Exception e) {
			throw new Exception();
		}
		return resultText;
	}
	
	public String changeMinus(String valueToChange) {
		if (Pattern.compile("-.*").matcher(valueToChange).matches()) {
			valueToChange = valueToChange.substring(1);
		} else {valueToChange = "-" + valueToChange;}
			return valueToChange;
	}
	
	public String counting() throws Exception {
		String resultText = "";
		if (this.sign.equals("+")) {
			resultText = addValues();
		} else if (this.sign.equals("-")) {
			resultText = substractValues();
		} else if (this.sign.equals("*")) {
			resultText = multiplyValues();
		} else if (this.sign.equals("/")) {
			resultText = divideValues();
		} else if (this.sign.equals("%")) {
			resultText = moduloValues();
		}
		return resultText;
	}
	
}
