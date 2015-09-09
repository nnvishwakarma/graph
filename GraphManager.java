package org.fware.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.fware.beans.Graph;

public class GraphManager {
	
	private String fileName;
	private String fieldSeperator;
	private String lineSeperator;
	
	public GraphManager(String fileName){
		this.fileName=fileName;
		this.fieldSeperator=Graph.FIELD_SEPERATOR;
		this.lineSeperator=Graph.LINE_SEPERATOR;
	}
	public GraphManager(String fileName,String fieldSeperator,String lineSeperator){
		this.fileName= fileName;
		this.fieldSeperator=fieldSeperator;
		this.lineSeperator=lineSeperator;
	}
	
	
	public String getFieldSeperator() {
		return fieldSeperator;
	}
	public void setFieldSeperator(String fieldSeperator) {
		this.fieldSeperator = fieldSeperator;
	}
	public String getLineSeperator() {
		return lineSeperator;
	}
	public void setLineSeperator(String lineSeperator) {
		this.lineSeperator = lineSeperator;
	}
	public String getFileName() {
		return fileName;
	}
	public int [][] readGraphMatrix(boolean isVerticesAvailabel) throws IOException{
		int matrix[][]=null;
		File file = new File(getFileName());
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String currentLine=null;
		while((currentLine=reader.readLine())!=null){
			
		}
		return matrix;
	}
}
