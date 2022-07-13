package com.vijay.logbasedintrusiondetection.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vijay.logbasedintrusiondetection.service.AnalyzeLog;

@Controller
public class HomeController {
	
	
	
	@GetMapping(value="/")
	public String indexPage()
	{
		System.out.print("/ is called");
		return "redirect:Index.html";
	}
	
	
}
