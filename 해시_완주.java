package programmers;

import java.util.HashMap;

public class 해시_완주 {
	public static String solution(String [] p, String [] c) {
		//<완주자, 명수> 완주자를 해시맵에 넣고 동명이인이 있으면 카운트 +1 해준다. 참가자를 조회하면서 -1 해주다가 완주자 해시맵에 없거나 동명이인인 경우 value가 0 이하가 되면 바로 pop
		//완주자를 해시맵으로 만듦
		//완주자 동명이인 있는 경우 value+1
		//완주자 해시맵에 참가자 목록이 포함? => containsKey()
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		for(int i = 0; i < c.length; i++) {
			//동명이인 있는 경우 value+1
			if(hm.containsKey(c[i])) {
				hm.replace(c[i], hm.get(c[i])+1);
			}
			//처음 넣는 경우
			else{
				hm.put(c[i], 1);
			}
		}
		for(int i = 0; i < p.length; i++) {
			//완주자 해시맵에 없으면
			if(!hm.containsKey(p[i])) {
				return p[i];
			}
			else{
				//동명이인인 경우 -1 
				if(hm.get(p[i]) > 0) {
					hm.replace(p[i], hm.get(p[i])-1);
				}else {
					return p[i];
				}
			}
		}
		return "Failed";
	}
	
	public static void main(String[] args) {
/*
 * 참여 선수 participant[] /  완주 선수 completion[]
 * 완주하지 못한 선수 return
 * 
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
 */
		String [] participant = {"leo", "kiki", "eden"};
		String [] completion = {"kiki", "eden"};

		solution(participant, completion);
	}
}
