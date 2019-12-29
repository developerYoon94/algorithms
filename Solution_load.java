package swExpert;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Pair{
	int X;
	int Y;
	int Level;

	public Pair(int x, int y) {
		this.X = x;
		this.Y = y;
	}
}
public class Solution_load {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;

		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();

			int [][] map = new int[N][N];

			int result=0;
			int max = 0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] > max) max = map[i][j];
				}
			}

			//if(test_case != 1) continue;
			Pair []pair = new Pair[10];
			int cnt = 0;
			//가장 높은 봉우리 위치 기억
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == max) {
						pair[cnt] = new Pair(i,j);
						cnt++;
					}
				}
			}

			//전체 하나씩 다 깎아가면서 BFS 실행, 깎고 가장 높은 봉우리부터 시작하는거 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					boolean check = false;
					int tmp = map[i][j];
					
					for(int a = K;a>=0;a--) {
					if(map[i][j] - a >= 0) {
						map[i][j] -= a;
						check = true;
					}else if(map[i][j] - a < 0) {
						tmp = map[i][j];
						map[i][j] = 0;
					}
					for(int k=0;k<cnt;k++) {

						//System.out.println();
						//if(pair[k].X == i && pair[k].Y == j) {
						//봉우리 탐색 안함
						//}else {
						boolean [][]visited = new boolean[N][N];
						Queue <Pair> q =  new LinkedList<Pair>();
						Pair start = new Pair(pair[k].X,pair[k].Y);
						start.Level = 1;
						q.offer(start);

						if(result<start.Level) result = start.Level;

						//System.out.print(" "+ "("+start.X+","+start.Y+"), "+start.Level+" ");
						//visited[start.X][start.Y] = true;
						//result++;
						while(!q.isEmpty()) {
							start = q.poll();
							//오른
							if(start.Y<N-1 && map[start.X][start.Y+1]<map[start.X][start.Y]) {// && !visited[start.X][start.Y+1]) {
								Pair temp = new Pair(start.X,start.Y+1);
								temp.Level = start.Level+1;
								q.offer(temp);

								//System.out.print(" "+ "("+(temp.X)+","+(temp.Y)+"), "+temp.Level+" ");
								visited[start.X][start.Y+1] = true;
								if(result<temp.Level) result = temp.Level;
							}
							//아래
							if(start.X<N-1 &&map[start.X+1][start.Y]<map[start.X][start.Y] ) {//&& !visited[start.X+1][start.Y] ) {
								Pair temp = new Pair(start.X+1,start.Y);
								temp.Level = start.Level+1;
								q.offer(temp);

								//System.out.print(" "+ "("+(temp.X)+","+(temp.Y)+"), "+temp.Level+" ");
								visited[start.X+1][start.Y] = true;
								if(result<temp.Level) result = temp.Level;
							}
							//왼
							if(start.Y>0 && map[start.X][start.Y-1]<map[start.X][start.Y] ) {//&& !visited[start.X][start.Y-1] ) {
								Pair temp = new Pair(start.X,start.Y-1);
								temp.Level = start.Level+1;
								q.offer(temp);
								//System.out.print(" "+ "("+(temp.X)+","+(temp.Y)+"), "+temp.Level+" ");
								visited[start.X][start.Y-1] = true;
								if(result<temp.Level) result = temp.Level;
							}
							//위
							if(start.X>0 && map[start.X-1][start.Y]<map[start.X][start.Y]) {// && !visited[start.X-1][start.Y]) {
								Pair temp = new Pair(start.X-1,start.Y);
								temp.Level = start.Level+1;
								q.offer(temp);
								//System.out.print(" "+ "("+(temp.X)+","+(temp.Y)+"), "+temp.Level+" ");
								visited[start.X-1][start.Y] = true;
								if(result<temp.Level) result = temp.Level;
							}

						}


						//}
					}


					if(check)
						map[i][j] += a;
					else if(map[i][j] == 0) {

						map[i][j] = tmp;
					}
				}
				}
			}
			System.out.println("#"+test_case+" "+ result);
		}

	}

}
