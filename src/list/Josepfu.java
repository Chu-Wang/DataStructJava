package list;

public class Josepfu {

	public static void main(String[] args) {
		//测试一遍
		CircleLinkedList circleLinkedList = new CircleLinkedList();
		circleLinkedList.addBoy(5);
		circleLinkedList.showBoy();

		//测试小孩出圈
		circleLinkedList.countBoy(1, 2, 5);
		circleLinkedList.showBoy();
		System.out.println("dfghddd");
	}


}

class CircleLinkedList{
	private Boy firstBoy = null;
	public void addBoy(int nums) {//加几个小孩
		if(nums <= 0) {
			System.out.println("nums的值不正确");
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
			System.out.println("链表为空");
			return ;
		}
		Boy curBoy = firstBoy;
		while(true) {
			System.out.printf("小孩的编号是：%d\n",curBoy.getNo());
			if(curBoy.getNextBoy() == firstBoy) {
				break;
			}
			curBoy = curBoy.getNextBoy();
		}
	}
	
	//出圈，根据用户的输入，计算出出圈的顺序
	/**
	 * 
	 * @param startNo : 表示从第几个小孩开始数
	 * @param countNum : 表示数几下
	 * @param nums : 表示最初有多少个小孩
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if(firstBoy == null || startNo < 1 || startNo > nums) {
			System.out.println("参数有误");
			return ;
		}
		Boy helperBoy = firstBoy;
		while(true) {
			if(helperBoy.getNextBoy() == firstBoy) {
				break;
			}
			helperBoy = helperBoy.getNextBoy();
		}
		//小孩开始报数前，先让first和helper移动k - 1次
		for(int j = 0; j < startNo - 1; j++) {
			firstBoy = firstBoy.getNextBoy();
			helperBoy = helperBoy.getNextBoy();
		}
		while(true) {
			if(helperBoy == firstBoy) {
				break;
			}
			//让first和helper同时移动countNum - 1次,然后出圈
			for(int j = 0; j < countNum - 1; j++) {
				firstBoy = firstBoy.getNextBoy();
				helperBoy = helperBoy.getNextBoy();
			}
			//这时，first指的就是出圈的小孩
			System.out.printf("小孩%d出圈\n",firstBoy.getNo());
			
			firstBoy = firstBoy.getNextBoy();
			helperBoy.setNextBoy(firstBoy);
		}
		System.out.printf("最后留在圈中的小孩编号：%d\n",firstBoy.getNo());
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
 * 新添加一行，用来测试github是否正常
 * 计网实验、组原实验杀我
 * 课程作业太多，没有时间，很苦恼。
 *
 */

