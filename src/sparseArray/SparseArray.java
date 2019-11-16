package sparseArray;

public class SparseArray {

	public static void main(String[] args) {
		//����һ��ԭʼ�Ķ�ά���飬11*11
		//0��û������ 
		//1����ɫ����
		//2����ɫ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		//���ԭʼ�Ķ�ά����
		for(int [] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
		
		//����ά����תΪϡ������
		//�ȱ��� �ҵ�����ĸ���
		int sum = 0;
		for(int i = 0; i < chessArr1.length; i++) {
			for(int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		//������Ӧ��ϡ������
		int sparseArr[][] = new int[sum + 1][3];
		//��ϡ�����鸳ֵ
		sparseArr[0][0] = chessArr1.length;
		sparseArr[0][1] = chessArr1[0].length;
		sparseArr[0][2] = sum;
		//�ٴα�������
		int count = 0;//��¼�ǵڼ�����������
		for(int i = 0; i < chessArr1.length; i++) {
			for(int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		//���ϡ���������ʽ
		System.out.println();
		System.out.println("�õ���ϡ������Ϊ");
		for(int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t",sparseArr[i][0], sparseArr[i][1],sparseArr[i][2]);
			System.out.println();
		}
		
		//��ϡ������ָ�
		//�ȶ�ȡ��һ�еõ���ά����
		int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];
		for(int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		//�ָ���Ķ�ά����
		System.out.println("�ָ����ά���飺");
		for(int [] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
		
	}

}









