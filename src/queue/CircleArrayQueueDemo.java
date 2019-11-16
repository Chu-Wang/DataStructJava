package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		System.out.println("���ζ���");
		CircleArray queue = new CircleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show): ��ʾ����");
			System.out.println("e(exit): �˳�");
			System.out.println("a(add) : ���Ԫ��");
			System.out.println("g(get) : ȡ����");
			System.out.println("h(head): ��ʾͷԪ��");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ���������ǣ�%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int value1 = queue.headQueue();
					System.out.printf("ͷԪ���ǣ�%d\n",value1);
				} catch (Exception e) {
					
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("�����˳�");

	}

}

class CircleArray{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return ;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		int res = arr[front];
		front = (front + 1) % maxSize;
		return res;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return ;
		}
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("�����ǿյģ�û������");
		}
		return arr[front];
	}
}












