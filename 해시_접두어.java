package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class 해시_접두어 {
	
	public static boolean solution(String [] phone_book) {
        boolean answer = true;
		//접두어인 경우 있는지? 없으면 True, 있으면 False
		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i = 0; i < phone_book.length; i++) {
			Iterator it = hm.keySet().iterator();
			
			while(it.hasNext()) {
				String temp = (String) it.next();
				//문자열을 해시맵에 넣어주면서 아래 2가지 경우를 바로바로 체크
				//put 하려는 문자열이 더 긴 경우 {"111", "1234"}(접두어) vs "11155" => {"111", "1234"} vs "111" 
				if(phone_book[i].length() >= temp.length() 
						&& temp.equals(phone_book[i].substring(0, temp.length()))) {
					answer = false;
					break;
				}
				//put 하려는 문자열이 더 짧은 경우 {"111", "1234"} vs "12"(접두어) =>  {"11", "12"} vs "12"
				else if(phone_book[i].length() <= temp.length() 
						&& phone_book[i].equals(temp.substring(0, phone_book[i].length()))) {
					answer = false;
					break;
				}
			}
			if(!answer) break;

			hm.put(phone_book[i], phone_book[i].length());
		}
		
		return answer;
	}
	
	public static void main(String[] args) {		
		String [] phone_book = {"112", "11134", "11"};

		if(solution(phone_book)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}
}
