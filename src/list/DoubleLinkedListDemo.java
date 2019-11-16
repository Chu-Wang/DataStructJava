package list;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		//����
		System.out.println("˫������Ĳ���");
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		doubleLinkedList.list();
		
		HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
		doubleLinkedList.update(newHeroNode);
		System.out.println("�޸ĺ��˫������");
		doubleLinkedList.list();
		
		doubleLinkedList.del(3);
		System.out.println("ɾ����");
		doubleLinkedList.list();
		System.out.println("ͨ��˳���Ž������");
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.list();
		
	}

}

class DoubleLinkedList{
	private HeroNode2 head = new HeroNode2(0, "", "");
	public HeroNode2 getHead() {
		return head;
	}
	public void list() {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		HeroNode2 temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
	
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
		heroNode.preHeroNode2 = temp;
	}
	public void update(HeroNode2 newHeroNode) {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return ;
		}
		HeroNode2 temp = head.next;
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
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.preHeroNode2.next = temp.next;
			//�����з��գ�����Ҫɾ���Ľ�������Ľ�㣬����Ļ���������
			//������仰�и���������������һ����㣬�Ͳ���Ҫִ��������仰�����򱨿�ָ���쳣
			if(temp.next != null) {
				temp.next.preHeroNode2 = temp.preHeroNode2;
			}
		}else {
			System.out.println("û�ҵ�");
		}
	}
	
	public void addByOrder(HeroNode2 heroNode) {
		HeroNode2 temp = head;
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
			temp.next.preHeroNode2 = heroNode;
			heroNode.preHeroNode2 = temp;
			temp.next = heroNode;
		}
		
	}
	
}

class HeroNode2{
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next;
	public HeroNode2 preHeroNode2;
	public HeroNode2(int hNo, String hName, String hNickName) {
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

