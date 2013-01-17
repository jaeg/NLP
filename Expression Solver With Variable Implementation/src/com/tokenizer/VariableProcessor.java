package com.tokenizer;

public class VariableProcessor
{
	public static String[] process(String[] tokens)
	{
		for (int i=0;i<tokens.length;i++)
		{
			String variable = VariableTable.getVariable(tokens[i]);
			if (variable != null )
			{
				if (!variable.equals(""))
					tokens[i] = variable;
			}
		}
		return tokens;
	}
}
