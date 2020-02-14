package swExpert;

import java.io.FileInputStream;
import java.util.Scanner;

class Core{
	int X;
	int Y;

	public Core(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
}

public class Solution_프로세서연결하기 {
	static int minLen = 987654321;
	static int maxCnt = 0;
	static int coreCnt = 0;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int N;
	static int arr[][];
	static Core core[];

	public static boolean drawOkay(int x, int y, int dir) {
		while(true) {
			x += dx[dir];
			y += dy[dir];

			//벽이면
			if(x<0 || x>=N || y<0 || y>=N) {
				//라인 저장
				return true;
			}

			//막히면
			if(arr[x][y] == 1) {
				return false;
			}

		}
	}

	public static int draw(int x, int y, int dir, int val) {
		int len = 0;
		while(true) {
			x += dx[dir];
			y += dy[dir];

			//벽이면
			if(x<0 || x>=N || y<0 || y>=N) {
				return len;
			}
			len++;
			arr[x][y] = val;			
		}
	}

	public static void dfs(int coreIdx, int len, int cnt) {
		if(coreIdx == coreCnt) {
			if(cnt>maxCnt) {
				maxCnt = cnt;
				minLen = len;
			}
			else if(cnt==maxCnt) {
				if(len < minLen) {
					minLen = len;
				}
			}
		}else {
			if(core[coreIdx].X ==0 || core[coreIdx].X==N-1 || core[coreIdx].Y ==0 || core[coreIdx].Y==N-1) {
				dfs(coreIdx+1, len, cnt+1);
			}else {
				for(int i=0;i<4;i++) {
					//if(coreIdx == 6) 
						//System.out.println(drawOkay(core[coreIdx].X, core[coreIdx].Y, i));
					if(drawOkay(core[coreIdx].X, core[coreIdx].Y, i)) {
						len += draw(core[coreIdx].X, core[coreIdx].Y, i, 1);
						dfs(coreIdx+1, len, cnt+1);
						len -= draw(core[coreIdx].X, core[coreIdx].Y, i, 0);
					}
				}
				dfs(coreIdx+1, len, cnt);
			}
		}
	}

	public static void clear() {
		minLen = 987654321;
		maxCnt = 0;
		N = 0;
		coreCnt = 0;
	}

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			arr = new int [N][N];
			core = new Core[100];

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) {
						core[coreCnt] = new Core(i,j);
						coreCnt++;
					}
				}
			}
			dfs(0,0,0);
			
			System.out.println("#"+test_case+" "+minLen);

			clear();
		}
	}
}
