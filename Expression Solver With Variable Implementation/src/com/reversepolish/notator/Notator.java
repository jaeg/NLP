package com.reversepolish.notator;

import java.util.LinkedList;

public class Notator
{
	public static String[] notate(String tokens[])
	{

		LinkedList<String> output = new LinkedList<String>();
		LinkedList<String> operatorStack = new LinkedList<String>();
		
		for (int i=0;i<tokens.length;i++)
		{
			if (isDigit(tokens[i]))
			{
				output.add(tokens[i]);
			}
			else
			{
				int precedence = Operators.getPrecedence(tokens[i].charAt(0));
				if (precedence>0)
				{
					int topPrecedence = 0;
					if (operatorStack.size()>0)
					{
						int index = 0;
						boolean done = false;
						while (done==false)
						{
							char topOperand = operatorStack.get(index).charAt(0);
							topPrecedence = Operators.getPrecedence(topOperand);
							
							if (precedence<=topPrecedence)
							{
								output.add(operatorStack.pop());
							}
							else
							{
								done = true;
							}
							
							index++;
							
							if (index>operatorStack.size())
							{
								done = true;
							}
						}
					}
					operatorStack.push(tokens[i]);
				}
				else
				{
					if (tokens[i].equals("("))
					{
						operatorStack.push(tokens[i]);
					}
					
					if (tokens[i].equals(")"))
					{
						boolean done = false;
						while (done == false)
						{
							String currentOperator = operatorStack.pop();
							
							if (currentOperator.equals("("))
							{
								done = true;
							}
							else
							{
								output.add(currentOperator);
							}
							
							if (operatorStack.size() == 0)
							{
								done = true;
							}
						}
					}
				}
			}
		}
		
		output.addAll(operatorStack);
		
		return clean(output);
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

	private static String[] clean(LinkedList<String> tokens)
	{
		for (int i=0; i<tokens.size();i++)
		{
			if (tokens.get(i).trim()=="" || tokens.get(i)==null)
			{
				tokens.remove(i);
			}
		}
		
		return tokens.toArray(new String[tokens.size()]);
	}
}
