package swExpert;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Pair{
	int X;
	int Y;
	int Level;
    
	public Pair(int x, int y, int l) {
		this.X = x;
		this.Y = y;
		this.Level = l;
	}
}

public class Solution_등산로조성 {

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("src/sample_input.txt"));
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

			Pair []pair = new Pair[6];
			int cnt = 0;
			//가장 높은 봉우리 위치, 개수 기억
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j] == max) {
						pair[cnt] = new Pair(i,j, 1);
						cnt++;
					}
				}
			}

			//전체 하나씩 깎아보면서 BFS 실행, 깎고 가장 높은 봉우리부터 시작함
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					boolean check = false;
					int tmp = map[i][j];

					//최대공사높이 K부터 0까지 깎아봄
					for(int a = K;a>=0;a--) {
						//깎고나서 깎았는지 체크
						if(map[i][j] - a >= 0) {
							map[i][j] -= a;
							check = true;
						}
						for(int k=0;k<cnt;k++) {
							Queue <Pair> q =  new LinkedList<Pair>();
							//출발지 Level(Depth) 1 세어줌
							Pair start = new Pair(pair[k].X,pair[k].Y, 1);
							q.offer(start);

							if(result<start.Level) result = start.Level;

							while(!q.isEmpty()) {
								start = q.poll();
								//오른
								if(start.Y<N-1 && map[start.X][start.Y+1]<map[start.X][start.Y]) {
									Pair temp = new Pair(start.X,start.Y+1, start.Level+1);
									q.offer(temp);
									//현재 깊이가 최대면 저장
									if(result<temp.Level) result = temp.Level;
								}
								//아래
								if(start.X<N-1 &&map[start.X+1][start.Y]<map[start.X][start.Y] ) {
									Pair temp = new Pair(start.X+1,start.Y, start.Level+1);
									q.offer(temp);
									//현재 깊이가 최대면 저장
									if(result<temp.Level) result = temp.Level;
								}
								//왼
								if(start.Y>0 && map[start.X][start.Y-1]<map[start.X][start.Y] ) {
									Pair temp = new Pair(start.X,start.Y-1, start.Level+1);
									q.offer(temp);
									//현재 깊이가 최대면 저장
									if(result<temp.Level) result = temp.Level;
								}
								//위
								if(start.X>0 && map[start.X-1][start.Y]<map[start.X][start.Y]) {
									Pair temp = new Pair(start.X-1,start.Y, start.Level+1);
									q.offer(temp);
									//현재 깊이가 최대면 저장
									if(result<temp.Level) result = temp.Level;
								}

							}
						}
						//깎은거면 다시 원복
						if(check)
							map[i][j] += a;
					}
				}
			}
			System.out.println("#"+test_case+" "+ result);
		}

	}

}
