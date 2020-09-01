package programmers;

import java.util.Arrays;

public class 정렬_K번째수 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int [] answer = new int[commands.length];
		
		for(int i = 0; i < commands.length; i++) {
			int [] arr = new int[commands[i][1] - commands[i][0] + 1];//자른 배열 넣을 배열
			
			int idx = 0;
			for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				arr[idx] = array[j];//자르는 부분 배열 넣기
				idx ++;
			}
			
			Arrays.sort(arr);//자른 배열 정렬
			//arr = sort(arr);
			
			answer[i] = arr[commands[i][2] - 1];
		}

//		for(int i = 0; i < answer.length; i++) {
//			System.out.println(answer[i]);
//		}
		
		return answer;
	}
	
	public static int [] sort (int [] arr) {
		int temp;
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
}
/*
 * class Solution {
        public static int[] sortArr(int []array){
    	for(int i= 0; i<array.length-1;i++) {
    		for(int j = i+1; j<array.length;j++) {
    			if(array[i]>array[j]) {
    				int tmp = array[j];
    				array[j] = array[i];
    				array[i] = tmp;
    			}
    		} 
    	}
    	return array;
    }

    public static int[] splitArr(int []array, int []commands){
        int len = commands[1] - commands[0] + 1;
        int[] arr = {};

        arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = array[commands[0]-1+ i];
        }
        array = sortArr(arr);
    	return array;
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
           answer[i] = splitArr(array, commands[i])[commands[i][2]-1]; 

        }

        return answer;
    }
}
 */