package list;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		/*
		 * singleLinkedList.add(hero1); singleLinkedList.add(hero2);
		 * singleLinkedList.add(hero3); singleLinkedList.add(hero4);
		 */
		 
		
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.list();
		HeroNode newHeroNode = new HeroNode(2, "С¹", "С����");
		singleLinkedList.update(newHeroNode);
		System.out.println("�޸�֮�������");
		singleLinkedList.list();
		singleLinkedList.del(1);
		System.out.println("ɾ��1��");
		singleLinkedList.list();
		//singleLinkedList.del(4);
		//System.out.println(getLength((singleLinkedList.getHead())));
		//HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
		//System.out.println(res);
		reverseList(singleLinkedList.getHead());
		singleLinkedList.list();
		reversePrint(singleLinkedList.getHead());
		
	}
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return ;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode curHeroNode = head.next;
		while(curHeroNode != null) {
			stack.push(curHeroNode);
			curHeroNode = curHeroNode.next;
		}
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
		
	}
	public static void reverseList(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			return ;
		}
		HeroNode curHeroNode = head.next;
		HeroNode nextHeroNode = null;
		HeroNode reverHead = new HeroNode(0, "", "");
		while(curHeroNode != null) {
			nextHeroNode = curHeroNode.next;
			curHeroNode.next = reverHead.next;
			reverHead.next = curHeroNode;
			curHeroNode = nextHeroNode;
		}
		head.next = reverHead.next;
	}
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if(index <= 0 || index > size) {
			return null;
		}
		HeroNode cur = head.next;
		
		for(int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	//�õ�������Ŀ
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}

}


//����linkedlist
class SingleLinkedList{
	private HeroNode head = new HeroNode(0, "", "");
	public HeroNode getHead() {
		return head;
	}
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.next = null;
	}
	
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.printf("�������Ӣ�۱��%d�Ѵ���\n",heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	public void list() {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
	
	public void update(HeroNode newHeroNode) {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickName = newHeroNode.nickName;
		}else {
			System.out.printf("û���ҵ��������޸ı��%d��Ӣ��\n",newHeroNode.no);
		}
	}
	
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("û�ҵ�");
		}
	}
}



class HeroNode{
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;
	public HeroNode(int hNo, String hName, String hNickName) {
		this.no = hNo;
		this.name = hName;
		this.nickName = hNickName;
	}
	//��дtoString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName +  "]";
	}
}