package spring01;

public class Calculator {
	
	public int calcResult(int n1, int n2, char op) {
		int sum = 0;
		switch(op){
		case '+':
			sum = n1+n2;
			break;
		case '-':
			sum = n1-n2;
			break;
		case '*':
			sum = n1*n2;
			break;
		case '/':
			sum = n1/n2;
		}return sum;
	}
}
