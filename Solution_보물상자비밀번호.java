package swExpert;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution_보물상자비밀번호	
{
	static Queue<String> q;
	static int cnt = 0;
	static int intArr[];

	public static void addPassword(String[] strArr, int N) {
		String tmp;
		for(int i=0;i<4;i++) {
			strArr[i] = "";
			for(int j=0;j<N/4;j++) {
				tmp = q.poll();
				strArr[i] += tmp;
				q.offer(tmp);
			}
			dup(Integer.parseInt(strArr[i], 16));
		}
	}
	public static void dup(int n) {
		for(int i=0;i<cnt;i++) {
			if(intArr[i] == n) {
				return;
			}
		}
		intArr[cnt] = n;
		cnt++;
	}
	public static void max() {
		int tmp = 0;
		for(int i=0;i<intArr.length-1;i++) {
			for(int j=1;j<intArr.length;j++) {
				if(intArr[i] < intArr[j]) {
					tmp = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = tmp;
				}
			}
		}
	}
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		int N, K;

		String str = new String();
		char[] charArr ;
		String[] strArr;

		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			str = sc.next();			
			charArr = str.toCharArray();

			intArr = new int[N];
			q = new LinkedList<String>();

			for(int i=0;i<charArr.length;i++) {
				q.offer(Character.toString(charArr[i]));
			}		
			strArr = new String[4];
			String tmp;
			for(int i=0;i<N/4;i++) {
				addPassword(strArr, N);
				tmp = q.poll();
				q.offer(tmp);
			}		
			Arrays.sort(intArr);
			System.out.println("#"+test_case+" "+ intArr[N-K]);
			cnt = 0;
		}
	}
}