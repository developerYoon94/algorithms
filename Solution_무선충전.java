package swExpert;

import java.util.Scanner;

class USER{
	int X;
	int Y;
	int []BC;

	public USER(int xx, int yy, int a) {
		// TODO Auto-generated constructor stub
		X = xx;
		Y = yy;
		BC = new int[a];
		for(int i=0;i<a;i++) {
			BC[i] = 0;
		}
	}
	public void initBC(int a) {
		for(int i=0;i<a;i++) {
			BC[i] = 0;
		}

	}

	public void location(int a) {
		if(a==1) {
			X--;
		}else if(a==2) {
			Y++;
		}else if(a==3) {
			X++;
		}else if(a==4) {
			Y--;
		}
	}

}

class AP{
	int X=0;
	int Y=0;
	int C=0;
	int P=0;
	int [][] map = new int[11][11];

	public void AP() {
		X=0;
		Y=0;
		C=0;
		P=0;
		for(int i=0;i<11;i++) {
			for(int j=0;j<11;j++) {
				map[i][j] = 0;
			}
		}

	}

}
class Solution_��������
{
	static int[] used;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{



			int M=sc.nextInt();
			int A= sc.nextInt();
			int []userA_move = new int[M];
			int []userB_move = new int[M];


			for(int i =0;i<M;i++) {
				userA_move[i] = sc.nextInt();
			}
			for(int i =0;i<M;i++) {
				userB_move[i] = sc.nextInt();
			}

			AP ap[] = new AP[A];
			for(int i=0;i<A;i++) {
				ap[i] = new AP();
				ap[i].Y = sc.nextInt();
				ap[i].X = sc.nextInt();
				ap[i].C = sc.nextInt();
				ap[i].P = sc.nextInt();
			}

			//AP�� �� �������
			mapDraw(ap, A);

			USER userA = new USER(1,1,A);
			USER userB = new USER(10,10,A);
			int result = 0;
			//�����  A, B �� �ʰ� ���������� �����̸鼭 üũ��
			for(int i=0;i<=M;i++) {
				//��������� BC �ִ°� �� �־���
				int cntA =0, cntB=0;
				used = new int[A];

				for(int j=0;j<A;j++) {
					if(ap[j].map[userA.X][userA.Y] > 0) {
						userA.BC[j] = ap[j].map[userA.X][userA.Y];
						cntA++;
					}
					if(ap[j].map[userB.X][userB.Y] > 0) {
						userB.BC[j] = ap[j].map[userB.X][userB.Y];
						cntB++;
					}
				}
				int tempA = 0;				
				int tempB = 0;
				for(int j=0;j<A;j++) {
					used[j] = 0;
				}
				//A���� ���Ҷ�
				tempA += max(userA.BC);
				tempA += max(userB.BC);
				for(int j=0;j<A;j++) {
					used[j] = 0;
				}
				//B���� ���Ҷ� 
				tempB += max(userB.BC);
				tempB += max(userA.BC);

				if(tempA >= tempB) {
					result += tempA;
				}else {
					result += tempB;					
				}
				userA.initBC(A);
				userB.initBC(A);

				//System.out.println("result "+i+" "+result);
				if(i<M) {
					userA.location(userA_move[i]);
					userB.location(userB_move[i]);
				}
			}

			System.out.println("#"+test_case+" "+result);

		}
	}

	public static int max(int arr[]) {
		int max = 0;//�� ���������� �ֻ��� �� ����
		int idx = 0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i] && used[i] != 1) {
				max = arr[i];
				idx = i;
			}
		}
		used[idx] = 1;

		return max;
	}
	public static void mapDraw(AP ap[], int A) {
		//�߾ӻ�ĥ
		for(int bc=0;bc<A;bc++) {
			ap[bc].map[ap[bc].X][ap[bc].Y] = ap[bc].P; 
			for(int i=1;i<=ap[bc].C;i++) {
				//���� ��ĥ
				if(ap[bc].Y-i >= 1)
					ap[bc].map[ap[bc].X][ap[bc].Y-i] = ap[bc].P; 
				//������ ��ĥ
				if(ap[bc].Y+i <= 10)
					ap[bc].map[ap[bc].X][ap[bc].Y+i] = ap[bc].P; 
				//�� ��ĥ
				if(ap[bc].X-i >= 0) {
					ap[bc].map[ap[bc].X-i][ap[bc].Y] = ap[bc].P; 
					for(int j=1;j<ap[bc].C-i+1;j++) {
						//���� ��ĥ
						if(ap[bc].Y-j >= 1)
							ap[bc].map[ap[bc].X-i][ap[bc].Y-j] = ap[bc].P; 
						//������ ��ĥ
						if(ap[bc].Y+j <= 10)
							ap[bc].map[ap[bc].X-i][ap[bc].Y+j] = ap[bc].P; 
					}
				}
				//�Ʒ���ĥ
				if(ap[bc].X+i <= 10) {
					ap[bc].map[ap[bc].X+i][ap[bc].Y] = ap[bc].P; 
					for(int j=1;j<ap[bc].C-i+1;j++) {
						//���� ��ĥ
						if(ap[bc].Y-j >= 1)
							ap[bc].map[ap[bc].X+i][ap[bc].Y-j] = ap[bc].P; 
						//������ ��ĥ
						if(ap[bc].Y+j <= 10)
							ap[bc].map[ap[bc].X+i][ap[bc].Y+j] = ap[bc].P; 
					}
				}
			}

		}
	}
}