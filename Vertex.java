package org.fware.beans;

import java.awt.Color;

public class Vertex {
	/*Default Constant*/
	public static final int VERTEX_DEFAULT_SIZE=5;
	public static final int VERTEX_DEFAULT_ID=0;
	public static final Color VERTEX_DEFAULT_COLOR=Color.BLUE;
	public static final String VERTEX_DEFAULT_LABEL="N/L";
	
	private Integer id;
	private String label;
	private Color color;
	private int size;
	
	public Vertex(){
		this.id=VERTEX_DEFAULT_ID;
		this.label=VERTEX_DEFAULT_LABEL;
		this.color=VERTEX_DEFAULT_COLOR;
		this.size=VERTEX_DEFAULT_SIZE;
	}
	public Vertex(String label){
		this.id=VERTEX_DEFAULT_ID;		
		this.color=VERTEX_DEFAULT_COLOR;
		this.size=VERTEX_DEFAULT_SIZE;
		
		this.label=label;
	}
	public Vertex(String label,Color color){
		this.id=VERTEX_DEFAULT_ID;
		this.size=VERTEX_DEFAULT_SIZE;
		
		this.color=color;
		this.label=label;
	}
	public Vertex(String label,Color color,int size){
		this.id=VERTEX_DEFAULT_ID;
		
		this.size=size;		
		this.color=color;
		this.label=label;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString(){
		return String.format("Vertex[ Id: %d, Label : %s, Size: %d, Color: %s ]",
				getId().intValue(),
				getLabel(),
				getSize(),
				getColor().toString());
	}
	public String toStringShort(){
		return String.format(" V[%d:%s] ",
				getId().intValue(),
				getLabel());
	}
}
