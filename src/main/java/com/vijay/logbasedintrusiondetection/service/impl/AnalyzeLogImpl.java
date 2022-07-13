package com.vijay.logbasedintrusiondetection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vijay.logbasedintrusiondetection.service.AnalyzeLog;

@Service
public class AnalyzeLogImpl implements AnalyzeLog{

	public List<String> checkForExceptions(String fileAsString) {
		// TODO Auto-generated method stub
		System.out.println(fileAsString);
		return null;
	}

	public List<String> checkForExceptions2(List<String>  fileAsStringArray) {
		// TODO Auto-generated method stub
		//System.out.println(fileAsString);
		List<String> exceptionList = new ArrayList<>();
		int index=0;
		
		for(String word : fileAsStringArray)
		{
			index++;
			if(word.contains("Exception"))
			{
				if(index >2) {
				exceptionList.add(fileAsStringArray.get(index-2)+" "+fileAsStringArray.get(index-1)+" "+fileAsStringArray.get(index)+" "+fileAsStringArray.get(index+1)+" "+fileAsStringArray.get(index+2));
				}
				else
				{
					exceptionList.add(word);
				}
				}
		}
		return exceptionList;
	}

	public List<String> checkForAuthenticationFailures(List<String>  fileAsStringArray)
	{
		List<String> exceptionList = new ArrayList<>();
		int index=0;
		
		for(String word : fileAsStringArray)
		{
			index++;
			if(word.contains("Login failure")|| word.contains("Login Denied") || word.contains("Auth failure"))
			{
				if(index >2) {
				exceptionList.add(fileAsStringArray.get(index-2)+" "+fileAsStringArray.get(index-1)+" "+fileAsStringArray.get(index)+" "+fileAsStringArray.get(index+1)+" "+fileAsStringArray.get(index+2));
				}
				else
				{
					exceptionList.add(word);
				}
				}
		}
		return exceptionList;
	}
	
	public List<String> checkForAuthorizationFailures(List<String>  fileAsStringArray)
	{
		List<String> exceptionList = new ArrayList<>();
		int index=0;
		
		for(String word : fileAsStringArray)
		{
			index++;
			if(word.contains("Role not allowed")|| word.contains("Role not found") || word.contains("not Authorized"))
			{
				if(index >2) {
				exceptionList.add(fileAsStringArray.get(index-2)+" "+fileAsStringArray.get(index-1)+" "+fileAsStringArray.get(index)+" "+fileAsStringArray.get(index+1)+" "+fileAsStringArray.get(index+2));
				}
				else
				{
					exceptionList.add(word);
				}
				}
		}
		return exceptionList;
	}
	
	 public List<String>  checkForOwaspAttack(List<String>  fileAsStringArray){
		 List<String> exceptionList = new ArrayList<>();
		int index=0;
		
		for(String word : fileAsStringArray)
		{
			index++;
			if(word.contains("MaliciousInput"))
			{
				if(index >2) {
				exceptionList.add(fileAsStringArray.get(index-2)+" "+fileAsStringArray.get(index-1)+" "+fileAsStringArray.get(index)+" "+fileAsStringArray.get(index+1)+" "+fileAsStringArray.get(index+2));
				}
				else
				{
					exceptionList.add(word);
				}
				}
		}
		return exceptionList;
		 
		 
	 }
	 
	 public List<String>  checkForResponseCodes(List<String>  fileAsStringArray)
	 {
		 List<String> exceptionList = new ArrayList<>();
		 int index=0;
			
			for(String word : fileAsStringArray)
			{
				index++;
				if(word.contains("Response"))
				{
					if(index >2) {
					exceptionList.add(fileAsStringArray.get(index-2)+" "+fileAsStringArray.get(index-1)+" "+fileAsStringArray.get(index)+" "+fileAsStringArray.get(index+1)+" "+fileAsStringArray.get(index+2));
					}
					else
					{
						exceptionList.add(word);
					}
					}
			}
			return exceptionList;
	 }
	
}
