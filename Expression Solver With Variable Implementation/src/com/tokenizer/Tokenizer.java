package com.tokenizer;

import java.util.LinkedList;

public class Tokenizer
{
	static public String[] tokenize(String expression)
	{
		LinkedList<String> tokens = new LinkedList<String>();
		String currentNumber="";
		for (int i=0;i<expression.length();i++)
		{
			CharSequence sequence = expression.subSequence(i, i+1);
			if ("*+-/()^".contains(sequence)||sequence.equals(" "))
			{
				if (currentNumber.trim().equals("")==false)
					tokens.add(currentNumber);
				
				if (sequence.equals(" ")==false)
					tokens.add(expression.substring(i,i+1));
				
				currentNumber = "";
			}
			else 
			{
				currentNumber+=expression.substring(i,i+1).trim();
			}
			
		}
		
		tokens.add(currentNumber);
		
		return tokens.toArray(new String[tokens.size()]);
	}

}
