package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완전탐색_소수찾기 {
	public static void main(String[] args) {
		String numbers  = "011"; 
		
		System.out.println(solution(numbers));
	}
	
	static Map<String, Integer> hm = new HashMap<String, Integer>();
	
	public static int solution(String numbers) {
		char[] arr = numbers.toCharArray();
		boolean used[] = new boolean[arr.length]; //숫자 사용했는지 여부
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '0') continue; //0으로 시작하는 숫자 제외
			used[i] = true;
			dfs(arr, 0, String.valueOf(arr[i]), used);
			used[i] = false;
		}
		return hm.size();
	}
	
	public static void dfs(char[] arr, int cnt, String num, boolean used[]) {
		if(check(Integer.parseInt(num)) && !hm.containsKey(num)) hm.put(num, 0); //소수인지 아닌지 판별해서 맵에 넣어줌
		
		for(int i = 0; i < arr.length; i++) {
			if(!used[i]) {
				used[i] = true;
				dfs(arr, cnt+1, num+arr[i], used);//사용 안한 숫자 하나씩 더해보면서 dfs 진행
				used[i] = false;
			}
		}
	}
	
	public static boolean check(int num) {
		if(num <= 1) return false;
		for(int i = 2; i < num; i++) 
			if(num%i == 0) return false;
		return true;		
	}
}
