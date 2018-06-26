package adt.bt.arithmeticExpression;

import adt.bt.BTNode;

/**
 * An implementation of a BTExpression. Its root contains an Arithmetic Expression.
 * Some methods do not make sense in this kind of tree.  
 */
public class BTExpressionImpl implements BTExpression {

	@Override
	public BTNode<String> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BTNode<String> search(String elem) {
		throw new RuntimeException("Method does not make sense");
	}

	@Override
	public void insert(String value) {
		throw new RuntimeException("Method does not make sense");
	}

	@Override
	public void remove(String key) {
		throw new RuntimeException("Method does not make sense");	
	}

	@Override
	public String[] preOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] order() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] postOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

}
