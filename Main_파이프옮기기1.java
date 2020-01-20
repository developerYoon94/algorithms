package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PipeLoc{
	int X;
	int Y;
	int Type;

	public PipeLoc(int x, int y, int t) {
		this.X = x;
		this.Y = y;
		this.Type = t;
	}
}

public class Main_파이프옮기기1 {
	static int count = 0;
	static int N = 0;
	public static void dfs(int [][]map, int x, int y, int type) {
		if(x == N-1 && y == N-1) {
			count++ ;
		}else {
			if(type == 1) {
				if(y+1<N && map[x][y+1] ==0) {
					dfs(map, x, y+1, 1);
				}
				if(x+1<N &&y+1<N && map[x][y+1] ==0&& map[x+1][y] ==0&& map[x+1][y+1] ==0) {
					dfs(map, x+1, y+1, 3);
				}
			}else if(type ==2) {
				if(x+1<N && map[x+1][y] ==0) {
					dfs(map, x+1, y, 2);
				}
				if(x+1<N &&y+1<N && map[x][y+1] ==0&& map[x+1][y] ==0&& map[x+1][y+1] ==0) {
					dfs(map, x+1, y+1, 3);
				}
			}else {
				if(y+1<N && map[x][y+1] ==0) {
					dfs(map, x, y+1, 1);
				}
				if(x+1<N && map[x+1][y] ==0) {
					dfs(map, x+1, y, 2);
				}
				if(x+1<N &&y+1<N && map[x][y+1] ==0&& map[x+1][y] ==0&& map[x+1][y+1] ==0) {
					dfs(map, x+1, y+1, 3);
				}

			}
		}

		//→일때 이동 경우 Type = 1
		//1. y+1이 안막혀 있으면 가능 = start는 y+1
		//2. y+1, x+1&y+1, x+1 이 안막혀 있으면 가능 = start는 x+1&y+1
		//↓일때 이동 경우 Type = 2
		//1. x+1이 안막혀있으면 가능 = start는 x+1
		//2. y+1, x+1&y+1, x+1 이 안막혀 있으면 가능  = start는 x+1&y+1
		//↘일때 이동 경우 Type = 3
		//1. y+1이 안막혀있으면 가능 = start는 y+1
		//2. x+1이 안막혀있으면 가능 = start는 x+1
		//3. y+1, x+1&y+1, x+1 이 안막혀 있으면 가능  = start는 x+1&y+1

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int [][]map = new int[16][16];


		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(map, 0, 1, 1);
		System.out.println(count);
	}

}
