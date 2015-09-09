package org.fware.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List; 
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Graph {
	
	public static final String FIELD_SEPERATOR=",";
	public static final String LINE_SEPERATOR=";";
	public static final long TIME_OUT_IN_MILLISECOND=10;
	
	private int graph_Id;
	private String label;	
	private List<Vertex> vertices;
	private List<Edge> edges;
	private int [][] graphMatrix;
	private Integer noOfVertices;
	private String[] strVertices;
	private Map<Vertex, Integer> verticesIndex;
	
	private ReentrantLock addVertexLock=null;
	private ReentrantLock removeVertexLock=null;
	
	private ReentrantLock addEdgeLock=null;
	private ReentrantLock removeEdgeLock=null;
	
	public Graph(){
		this.graphMatrix=null;
		this.graph_Id=0;
		this.label="N/L";
		this.vertices=new ArrayList<Vertex>();
		this.edges=new ArrayList<Edge>();
		
		this.addVertexLock = new ReentrantLock(true);
		this.removeVertexLock = new ReentrantLock(true);
		
		this.addEdgeLock = new ReentrantLock(true);
		this.removeEdgeLock = new ReentrantLock(true);
	}
	
	public void addVertex(Vertex vertex){
		try{
			addVertexLock.tryLock(TIME_OUT_IN_MILLISECOND,TimeUnit.MILLISECONDS);
			this.vertices.add(vertex);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			addVertexLock.unlock();
		}
	}
	public void removeVertex(Vertex vertex) {
		try{
			removeVertexLock.tryLock(TIME_OUT_IN_MILLISECOND, TimeUnit.MILLISECONDS);
			this.vertices.remove(vertex);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			removeVertexLock.unlock();
		}
	}
	
	public void addEdge(Edge edge)	{
		try{
			addEdgeLock.tryLock(TIME_OUT_IN_MILLISECOND,TimeUnit.MILLISECONDS);
			this.edges.add(edge);
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			addEdgeLock.unlock();
		}
	}
	public void removeEdge(Edge edge) {
		try{
			removeEdgeLock.tryLock(TIME_OUT_IN_MILLISECOND, TimeUnit.MILLISECONDS);
			this.edges.remove(edge);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			removeEdgeLock.unlock();
		}
	}
	
	public int getGraph_Id() {
		return graph_Id;
	}
	public void setGraph_Id(int graph_Id) {
		this.graph_Id = graph_Id;
	}	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Vertex> getVertices() {
		return Collections.unmodifiableList(vertices);
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getEdges() {
		return Collections.unmodifiableList(edges);
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	

	private int[][] getGraphMatrix() {
		return graphMatrix;
	}

	/*public void setGraphMatrix(int[][] graphMatrix) {
		this.graphMatrix = graphMatrix;
	}*/

	public Integer getNoOfVertices() {
		return noOfVertices;
	}

	/*public void setNoOfVertices(Integer noOfVertices) {
		this.noOfVertices = noOfVertices;
	}
*/
	public String[] getStrVertices() {
		return strVertices;
	}

	/*private void setStrVertices(String[] strVertices) {
		this.strVertices = strVertices;
	}*/

	private void setStrVertices(List<Vertex> vertices) {
		int idx=0;
		this.strVertices=new String[vertices.size()];
		for(Vertex cVertex : vertices) {
			this.strVertices[idx++]=cVertex.getLabel();			
		}
	}
	
	public Map<Vertex, Integer> getVerticesIndex(){
		return this.verticesIndex;
	}
	
	private void setVerticesIndex(List<Vertex> vertices){
		verticesIndex=new HashMap<Vertex, Integer>(getVertices().size());
		for(Vertex cVertex : vertices){
			verticesIndex.put(cVertex, vertices.indexOf(cVertex));
		}
	}
	
	public String toString()
	{
		return null;
	}
	public void prepareGraphMatix(){
		
		this.noOfVertices=getVertices().size();
		setStrVertices(getVertices());
		setVerticesIndex(getVertices());
		
		this.graphMatrix=new int[getNoOfVertices()][getNoOfVertices()];
		/*Initializing Label of Graph Matrix */		
		for(Edge cEdge : getEdges()){
			graphMatrix[getVerticesIndex().get(cEdge.getFromVertex())][getVerticesIndex().get(cEdge.getToVertex())]=1;
		}
	}
	public void printGraph(){
		int counter=0; 
		StringBuilder strPattern=new StringBuilder(String.format("%5s",""));		
		for(String strVertex : getStrVertices()){
			strPattern.append(String.format("%5s",strVertex));			
		}
		System.out.println(strPattern.toString());
		for(int[] lRecord : graphMatrix){
			System.out.println();
			System.out.printf("%5s",getStrVertices()[counter++]);
			for(int entry : lRecord){
				System.out.printf("%5s",entry);
			}
		}
	}
	public String graphMatrixToWrite(){
		StringBuffer graph=new StringBuffer();
		graph=addVerticesAsHeader(graph);
		for(int [] edgeLine : getGraphMatrix()){
			graph.append(LINE_SEPERATOR);
			for(int edge : edgeLine){
				graph.append(edge);
				graph.append(FIELD_SEPERATOR);
			}
		}
		return graph.toString();
	}

	private StringBuffer addVerticesAsHeader(StringBuffer graph) {
		for(Vertex vertex : getVertices()){
			graph.append(vertex.getLabel());
		}
		return graph;
	}
}
