package swExpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pipe {
	boolean up, down, left, right;
	int P;
	int X;
	int Y;

	public Pipe(int n, int x, int y) {
		this.X = x;
		this.Y = y;
		P = n;
		switch(n) {
		case 0: up = false; down = false; left = false; right = false;
		break;
		case 1: up = true; down = true; left = true; right = true;
		break;
		case 2: up = true; down = true; left = false; right = false;
		break;
		case 3: up = false; down = false; left = true; right = true;
		break;
		case 4: up = true; down = false; left = false; right = true;
		break;
		case 5: up = false; down = true; left = false; right = true;
		break;
		case 6: up = false; down = true; left = true; right = false;
		break;
		case 7: up = true; down = false; left = true; right = false;
		break;			
		}
	}	
}
class Loc{
	int X;
	int Y;
	int T;
	public Loc(int x, int y, int t) {
		this.X = x;
		this.Y = y;
		this.T = t;
	}
}
class Solution_탈주범검거
{
	static int count = 0;
	static int L;
	static int pipeNum = 0;


	static boolean visited[][];

	public static void bfs(int x, int y, int time, Pipe [][]P) {
		Queue <Loc> q =  new LinkedList<Loc>();
		Loc temp = new Loc(x,y, time);
		q.offer(temp);

		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.T >= L) return;
			count++;
			//System.out.println("X: "+ temp.X+ " Y: "+temp.Y + " N: " + P[temp.X][temp.Y].P );
			Loc pipe;
			if(P[temp.X][temp.Y].up && !visited[temp.X-1][temp.Y]) {
				pipe = new Loc(P[temp.X-1][temp.Y].X, P[temp.X-1][temp.Y].Y, temp.T+1);
				q.offer(pipe);

				visited[pipe.X][pipe.Y] = true; 
			}
			if(P[temp.X][temp.Y].down&& !visited[temp.X+1][temp.Y]) {
				pipe = new Loc(P[temp.X+1][temp.Y].X, P[temp.X][temp.Y].Y, temp.T+1);
				q.offer(pipe);
				visited[pipe.X][pipe.Y] = true; 
			}
			if(P[temp.X][temp.Y].left&& !visited[temp.X][temp.Y-1]) {
				pipe = new Loc(P[temp.X][temp.Y-1].X, P[temp.X][temp.Y-1].Y, temp.T+1);
				q.offer(pipe);
				visited[pipe.X][pipe.Y] = true; 
			}
			if(P[temp.X][temp.Y].right&& !visited[temp.X][temp.Y+1]) {
				pipe = new Loc(P[temp.X][temp.Y+1].X, P[temp.X][temp.Y+1].Y, temp.T+1);
				q.offer(pipe);
				visited[pipe.X][pipe.Y] = true; 
			}
		}
	}

	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;

		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();//세로
			int M = sc.nextInt();//가로
			int R = sc.nextInt();//세로위치
			int C = sc.nextInt();//가로위치
			L = sc.nextInt();//시간

			count = 0;//탈주범이 있을 수 있는 곳
			visited = new boolean[50][50];


			int map[][] = new int[50][50];
			Pipe [][]pipeMap = new Pipe[50][50];
			pipeNum = 0;
			for(int i=0;i<N;i++) {
				//pipeMap[i] = new Pipe[50];
				for(int j=0;j<M;j++) {
					int temp = sc.nextInt();
					map[i][j] = temp;
					pipeMap[i][j] = new Pipe(temp, i, j);
					if(temp !=0) pipeNum++;
				}
			}
			for(int i=0;i<N;i++) {
				//pipeMap[i] = new Pipe[50];
				for(int j=0;j<M;j++) {
					//위
					if(i==0) {
						pipeMap[i][j].up = false;
					}else if(pipeMap[i][j].up && !pipeMap[i-1][j].down) {
						pipeMap[i][j].up = false;
					}
					//왼
					if(j==0) {
						pipeMap[i][j].left = false;
					}else if(pipeMap[i][j].left && !pipeMap[i][j-1].right) {
						pipeMap[i][j].left = false;
					}
					//아래
					if(i==N-1) {
						pipeMap[i][j].down = false;
					}else if(pipeMap[i][j].down && !pipeMap[i+1][j].up) {
						pipeMap[i][j].down = false;
					}
					//오
					if(j==M-1) {
						pipeMap[i][j].right = false;
					}else if(pipeMap[i][j].right && !pipeMap[i][j+1].left) {
						pipeMap[i][j].right = false;
					}
				}
			}
			
			bfs(R,C,0, pipeMap);
			
			if(L==1)
				System.out.println("#"+test_case+" " +1);
			else
				System.out.println("#"+test_case+" " +(count-1));
		}
	}
}