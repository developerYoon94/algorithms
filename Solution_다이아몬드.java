package swExpert;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_다이아몬드 {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int K = sc.nextInt();

			int arr[] = new int[N];

			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}

			arr = sort(arr);

			Queue<Integer> q = new LinkedList<Integer>();

			int max = 0;
			int count = 0;
			int i = 0;

			while(i<N) {
				if(q.isEmpty()) {
					q.add(arr[i]);
					count++;
					i++;
				}else if(arr[i]-q.peek() <= K) {
					q.add(arr[i]);
					count++;
					i++;
				}else {
					q.poll();
					count--;
				}

				if(max<count) max = count;
			}



			System.out.println("#"+test_case+" "+max);
		}
	}
	
	public static int[] sort (int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;

	}
}
