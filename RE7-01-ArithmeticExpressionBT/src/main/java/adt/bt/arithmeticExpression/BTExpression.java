package adt.bt.arithmeticExpression;

import adt.bt.BT;

/**
 * Represents a binary tree of arithmetic expressions. All arithmetic expressions have an evaluate 
 * method that returns an Integer.  
 */
public interface BTExpression extends BT<String> {
	public Integer evaluate();
}
