package com.reversepolish.notator;

public class Operators
{
	public static int getPrecedence(char operand)
	{
		switch (operand)
		{
		case '+':
		case '-': return 2; 
		case '*':
		case '/': return 3;
		case '^': return 4;
		default: return 0;
		}
	}
	
	public static boolean isOperator(String token)
	{
		if ("+-*/^".contains(token))
		{
			return true;
		}
		
		return false;
	}
}
