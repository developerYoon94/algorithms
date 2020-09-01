package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 정렬_H인덱스 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] citations = {3, 3, 6, 1, 5};

		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);

		int max = citations[citations.length-1];
		
		//h, h번 이상인것의 수
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int tot = 1;
		
		for(int i = citations.length-1; i >= 0; i--) {
			if(hm.containsKey(citations[i])) {
				hm.replace(citations[i], hm.get(citations[i])+1);
				tot++;
			}
			else {
				hm.put(citations[i], tot++);
				
			}
			
		}
		for(int i = citations.length-1; i >= 0; i--) {
			//논문별 h번 이상 인용된 논문이 몇편인지
			System.out.println(citations[i] + " / " + hm.get(citations[i]));
		}
		
		int n = 0;
		for(int i = max; i >= 0; i--) {
			//몇편이나 인용됐는지 확인하며 조건 확인
			if(hm.containsKey(i)) {
				n = hm.get(i);
				//h번 이상 기록 && 남은 개수가 h번 이하
				if(hm.get(i) >= i && citations.length - hm.get(i) <= i)
					return i;
			}
			//얼마나 인용된지 기록된게 없으면 그전에 기록된게 h번 이상 인용된 편수
			else {
				if(n >= i && citations.length - n <= i)
					return i;
			}
		}

		for(int i = citations.length-1; i >= 0; i--) {
			System.out.println(citations[i] + " / " + hm.get(citations[i]));
		}
		return answer;
	}
}