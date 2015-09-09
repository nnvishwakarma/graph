package org.fware.logica;

public class FetchVertexLabel {
	private static final char[] ALPLABETS={'A','B','C','D','E','F','G','H','I',
		'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public String getVertexLabel(int offset){	
		if(offset<=26) {
			return String.valueOf(ALPLABETS[offset-1]);
		}
		else {			
			return String.valueOf(ALPLABETS[ALPLABETS.length-1])+getVertexLabel(offset-ALPLABETS.length);
		}
	}
	
	public String getVertexLabelSimple(int vertexNo){
		return "V"+String.valueOf(vertexNo);
	}
	public static void main(String []arrg){
		FetchVertexLabel f=new FetchVertexLabel();
		System.out.println(f.getVertexLabelSimple(2236));
	}
	
}
