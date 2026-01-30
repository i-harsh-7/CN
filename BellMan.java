import java.util.*;

public class BellMan{
	static class Edge{
		int src, dest, wt;
		
		public Edge(int src, int dest, int wt){
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	
	}
	
	public static void bellmanFord(ArrayList<ArrayList<Edge>> graph, int V, int src){
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		for(int i=0; i<V-1; i++){
			for(ArrayList<Edge> edgeList : graph){
				for(Edge e : edgeList){
					int u = e.src;
					int v = e.dest;
					int w = e.wt;
					
					if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
						dist[v] = dist[u] + w;
					}
				
				}
			}
		}
		
		System.out.println("Shortest Path to all the vertex : ");
		for(int i=0; i<V; i++){
			char v = (char)('A' + i);
			System.out.println("Vertex " + v + " -> " + dist[i]);
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of vertices : ");
		int V = sc.nextInt();
		System.out.print("Enter the number of edges : ");
		int E = sc.nextInt();
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for(int i=0; i<V; i++){
			graph.add(new ArrayList<>());
		}
		
		System.out.println("Enter the edges information : ( source | destination | weight )");
		for(int i=0; i<E; i++){
			char uChar = sc.next().charAt(0);
			char vChar = sc.next().charAt(0);
			int w = sc.nextInt();
			
			int u = uChar - 'A';
			int v = vChar - 'A';
			
			graph.get(u).add(new Edge(u, v, w));
			graph.get(v).add(new Edge(v, u, w));
		}
		
		System.out.print("Enter the source : ");
		char sChar = sc.next().charAt(0);
		int src = sChar - 'A';
		
		bellmanFord(graph, V, src);
		
		sc.close();
	}
}
