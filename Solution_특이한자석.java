package swExpert;

import java.util.LinkedList;
import java.util.Scanner;

class Solution_특이한자석
{
	static LinkedList magnetArr[] ;

	public static void rotate(int magnetic, int direction) {
		

		//System.out.println(" magnetic, int direction:::"+ magnetic + " " + direction);
		if(direction==1) {
			Object temp = magnetArr[magnetic].pollLast();
			magnetArr[magnetic].offerFirst(temp);
		}else if (direction==-1) {
			Object temp = magnetArr[magnetic].pollFirst();
			magnetArr[magnetic].offerLast(temp);
		}
	}

	public static void sol(int magnetic, int direction) {
		boolean rotate[] = new boolean[4];
		//움직여야하는 톱니 확인
		//1번 톱니 확인
		switch(magnetic) {
		case 1:
			rotate[0] = true;
			if(magnetArr[0].get(2)!=magnetArr[1].get(6)) {//2번톱니비교
				rotate[1] = true;
				if(magnetArr[1].get(2)!=magnetArr[2].get(6)) {//3번톱니비교
					rotate[2] = true;
					if(magnetArr[2].get(2)!=magnetArr[3].get(6)) {//4번톱니비교
						rotate[3] = true;						
					}
				}
			}
			break;
		case 2:		
			rotate[1] = true;

			if(magnetArr[0].get(2)!=magnetArr[1].get(6)) {//1번톱니비교
				rotate[0] = true;						
			}
			if(magnetArr[1].get(2)!=magnetArr[2].get(6)) {//3번톱니비교
				rotate[2] = true;
				if(magnetArr[2].get(2)!=magnetArr[3].get(6)) {//4번톱니비교
					rotate[3] = true;						
				}
			}
			break;
		case 3:
			rotate[2] = true;

			if(magnetArr[1].get(2)!=magnetArr[2].get(6)) {//2번톱니비교
				rotate[1] = true;		
				if(magnetArr[0].get(2)!=magnetArr[1].get(6)) {//1번톱니비교
					rotate[0] = true;						
				}
			}
			if(magnetArr[2].get(2)!=magnetArr[3].get(6)) {//4번톱니비교
				rotate[3] = true;						
			}
			break;
		case 4:
			rotate[3] = true;

			if(magnetArr[2].get(2)!=magnetArr[3].get(6)) {//3번톱니비교
				rotate[2] = true;		
				if(magnetArr[1].get(2)!=magnetArr[2].get(6)) {//2번톱니비교
					rotate[1] = true;		
					if(magnetArr[0].get(2)!=magnetArr[1].get(6)) {//1번톱니비교
						rotate[0] = true;						
					}
				}
			}
			break;
		}
		switch(magnetic) {
		case 1:
			if(rotate[0]) rotate(0,direction);
			if(rotate[1]) rotate(1,direction*-1);
			if(rotate[2]) rotate(2,direction);
			if(rotate[3]) rotate(3,direction*-1);
			break;
		case 2:
			if(rotate[0]) rotate(0,direction*-1);
			if(rotate[1]) rotate(1,direction);
			if(rotate[2]) rotate(2,direction*-1);
			if(rotate[3]) rotate(3,direction);
			break;
		case 3:
			if(rotate[0]) rotate(0,direction);
			if(rotate[1]) rotate(1,direction*-1);
			if(rotate[2]) rotate(2,direction);
			if(rotate[3]) rotate(3,direction*-1);
			break;
		case 4:
			if(rotate[0]) rotate(0,direction*-1);
			if(rotate[1]) rotate(1,direction);
			if(rotate[2]) rotate(2,direction*-1);
			if(rotate[3]) rotate(3,direction);
			break;
		}	

	}

	public static void main(String args[]) throws Exception
	{
		//Scanner sc = new Scanner(System.in);

		

		//System.setIn(new FileInputStream("src/sample_input.txt"));


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			magnetArr = new LinkedList[4];
			
			int K = sc.nextInt();
			
			for(int i=0;i<4;i++) {
				magnetArr[i] = new LinkedList();
				for(int j=0;j<8;j++) {
					magnetArr[i].offerLast(sc.nextInt());
				}

			}


			int opMagnetic;
			int opDirection;


			for(int i=0;i<K;i++) {
				opMagnetic = sc.nextInt();
				opDirection = sc.nextInt();
				sol(opMagnetic,opDirection);
			}

			//print();
			Object num = 1;
			int score = 0;
			if(magnetArr[0].get(0) == num) score +=1;
			if(magnetArr[1].get(0) == num) score +=2;
			if(magnetArr[2].get(0) == num) score +=4;
			if(magnetArr[3].get(0) == num) score +=8;
			System.out.println("#"+test_case+" "+score);
		}
	}
}