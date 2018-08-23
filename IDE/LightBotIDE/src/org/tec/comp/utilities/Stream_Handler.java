package org.tec.comp.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Stream_Handler {

	private static final String FILE_EXT = ".txt";
	
	public static void write_file(String content, String file_name) throws IOException {
		try(
		BufferedReader reader = new BufferedReader(new StringReader(content));
		PrintWriter writer = new PrintWriter(new FileWriter(file_name + FILE_EXT));
		) {
			reader.lines().forEach(line -> writer.println(line));
		}
	}
	
	public static String get_file_content(File file) {
		FileReader reader;
		StringBuffer str_buffer = new StringBuffer();
		try {
			reader = new FileReader(file);
			
			int i = 1;
			while(i != -1) {
				i = reader.read();
				char c = (char)i;
				str_buffer.append(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str_buffer.toString();
	}
	
	public static ArrayList<String> get_lines_as_list(String file) {
		ArrayList<String> result = new ArrayList<String>();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get(file));
			
			for(String s : lines) {
				result.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
