package com.vijay.logbasedintrusiondetection.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AnalyzeLog {
	
	public List<String> checkForExceptions(String fileAsString);
	public List<String> checkForExceptions2(List<String>  fileAsStringArray);
	public List<String> checkForAuthenticationFailures(List<String>  fileAsStringArray);
	public List<String> checkForAuthorizationFailures(List<String>  fileAsStringArray);
	public List<String>  checkForOwaspAttack(List<String>  fileAsStringArray);
	public List<String>  checkForResponseCodes(List<String>  fileAsStringArray);
}
