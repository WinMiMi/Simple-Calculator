package application;

public final class CalculatorModel {
	
	private CalculatorModel() {}
	
	public static double calculate(double operand1, double operand2, String operator) {
		return switch (operator) {
		case "+" -> operand1 + operand2;
		case "-" -> operand1 - operand2;
		case "*" -> operand1 * operand2;
		case "/" -> operand1 != 0? operand1/operand2 : 0.0;		
		default -> 0.0;	
		};
	}
	
	
}
