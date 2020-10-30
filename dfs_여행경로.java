package Programmers;
import java.util.ArrayList;
import java.util.Collections;
public class dfs_여행경로 {
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void dfs(String start, int cnt, String answer, boolean []used, String[][] tickets) {  
		if(tickets.length == cnt) {
			list.add(answer);
			return;
		}
		else {
			for(int i = 0; i < tickets.length; i++) {
				if(tickets[i][0].equals(start) && !used[i]) {
					used[i] = true;
					dfs(tickets[i][1], cnt+1, answer+","+tickets[i][1], used, tickets);
					used[i] = false;
				}
			}
		}

	}


	public static String[] solution(String[][] tickets) {
		String[] answer = {};
		boolean []used = new boolean[tickets.length];

		dfs("ICN", 0, "ICN", used, tickets);
		Collections.sort(list);
		answer = list.get(0).split(",");
		

		for(String str : answer)
			System.out.print(str+" ");

		return answer;
	}

	public static void main(String[] args) {
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//	[ICN, JFK, HND, IAD] 이어진거 - 알파벳순, 모든 도시 방문, ICN에서 출발
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		
		solution(tickets);
	}

}
