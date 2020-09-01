package programmers;

public class 완전탐색_모의고사 {
	public static void main(String[] args) {

		int []answers  = {1,3,2,4,5}; 
		int [] result = solution(answers);
		
		for(int a : result) {
			System.out.println(a);
		}
	}
	public static int[] solution(int[] answers) {
		int[] answer = {};

		int []arr1 = {1,2,3,4,5}; 
		int []arr2 = {2,1,2,3,2,4,2,5}; 
		int []arr3 = {3,3,1,1,2,2,4,4,5,5}; 
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		int max = 0;

		for(int i = 0; i < answers.length; i++) {
			if(arr1[i%5] == answers[i]) { 
				cnt1++;
				if(max < cnt1) max = cnt1;
			}
			if(arr2[i%8] == answers[i]) { 
				cnt2++;
				if(max < cnt2) max = cnt2;
			}
			if(arr3[i%10] == answers[i]) { 
				cnt3++;
				if(max < cnt3) max = cnt3;
			}
		}

		if(cnt1>cnt2 && cnt1>cnt3) return new int[]{1};
		if(cnt2>cnt1 && cnt2>cnt3) return new int[]{2};
		if(cnt3>cnt2 && cnt3>cnt1) return new int[]{3};
		if(cnt1==cnt2 && cnt1>cnt3) return new int[]{1, 2};
		if(cnt1>cnt2 && cnt1==cnt3) return new int[]{1, 3};
		if(cnt2==cnt3 && cnt3>cnt1) return new int[]{2, 3};
		if(cnt1==cnt2 && cnt2==cnt3) return new int[]{1, 2, 3};

		return answer;
	}
}
