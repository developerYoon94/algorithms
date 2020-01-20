package baekjoon;

import java.util.Scanner;
class house {
	int x;
	int y;
	public void house() {
		this.x = 0;
		this.y = 0;
	}
}
class chicken {
	int x;
	int y;
	public void chicken() {
		this.x = 0;
		this.y = 0;
	}
}
public class Main_치킨배달 {
	static int arr[][] ;
	static int M;
	static int cntChicken =0;
	static int cntHouse =0;
	static chicken ck[];
	static house hs[];
	public static void main(String[] args) {
	/*	5 2
		0 2 0 1 0
		1 0 1 0 0
		0 0 0 0 0
		2 0 0 1 1
		2 2 0 1 2*/
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[51][51];
		ck = new chicken[14];
		hs = new house[101];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] =  sc.nextInt();
				if(arr[i][j]==2) {
					ck[cntChicken] = new chicken();
					ck[cntChicken].x = i;
					ck[cntChicken].y = j;
					cntChicken++;
				}else if(arr[i][j]==1) {
					hs[cntHouse] = new house();
					hs[cntHouse].x = i;
					hs[cntHouse].y = j;
					cntHouse++;
				}
			}
		}
		
		//치킨집 개수만큼 dfs 돌림
		boolean flag[] = new boolean[14];
		int chk[] = new int[14];
		dfs(flag, chk);
		int sum = 0;
		System.out.println(min);
	}
	static int min = 999999;
	static int count=0;
	static int minDis(int array[], int hsIdx) {
		int minDis = 999999;
		int dis;
		int j = 0;
		for(int i=0;i<M;i++) {
			dis = Math.abs(ck[array[i]].x-hs[hsIdx].x)+Math.abs(ck[array[i]].y-hs[hsIdx].y);
			if(minDis>dis) {
				minDis = dis;
				j=i;
			}
			
		}

		//System.out.println("x:"+ck[array[j]].x +"/y:" +ck[array[j]].y);

		return minDis;
	}
	static void dfs(boolean flag[], int chk[]) {
		//3개 다 골랐을때 이제 sum 계산
		if(count >= M) {
			//집 별로 가장 가까운 치킨집 고름
			int sum = 0;
			for(int i=0;i<cntHouse;i++) {
				sum +=minDis(chk, i);
			}
			if(min > sum) min = sum;
			
		}else{
			for(int i=0;i<cntChicken;i++) {
				if(count>0 && i>chk[count-1])
					continue;
				if(!flag[i]) {
					//치킨집 리스트에 추가
					chk[count] = i;
					count++;
					flag[i] = true;
					dfs(flag, chk);
					flag[i] = false;
					count--;
					//치킨집 비워둠
					chk[count] = -1;
				}
			}
		}
	}

}
