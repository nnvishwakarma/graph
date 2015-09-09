package org.fware.beans;

import java.awt.Color;


public class Edge {
	
	public static final boolean EDGE_DEFAULT_IS_BIDECTIONAL=false;
	public static final Color EDGE_DEFAULT_COLOR=Color.GREEN;
	
	public static final int EDGE_DEFAULT_WIDTH=2;
	
	private Vertex fromVertex;
	private Vertex toVertex;
	private boolean isBidirectional;
	private Color color;
	private int width;
	
	public Edge(Vertex fromVertex,Vertex toVertex){
		this.isBidirectional=EDGE_DEFAULT_IS_BIDECTIONAL;
		this.color=EDGE_DEFAULT_COLOR;
		this.width=EDGE_DEFAULT_WIDTH;
		
		this.fromVertex=fromVertex;
		this.toVertex=toVertex;
		
	}
	
	public Edge(Vertex fromVertex,Vertex toVertex,Color color){
		this.isBidirectional=EDGE_DEFAULT_IS_BIDECTIONAL;
		this.width=EDGE_DEFAULT_WIDTH;
		
		this.color=color;
		this.fromVertex=fromVertex;
		this.toVertex=toVertex;
		
	}
	public Edge(Vertex fromVertex,Vertex toVertex,int width){
		this.isBidirectional=EDGE_DEFAULT_IS_BIDECTIONAL;		
		this.color=EDGE_DEFAULT_COLOR;
		
		this.width=width;
		this.fromVertex=fromVertex;
		this.toVertex=toVertex;
		
	}
	
	public Edge(Vertex fromVertex,Vertex toVertex,Color color,int width){
		this.isBidirectional=EDGE_DEFAULT_IS_BIDECTIONAL;
		
		this.color=color;
		this.width=width;
		this.fromVertex=fromVertex;
		this.toVertex=toVertex;
		
	}
	public Vertex getFromVertex() {
		return fromVertex;
	}
	public void setFromVertex(Vertex fromVertex) {
		this.fromVertex = fromVertex;
	}
	public Vertex getToVertex() {
		return toVertex;
	}
	public void setToVertex(Vertex toVertex) {
		this.toVertex = toVertex;
	}
	public boolean isBidirectional() {
		return isBidirectional;
	}
	public void setBidirectional(boolean isBidirectional) {
		this.isBidirectional = isBidirectional;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString(){
		return String.format("Edge[FV:%s, TV:%s, BiDir:%s, Width:%d, Color:%s] ",
								getFromVertex().toStringShort(),
								getToVertex().toStringShort(),
								String.valueOf(isBidirectional()),
								getWidth(),
								getColor().toString()
							);
	}
	
	public String toStringShort(){
		return String.format("E[%s:%s:%s] ",
								getFromVertex().toStringShort(),
								getToVertex().toStringShort(),
								String.valueOf(isBidirectional())
							);
				
	}
	
	public String toStringLong(){
		return String.format("Edge[FV:%s, TV:%s, BiDir:%s, Width:%d, Color:%s] ",
				getFromVertex().toString(),
				getToVertex().toString(),
				String.valueOf(isBidirectional()),
				getWidth(),
				getColor().toString()
			);
	}
	
	
}
