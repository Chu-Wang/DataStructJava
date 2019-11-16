package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		System.out.println("环形队列");
		CircleArray queue = new CircleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出");
			System.out.println("a(add) : 添加元素");
			System.out.println("g(get) : 取数据");
			System.out.println("h(head): 显示头元素");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是：%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int value1 = queue.headQueue();
					System.out.printf("头元素是：%d\n",value1);
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

		System.out.println("程序退出");

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
			System.out.println("队列满，不能加入数据");
			return ;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空，不能取数据");
		}
		int res = arr[front];
		front = (front + 1) % maxSize;
		return res;
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("队列为空，没有数据");
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
			throw new RuntimeException("队列是空的，没有数据");
		}
		return arr[front];
	}
}












