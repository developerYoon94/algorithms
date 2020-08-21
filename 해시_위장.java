package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
//경우의 수(조합) A(n)*B(n)*...Z(n)
public class 해시_위장 {
	public static int solution(String [][] clothes) {
        int answer = 0;
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i = 0; i < clothes.length; i++) {
			if(hm.containsKey(clothes[i][1])) {
				//해당 웨어의 개수를 늘림
				hm.replace(clothes[i][1], hm.get(clothes[i][1])+1);
			}else {
				//웨어 종류 추가
				hm.put(clothes[i][1], 1);
			}
		}
		

		Iterator it = hm.keySet().iterator();

		answer = 1;
		
		while(it.hasNext()) {
			String temp = (String) it.next();
			
			//착용 안하는 경우 + 1
			answer *= (hm.get(temp) + 1);
		}
		//아무것도 착용하지 않은 경우 빼기 
		answer -= 1;
		
		return answer;
	}
	
	public static void main(String[] args) {		
		String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

		System.out.println(solution(clothes));
	}
}
