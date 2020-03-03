package swExpert;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_summation {

	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int []arr = new int[10];
			char []charArr;
			int max = 0;
			int min = 987654321;
			
			for(int i=0;i<10;i++) {
				arr[i] = sc.nextInt();
				int temp = 0;
				
				String str = Integer.toString(arr[i]);
				char[] toChar = str.toCharArray();
				for(int j=0;j<toChar.length;j++) {
					temp += toChar[j] - '0';
				}
				
				if(temp < min) min = temp;
				if(temp > max) max = temp;
			}

			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
}
