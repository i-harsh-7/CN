import  java.util.*;
import java.lang.*;

public class DijkstraGraph{

	static class Edge{
		int ver, w;
		
		public Edge(int ver, int w){
			this.ver = ver;
			this.w = w;
		}
	}
	
	public static void dijkstra(int V, List<List<Edge>> graph, int src){
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[]{src, 0});
		
		while(!pq.isEmpty()){
			int curr[] = pq.poll();
			int u = curr[0];
			
			for(Edge edge : graph.get(u)){
				int v = edge.ver;
				int w = edge.w;
				
				if(dist[u] + w < dist[v]){
					dist[v] = dist[u] + w;
					pq.add(new int[]{v , w});
				}
			}
		}
		
		System.out.println("Shortest Path to all the vertex : ");
		for(int i=0; i<V; i++){
			char v = (char)('A' + i);
			System.out.println("Vertex " + v + " -> " + dist[i]);
		}
		
	
	}
	
	public static void main(String[] abcd){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of vertices : ");
		int V = sc.nextInt();
		
		System.out.print("Enter the number of edges : ");
		int E = sc.nextInt();
		
		List<List<Edge>> graph = new ArrayList<>();
		
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
			
			graph.get(u).add(new Edge(v, w));
			graph.get(v).add(new Edge(u, w));
		}
		
		System.out.print("Enter the source : ");
		char sChar = sc.next().charAt(0);
		int src = sChar - 'A';
		
		dijkstra(V, graph, src);
		
		sc.close();
	}
}
