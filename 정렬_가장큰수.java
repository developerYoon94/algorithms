package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 정렬_가장큰수 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] numbers = {3, 30, 34, 5, 9};

		String result = solution(numbers);
		System.out.println(result);
	}

	public static String solution(int[] numbers) {
		String answer= "";

		answer = sort(numbers);

		return answer;
	}


	public static String sort(int[] numbers){
		String answer= "";
		String []strNumbers = new String[numbers.length];

		for(int i= 0; i<numbers.length;i++) {
			strNumbers[i] = Integer.toString(numbers[i]);
		}

		//Arrays.sort(strNumbers, (o1,o2)->(o2+o1).compareTo(o1+o2));
	   Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
	
		
		
		if(strNumbers[0].equals("0")) {
			return "0";
		}

		for(int i= 0; i<numbers.length;i++) {
			answer +=  strNumbers[i];
		}
		return answer;
	}
	/*

	public static int [] sort(int [] arr) {
		int temp;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i; j < arr.length; j++) {
				int tempResult1 = Integer.parseInt(String.valueOf(arr[i]) + String.valueOf(arr[j]) );
				int tempResult2 = Integer.parseInt(String.valueOf(arr[j]) + String.valueOf(arr[i]) );
				if(tempResult1 < tempResult2) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}*/
}