package swExpert;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_���弱�� {
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			
			String arr[] = new String[n];
			
			sc.nextLine();

			int max = 0;
			int result = 0;
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextLine();
			}
			
			Arrays.sort(arr);
			
			for(int i=0;i<n;i++) {
				char []charArr = arr[i].toCharArray();
				
				Arrays.sort(charArr);
				char before = ' ';
				int cnt = 0;
				for(int j=0;j<charArr.length;j++) {
					if(charArr[j] != ' ' && before != charArr[j]) {//������ �ƴϸ鼭 �տ� ���ڿ� �޶����� ī��Ʈ
						cnt++;
						before = charArr[j];
					}
				}
				if(cnt>max) {
					max = cnt;
					result = i;
				}
			}
			
			System.out.println("#"+test_case+" "+arr[result]);
		}
	}
}
