package org.fware.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="FileUploadServlet",urlPatterns="/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html;charset=UTF-8");
		
		final String path= request.getParameter("destination");
		final Part filePart = request.getPart("file");
		final String fileName = getFileName(filePart);
		final PrintWriter writer = response.getWriter();
		
		Collection<Part> parts =request.getParts();
		for(Part part : parts){
			writer.println(part.getName()+"  ==>   "+part.getHeaderNames());
		}
		OutputStream out = null;
		InputStream fileContents = null;
		
		try{
			out=new FileOutputStream(new File(path+File.separator+fileName));
			fileContents = filePart.getInputStream();
			int read=0;
			
			final byte []bytes = new byte[1024];
			
			while((read = fileContents.read(bytes))!=-1){
				out.write(bytes,0,read);
			}
			writer.println("New File "+fileName+" created at "+path);
			System.out.println("File "+fileName +" uploaded to "+path);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(out!=null) {
				out.close();
			}
			if(fileContents!=null) {
				fileContents.close();
			}
			if(writer!=null) {
				writer.close();
			}
		}
	}
	
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    String fileName=null;
	    System.out.println("Part Header = "+ partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	    	System.out.println(content);
	        if (content.trim().startsWith("filename")) {
	            fileName=content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	            System.out.println("*****"+fileName);
	            System.out.println("Seperator :: "+File.separator);
	            System.out.println("Last Index :: "+fileName.lastIndexOf(File.separator));
	            System.out.println("Length :: "+fileName.length());
	            fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1,fileName.length());
	            
	        }
	    }
	    return fileName;
	}
	
	public static void main(String []arrg){
		String fileName;
		String content="C:\\Users\\nvishwak020614\\Desktop\\mvn.txt";
		fileName=content.substring(
                content.indexOf('=') + 1).trim().replace("\"", "");
        fileName = fileName.substring(content.lastIndexOf(File.separator)+1,fileName.length());
        System.out.println(fileName);
	}
}
