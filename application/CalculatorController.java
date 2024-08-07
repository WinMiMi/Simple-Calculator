package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML 
    private Label lblScreen;
    private boolean start = true;
    private double operand1 = 0.0;
    private String operator = "";

    @FXML
    void processCE(ActionEvent event) {
    	start = true;
    	lblScreen.setText("0");
    	operand1 = 0.0;
    	operator = "";
    
    }

    @FXML
    void processNumber(ActionEvent event) {
    	if(start) {
    		lblScreen.setText("");
    		start = false;
    	}
    	Button btnClicked = (Button) event.getSource();
    	lblScreen.setText(lblScreen.getText()+btnClicked.getText());
    }

    @FXML
    void processOperator(ActionEvent event) {
    	String value = ((Button)(event.getSource())).getText();
    	
    	if(!value.equals("=")) {
    		if(!operator.isEmpty()) {
    			return ;
    		}
    		operand1 = Double.parseDouble(lblScreen.getText());
    		operator = value;
    		start = true;
    		System.out.println(operand1);
    		System.out.println(operator);
    		//lblScreen.setText("");
    	}else {
    		if(operator.isEmpty()) {
    			return;
    		}
    		double operand2 = Double.parseDouble(lblScreen.getText());
    		double result = CalculatorModel.calculate(operand1, operand2, operator);
    		lblScreen.setText(String.valueOf(result));
    		operand1 = 0.0;
    		operator = "";
    		start = true;
    		
    	}
    			
    }

}
