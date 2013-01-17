package com.reversepolish.notator;

import java.util.LinkedList;

public class Parser
{
	public static String parse(String tokens[]) throws Exception
	{

		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i<tokens.length;i++)
		{
			if (!isDigit(tokens[i]) && !Operators.isOperator(tokens[i]))
			{
				throw new Exception("Invalid Expression");
			}
			if (Operators.isOperator(tokens[i]))
			{
				int second = stack.pop();
				int first = stack.pop();
				
				if (tokens[i].equals("+"))
				{
					stack.push(first+second);
				}
				else if (tokens[i].equals("-"))
				{
					stack.push(first-second);
				}
				else if (tokens[i].equals("*"))
				{
					stack.push(first*second);
				}
				else if (tokens[i].equals("/"))
				{
					stack.push(first/second);
				}
				else if (tokens[i].equals("^"))
				{
					stack.push((int)Math.pow(first, second));
				}
			}
			else
			{
				stack.push(Integer.parseInt(tokens[i]));
			}
			
		}
		
		return String.valueOf(stack.pop());
	}
	
	private static boolean isDigit(String token)
	{
		for (int i=0;i<token.length();i++)
		{
			if (Character.isDigit(token.charAt(i))==false)
			{
				return false;
			}
		}
		
		return true;
	}

}
