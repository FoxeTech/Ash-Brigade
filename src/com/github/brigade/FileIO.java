package com.github.brigade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileIO {
	/**
	 * Needs to be optimized.
	 */
	public static void saveAllLines(String file, List<String> text) {
		File f = new File(file);
		if (!f.exists()) {
			try {
				f.getParentFile().mkdirs();
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		PrintWriter out;
		try {
			out = new PrintWriter(file);
			for (String line : text) {
				out.println(line);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static String readAllLines(String file) {
		StringBuilder content = new StringBuilder("");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}
