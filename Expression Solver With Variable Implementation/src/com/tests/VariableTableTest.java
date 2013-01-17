package com.tests;

import com.reversepolish.notator.Notator;
import com.reversepolish.notator.Parser;
import com.tokenizer.Tokenizer;
import com.tokenizer.VariableProcessor;
import com.tokenizer.VariableTable;

public class VariableTableTest
{
	public static void main(String[] args)
	{
		VariableTable.addVariable("Test");
		System.out.println("Test = "+VariableTable.getVariable("Test"));

		
		String tokens[] = Tokenizer.tokenize("6 + Test * 4");
		printArray(tokens);
		
		String processedTokens[] = VariableProcessor.process(tokens);
		printArray(processedTokens);
		
		try
		{
			String number = Parser.parse(Notator.notate(processedTokens));
			System.out.println(number);

		}
		catch (Exception ex)
		{
			System.out.println("Invalid Expression");
		}
		
	}
	
	
	public static void printArray(Object array[])
	{
		for (int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+"|");
		}
		System.out.println("");
	}

}
