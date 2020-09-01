package programmers;

public class 완전탐색_카펫 {
	public static void main(String[] args) {
		
		for(int a : solution(10, 2)) {
			System.out.println(a);
		}

	}

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i < 10000; i++) {
        	for(int j = 1; j < 10000; j++) {
            	if(check(i, j, brown, yellow)) {
            		answer[0] = i > j ? i+2 : j+2;
            		answer[1] = i > j ? j+2 : i+2;
            		return answer;
            	}
            }
        }
        
        
        return answer;
    }
    
    public static boolean check(int x, int y, int brown, int yellow) {
		System.out.println("x:"+x+" y:"+y);
    	if(x*y != yellow) 
    		return false;

    	if(2*(x+y) + 4 != brown )
    		return false;
    	
    	return true;
    }
}
