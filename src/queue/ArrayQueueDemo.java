package queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
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

class ArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}
	
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("�����������ܼ�������");
			return ;
		}
		rear++;
		arr[rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		front++;
		return arr[front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return ;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("�����ǿյģ�û������");
		}
		return arr[front + 1];
	}
	
}
























