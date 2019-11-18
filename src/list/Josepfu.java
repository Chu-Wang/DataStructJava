package list;

public class Josepfu {

	public static void main(String[] args) {
		//����һ��
		CircleLinkedList circleLinkedList = new CircleLinkedList();
		circleLinkedList.addBoy(5);
		circleLinkedList.showBoy();

		//����С����Ȧ
		circleLinkedList.countBoy(1, 2, 5);
		circleLinkedList.showBoy();
		System.out.println("dfghddd");
	}


}

class CircleLinkedList{
	private Boy firstBoy = null;
	public void addBoy(int nums) {//�Ӽ���С��
		if(nums <= 0) {
			System.out.println("nums��ֵ����ȷ");
			return ;
		}
		Boy curBoy = null;
		for(int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if(i == 1) {
				firstBoy = boy;
				firstBoy.setNextBoy(firstBoy);
				curBoy = firstBoy;
			}else {
				curBoy.setNextBoy(boy);
				boy.setNextBoy(firstBoy);
				curBoy = boy;
			}
		}
	}
	public void showBoy() {
		if(firstBoy == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		Boy curBoy = firstBoy;
		while(true) {
			System.out.printf("С���ı���ǣ�%d\n",curBoy.getNo());
			if(curBoy.getNextBoy() == firstBoy) {
				break;
			}
			curBoy = curBoy.getNextBoy();
		}
	}
	
	//��Ȧ�������û������룬�������Ȧ��˳��
	/**
	 * 
	 * @param startNo : ��ʾ�ӵڼ���С����ʼ��
	 * @param countNum : ��ʾ������
	 * @param nums : ��ʾ����ж��ٸ�С��
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if(firstBoy == null || startNo < 1 || startNo > nums) {
			System.out.println("��������");
			return ;
		}
		Boy helperBoy = firstBoy;
		while(true) {
			if(helperBoy.getNextBoy() == firstBoy) {
				break;
			}
			helperBoy = helperBoy.getNextBoy();
		}
		//С����ʼ����ǰ������first��helper�ƶ�k - 1��
		for(int j = 0; j < startNo - 1; j++) {
			firstBoy = firstBoy.getNextBoy();
			helperBoy = helperBoy.getNextBoy();
		}
		while(true) {
			if(helperBoy == firstBoy) {
				break;
			}
			//��first��helperͬʱ�ƶ�countNum - 1��,Ȼ���Ȧ
			for(int j = 0; j < countNum - 1; j++) {
				firstBoy = firstBoy.getNextBoy();
				helperBoy = helperBoy.getNextBoy();
			}
			//��ʱ��firstָ�ľ��ǳ�Ȧ��С��
			System.out.printf("С��%d��Ȧ\n",firstBoy.getNo());
			
			firstBoy = firstBoy.getNextBoy();
			helperBoy.setNextBoy(firstBoy);
		}
		System.out.printf("�������Ȧ�е�С����ţ�%d\n",firstBoy.getNo());
	}
	
}

class Boy{
	private int no;
	private Boy nextBoy;
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNextBoy() {
		return nextBoy;
	}
	public void setNextBoy(Boy nextBoy) {
		this.nextBoy = nextBoy;
	}
	
}
/**
 * �����һ�У���������github�Ƿ�����
 * ����ʵ�顢��ԭʵ��ɱ��
 * �γ���ҵ̫�࣬û��ʱ�䣬�ܿ��ա�
 *
 */

