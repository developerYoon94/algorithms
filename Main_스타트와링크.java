package baekjoon;

import java.util.Scanner;

public class Main_스타트와링크 {
	static int min = 999999;
	static int [] link;
	static int N ;

	static int[][] arr;

	public static void dfs(int i, int idx, int [] num, int [] start, boolean check[]) {	
		start[idx] = num[i];
		check[i] = true;
		if(idx+1 >= N/2) {
			int cnt=0;

			link = new int[10];
			for(int j=0;j<N;j++) {
				if(!check[j]) {
					link[cnt] = j+1;
					cnt++;
				}
			}

			int startSum=0;
			int linkSum=0;


			for(int j=0;j<N/2-1;j++) {
				for(int k=j+1;k<N/2;k++) {
					startSum += arr[start[j]-1][start[k]-1];
					startSum += arr[start[k]-1][start[j]-1];
					linkSum += arr[link[j]-1][link[k]-1];
					linkSum += arr[link[k]-1][link[j]-1];
				}
			}
			if(startSum>linkSum) {
				if(min>startSum-linkSum) 
					min = startSum-linkSum;
			}else {
				if(min>linkSum-startSum)
					min = linkSum-startSum;
			}

		}else {
			for(int k=i+1;k<N;k++) {
				dfs(k,idx+1, num, start, check);
				check[k] = false;
			}
		}
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[20][20];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int [] start = new int[10];
		int [] num = new int[20];

		for(int i=0;i<N;i++) {
			num[i] = i+1;
		}

		boolean check[] = new boolean[20];
		dfs(0,0, num, start, check);	

		System.out.println(min);
	}
}