package adt.bt.arithmeticExpression;

import adt.bt.BTNode;

/**
 * It represents the node of an arithmetic expression abstractly. Each kind of expression (sum, division,
 * subtraction, multiplication and number) hava a particular way of being evaluated.  
 */
public abstract class ArithmeticExpression extends BTNode<String> {

	public ArithmeticExpression(String data, ArithmeticExpression left, 
			ArithmeticExpression right, ArithmeticExpression parent) {
		super(data,left,right,parent);
	}
	
	public ArithmeticExpression(){
		
	}
	
	public abstract Integer evaluate();
}
