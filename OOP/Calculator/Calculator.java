package Calculator;

public class Calculator{
 double numberOne;
 double numberTwo;
 char operation;
 
public Calculator() {
	 
 }
public Calculator(double numberOne,double numberTwo,char operation) {
	 this.numberOne=numberOne;
	 this.numberTwo=numberTwo;
	 this.operation=operation;
 }
 
 public double getNumberOne() {
	return numberOne;
}
public void setNumberOne(double numberOne) {
	this.numberOne = numberOne;
}
public double getNumberTwo() {
	return numberTwo;
}
public void setNumberTwo(double numberTwo) {
	this.numberTwo = numberTwo;
}
public char getOperation() {
	return operation;
}
public void setOperation(char operation) {
	this.operation = operation;
}



public double performOperation() {
	double result=0.0;
	if(operation=='+') {
	result= numberOne + numberTwo;}
	else if(operation=='-') {
		result= numberOne - numberTwo;}
	else if(operation=='*') {
		result= numberOne * numberTwo;}
	else if(operation=='/') {
		result= numberOne / numberTwo;}
	return result;
}

public void getResults() {
	System.out.println(performOperation());
}

}
