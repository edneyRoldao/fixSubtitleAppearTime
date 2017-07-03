package com.edn.fixSubtitle;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
				
		try {
					
			Path path = Paths.get("C:\\\\Downloads\\\\subtitles\\jjjjj.srt");
			System.out.println(Files.exists(path));
			
			if(Files.notExists(path)) {
				
			}
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
