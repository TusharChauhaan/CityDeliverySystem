package Main;

import DataBase.ZonesData;

import java.util.ArrayList;
import java.util.Arrays;

import Classes.Zone;

public class Demo {
	
	private static Zone z[] = ZonesData.getZones();
	public static int adjacencyMatrix[][];
	private static Edge edgelist[];
	private static final int NO_PARENT = -1; 
	public static ArrayList<Integer> str = new ArrayList<Integer>();
	public Demo(){

		edgelist = new Edge[13];
	
		edgelist[0] = new Edge(1,2);
		edgelist[1] = new Edge(2,3);
		edgelist[2] = new Edge(3,4);
		edgelist[3] = new Edge(1,4);
		edgelist[4] = new Edge(3,6);
		edgelist[5] = new Edge(4,5);
		edgelist[6] = new Edge(5,6);
		edgelist[7] = new Edge(6,7);
		edgelist[8] = new Edge(5,8);
		edgelist[9] = new Edge(7,8);
		edgelist[10] = new Edge(7,10);
		edgelist[11] = new Edge(8,9);
		edgelist[12] = new Edge(10,9);

		adjacencyMatrix = new int[10][10];
	
		for(int i=0;i<13;i++) {
			int s = edgelist[i].start;
			int e = edgelist[i].end;
		
			adjacencyMatrix[s-1][e-1]=adjacencyMatrix[e-1][s-1]=distance(s,e);
		}
	
	}
	////////////////////////////////////////////////////////////////////
	public void printGraph() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				System.out.print(adjacencyMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	///////////////////////////////////////////////////////////////////////
	private int distance(int s, int e) {
		
		double x1 = z[s-1].getCoordinateX();
		double x2 = z[e-1].getCoordinateX();
		
		double y1 = z[s-1].getCoordinateY();
		double y2 = z[e-1].getCoordinateY();
		
		double a = Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2);
		int dist = (int)(1000*Math.sqrt(a));
		
		return dist;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<Integer> getPath(int startVertex,int end) 
	{ 
		startVertex--;
		end--;
		int nVertices = adjacencyMatrix[0].length; 
		//shortestDistances[i] will keep the shortest distance from src to i 
		int[] shortestDistances = new int[nVertices]; 
		boolean[] added = new boolean[nVertices]; 
		//pahle sabko infinity banaya
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
		{ 
			shortestDistances[vertexIndex] = Integer.MAX_VALUE; 
			added[vertexIndex] = false; 
		} 
		//distance from itself will be zero
		shortestDistances[startVertex] = 0; 
		//parent array path store karega
		int[] parents = new int[nVertices]; 
		// starting vertex ka koi parent nhi h....
		parents[startVertex] = NO_PARENT; 
		//finding shortest path for all those
		for (int i = 1; i < nVertices; i++) 
		{ 

			// Pick the minimum distance vertex 
			// from the set of vertices not yet 
			// processed. nearestVertex is 
			// always equal to startNode in 
			// first iteration. 
			int nearestVertex = -1; 
			int shortestDistance = Integer.MAX_VALUE; 
			for (int vertexIndex = 0; 
					vertexIndex < nVertices; 
					vertexIndex++) 
			{ 
				if (!added[vertexIndex] && 
					shortestDistances[vertexIndex] < 
					shortestDistance) 
				{ 
					nearestVertex = vertexIndex; 
					shortestDistance = shortestDistances[vertexIndex]; 
				} 
			} 

			// Mark the picked vertex as 
			// processed 
			added[nearestVertex] = true; 

			// Update dist value of the 
			// adjacent vertices of the 
			// picked vertex. 
			for (int vertexIndex = 0; 
					vertexIndex < nVertices; 
					vertexIndex++) 
			{ 
				int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex]; 
				
				if (edgeDistance > 0
					&& ((shortestDistance + edgeDistance) < 
						shortestDistances[vertexIndex])) 
				{ 
					parents[vertexIndex] = nearestVertex; 
					shortestDistances[vertexIndex] = shortestDistance + 
													edgeDistance; 
				} 
			} 
		} 

		makeList(startVertex, shortestDistances, parents,end);
		return str;
	}
	////////////////////////////////////////////////////////////////////////////////////////
	private static void makeList(int startVertex, int[] distances, int[] parents,int end) 
	{ 
		int nVertices = distances.length; 
		//System.out.print("Zone\t \tDistance\tPath"); 
		
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) 
		{ 
			if (vertexIndex != startVertex && vertexIndex==end) 
			{ 
				addToList(vertexIndex, parents); 
			} 
		} 
	} 
	//////////////////////////////////////////////////////////////////////////////////////////
	private static void addToList(int currentVertex, int[] parents) 
	{ 
		
		// Base case : Source node has 
		// been processed 
		if (currentVertex == NO_PARENT) 
		{ 
			return; 
		} 
		addToList(parents[currentVertex], parents); 
		 
		str.add((currentVertex+1));
	} 
	////////////////////////////////////////////////////////////////////////////////////////////
}

class Edge{
	int start;
	int end;
	
	Edge(int s, int e) {
		start = s;
		end = e;
	}
}