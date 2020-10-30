package Programmers;

public class dfs_네트워크 {

	static int tmpAnswer = 0;
	static boolean visit[][];

	public static void dfs(int node, int[][] link, int n){
		for(int i=0;i<n; i++){
			if(link[node][i] == 1 && !visit[node][i]){
				visit[node][i] = true;
				if(node == i) { 
					tmpAnswer++;
					System.out.println("1node, i : "+ node+"," + i);
				}
				else {
					System.out.println("1node, i : "+ node+"," + i); 
					visit[i][i] = true;
					System.out.println("1node, i : "+ node+"," + i); 
					dfs(i, link, n);
				}
			}	
		}       
	}
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visit = new boolean[n][n];

		for(int i = 0; i< n; i++) {

			dfs(i, computers, n);

		}

		answer = tmpAnswer;

		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		System.out.println(solution(n, computers));
	}

}
