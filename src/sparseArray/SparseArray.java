package sparseArray;

public class SparseArray {

	public static void main(String[] args) {
		//创建一个原始的二维数组，11*11
		//0：没有棋子 
		//1：黑色棋子
		//2：蓝色棋子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		//输出原始的二维数组
		for(int [] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
		
		//将二维数组转为稀疏数组
		//先遍历 找到非零的个数
		int sum = 0;
		for(int i = 0; i < chessArr1.length; i++) {
			for(int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		//创建对应的稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		//给稀疏数组赋值
		sparseArr[0][0] = chessArr1.length;
		sparseArr[0][1] = chessArr1[0].length;
		sparseArr[0][2] = sum;
		//再次遍历数组
		int count = 0;//记录是第几个非零数据
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
		//输出稀疏数组的形式
		System.out.println();
		System.out.println("得到的稀疏数组为");
		for(int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t",sparseArr[i][0], sparseArr[i][1],sparseArr[i][2]);
			System.out.println();
		}
		
		//将稀疏数组恢复
		//先读取第一行得到二维数组
		int chessArr2[][] = new int [sparseArr[0][0]][sparseArr[0][1]];
		for(int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		//恢复后的二维数组
		System.out.println("恢复后二维数组：");
		for(int [] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
		
	}

}









