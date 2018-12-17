package com.coms360.batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class JsonSplitTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\testFiles\\test.json");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.flush();
		fileWriter.close();

	}

}
