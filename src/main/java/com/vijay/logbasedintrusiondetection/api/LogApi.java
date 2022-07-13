package com.vijay.logbasedintrusiondetection.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.logbasedintrusiondetection.service.AnalyzeLog;

@RestController
public class LogApi {
	
	@Autowired
	AnalyzeLog analyzeLog;
	
	@PostMapping(value="/analyzeFile")
	public Map<String,List<String>> analyzeFile(@RequestParam("file")MultipartFile file)
	{
		//AnalyzeLogFile analyzeLogFile = new  AnalyzeLogFile();
		Map<String,List<String>> exceptionMap = new HashMap<>();
	
		
		try{
			 //  file.getBytes();
			InputStream initialStream = file.getInputStream();
			String result= new BufferedReader(new InputStreamReader(initialStream)).lines().collect(Collectors.joining("\n"));
			List<String> stList = new ArrayList<>();
			StringTokenizer stringToken = new StringTokenizer(result," ");
			while(stringToken.hasMoreTokens())
			{
				stList.add(stringToken.nextToken());
			}
			
			//analyzeLog.checkForExceptions(result);
			exceptionMap.put("Exceptions", analyzeLog.checkForExceptions2( stList));
			exceptionMap.put("Authentication Failures", analyzeLog.checkForAuthenticationFailures( stList));
			exceptionMap.put("Authorization Failures", analyzeLog.checkForAuthorizationFailures(stList));
			exceptionMap.put("Owasp attack", analyzeLog.checkForOwaspAttack(stList));
			exceptionMap.put("Response codes", analyzeLog.checkForResponseCodes(stList));
			return exceptionMap;
			}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

}
