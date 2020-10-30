package Programmers;

public class dfs_Å¸°Ù³Ñ¹ö {
	
	static int answer=0;

	public static void dfs(int[] numbers, int idx, int sign, int target, int sum){
		sum += numbers[idx]*sign;

		if(idx == numbers.length-1) {
			if(sum == target)
				answer++; 			 
			return;
		}
		
		dfs(numbers, idx+1, 1, target, sum);
		dfs(numbers, idx+1, -1, target, sum);     
	}

	public static int solution(int[] numbers, int target) {
		dfs(numbers, 0, 1, target, 0);
		dfs(numbers, 0, -1, target, 0);

		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}

}
