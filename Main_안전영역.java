package baekjoon;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



class Loc1{
	int X;
	int Y;

	public Loc1(int x, int y) {
		this.X = x;
		this.Y = y;
	}
}

public class Main_안전영역 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = 0;
		int [][]map = new int[100][100];
		int cnt = 1;
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(!hm.containsValue(map[i][j])) {
					hm.put(cnt, map[i][j]);
					cnt++;
				}
			}
		}
		boolean [][]visited;
		for(int a=1;a<cnt;a++) {
			int t = hm.get(a);
			visited = new boolean[100][100];
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>t && !visited[i][j]) {
						count++;
						
						Queue <Loc1> q =  new LinkedList<Loc1>();
						Loc1 start = new Loc1(i,j);
						q.offer(start);
						visited[start.X][start.Y] = true;
						
						while(!q.isEmpty()) {
							start = q.poll();
							//System.out.println(count+ ": "+ start.X+ ", "+start.Y);
							//visited[start.X][start.Y] = true;
							//오른
							if(start.Y<N-1 && map[start.X][start.Y+1]>t && !visited[start.X][start.Y+1]) {
								q.offer(new Loc1(start.X,start.Y+1));
								visited[start.X][start.Y+1] = true;
							}
							//아래
							if(start.X<N-1 &&map[start.X+1][start.Y]>t && !visited[start.X+1][start.Y] ) {
								q.offer(new Loc1(start.X+1,start.Y));
								visited[start.X+1][start.Y] = true;
							}
							//왼
							if(start.Y>0 && map[start.X][start.Y-1]>t && !visited[start.X][start.Y-1] ) {
								q.offer(new Loc1(start.X,start.Y-1));
								visited[start.X][start.Y-1] = true;
							}
							//위
							if(start.X>0 && map[start.X-1][start.Y]>t && !visited[start.X-1][start.Y]) {
								q.offer(new Loc1(start.X-1,start.Y));
								visited[start.X-1][start.Y] = true;
							}
						}

					}
				}
			}
			if(result<count) result = count;

		}
		if(result == 0) result = 1;
		System.out.println(result);

	}

}
