package com.tokenizer;

import java.util.Hashtable;

public class VariableTable
{
	private static Hashtable<String,String> variables = new Hashtable<String,String>();
	
	public static boolean addVariable(String name)
	{
		if (variables.containsKey(name))
		{
			return false;
		}
		
		variables.put(name, "");
		return true;
	}
	
	public static boolean addVariable(String name, String value)
	{
		if (variables.containsKey(name))
		{
			return false;
		}
		
		variables.put(name, value);
		return true;
	}
	
	public static String getVariable(String name)
	{
		return variables.get(name);
	}
	
}
