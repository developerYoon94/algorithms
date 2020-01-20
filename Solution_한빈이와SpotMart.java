package swExpert;

import java.util.Scanner;

class Solution_ÇÑºóÀÌ¿ÍSpotMart
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int W[] = new int[N];
			int P = 0;
			for(int i=0;i<N;i++) {
				W[i] = sc.nextInt();
			}
			
			boolean check[] = new boolean[N];
			int max = -1;
			for(int i=0;i<N;i++) {
				check[i] = true;
				P += W[i];
				for(int j= 0;j<N;j++) {
					if(!check[j]) {
						P += W[j];
						if(M>P && max<P) max = P;
						else if(M==P) {
							max = P;
							break;
						}
						P -= W[j];
					}
				}
				if(M==max) {
					break;
				}
				P = 0;
				check[i] = false;
			}
			System.out.println("#"+test_case+" "+max);

		}
	}
}