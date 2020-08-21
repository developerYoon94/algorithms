package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;


public class 해시_베스트앨범 {
	public static int[] solution(String [] genres, int [] plays) {
		int[] answer = {};
		//장르별 총 재생횟수 높은 장르 먼저 수록
        //장르 내에서 재생횟수 높은거 수록
        //장르내 횟수 같으면 고유번호 낮은거 먼저
		
		//장르별 고유,재생 - 추후 정렬
		Map<String, Map<String, Integer>> hm = new HashMap<String, Map<String, Integer>>();
		//장르별 총 재생 횟수  - 추후 정렬
		Map<String, Integer> hmTot = new HashMap<String, Integer>();
		//실 재생 목록<고유번호, 재생수>
		Map<String, Integer> hmResult = new HashMap<String, Integer>();
		
		for(int i = 0; i < genres.length; i++) {
			//장르 먼저 넣어줌, 장르 총 재생수 계산
			if(!hm.containsKey(genres[i])) {
				hm.put(genres[i], new HashMap());
				hmTot.put(genres[i], plays[i]);
			}else {
				hmTot.replace(genres[i], hmTot.get(genres[i]) + plays[i]);
			}
		}
		//장르별 고유번호,재생수 입력
		for(int i = 0; i < genres.length; i++) {
			hm.get(genres[i]).put(String.valueOf(i), plays[i]);
		}
		//장르 총 재생수 기준 정렬
		Iterator it = sortByValue(hmTot, false).iterator();
		
		//입력된 순서
		int index = 0;
		
		while(it.hasNext()) {
			String temp = (String) it.next();
			
			int cnt = 0;//수록 수
			int playTime = 0;//재생수
			int num = 10001;//고유번호(10000이하)
			
			//장르 내 재생수 기준 정렬
			Iterator itSub = sortByValue(hm.get(temp), false).iterator();

			while(itSub.hasNext()) {
				String tempSub = (String) itSub.next();
				
				//2개 이하는 바로 수록
				if(cnt<2) {
					playTime = hm.get(temp).get(tempSub);
					num = Integer.parseInt(tempSub);
					
					hmResult.put(tempSub, index);
					index++;
					cnt++;
				}
				//2개 이상
				else {
					//재생 시간이 같은 경우
					if(playTime == hm.get(temp).get(tempSub)) {
						//뒤에 고유번호가 더 작으면 지우고 뒤에거로 넣음
						if(num > Integer.parseInt(tempSub)) {
							num = Integer.parseInt(tempSub);
							hmResult.remove(num);
							index--;
							hmResult.put(tempSub, index);
							index++;
						}
					}
				}				
			}
		}

		answer = new int[hmResult.size()];
		
		Iterator it2 = sortByValue(hmResult, true).iterator();
		int i = 0;
		while(it2.hasNext()) {
			String temp1 = (String) it2.next();
			answer[i] = Integer.parseInt(temp1);
			i++;
		}
		
		return answer;
	}
	//아직도 몬지 몰겠음..
	public static List sortByValue(final Map map, boolean order) {
		List<String> list = new ArrayList();

		list.addAll(map.keySet());

		Collections.sort(list,new Comparator() {
			public int compare(Object o1,Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				return ((Comparable) v2).compareTo(v1);
			}
		});
		
		if(order) Collections.reverse(list); // 주석시 오름차순

		return list;
	}
	
	public static void main(String[] args) {		
		String [] genres = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays = {500, 600, 150, 800, 2500};

		int result[] = solution(genres, plays);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
}
