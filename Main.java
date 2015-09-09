package org.fware.beans;
/*
	A	B	C	D	
A	1	0	1	1
B	0	0	0	1
C	1	1	0	1
D	0	1	1	0
 
 */

public class Main {
	public static void main(String str[]){
		Graph graph=new Graph();
		Vertex vertexA=new Vertex("A");
		Vertex vertexB=new Vertex("B");
		Vertex vertexC=new Vertex("C");
		Vertex vertexD=new Vertex("D");
		graph.addVertex(vertexA);
		graph.addVertex(vertexB);
		graph.addVertex(vertexC);
		graph.addVertex(vertexD);
		
		Edge edgeAA=new Edge(vertexA, vertexA); 
		Edge edgeAC=new Edge(vertexA, vertexC);
		Edge edgeAD=new Edge(vertexA, vertexD);
		Edge edgeBD=new Edge(vertexB, vertexD);
		Edge edgeCA=new Edge(vertexC, vertexA);
		Edge edgeCB=new Edge(vertexC, vertexB);
		Edge edgeCD=new Edge(vertexC, vertexD);
		Edge edgeDB=new Edge(vertexD, vertexB);
		Edge edgeDC=new Edge(vertexD, vertexC);
		
		graph.addEdge(edgeAA);
		graph.addEdge(edgeAC);		
		graph.addEdge(edgeDB);
		graph.addEdge(edgeDC);
		graph.addEdge(edgeAD);
		graph.addEdge(edgeBD);
		graph.addEdge(edgeCA);
		graph.addEdge(edgeCB);
		graph.addEdge(edgeCD);
		
		graph.prepareGraphMatix();
		graph.printGraph();
	}
}
