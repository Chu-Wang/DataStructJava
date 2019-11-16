package list;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		//测试
		System.out.println("双向链表的测试");
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		doubleLinkedList.add(hero4);
		doubleLinkedList.list();
		
		HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
		doubleLinkedList.update(newHeroNode);
		System.out.println("修改后的双向链表");
		doubleLinkedList.list();
		
		doubleLinkedList.del(3);
		System.out.println("删除后");
		doubleLinkedList.list();
		System.out.println("通过顺序编号进行添加");
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
			System.out.println("链表为空");
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
			System.out.println("链表为空");
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
			System.out.printf("没有找到，不能修改编号%d的英雄\n",newHeroNode.no);
		}
	}
	
	public void del(int no) {
		if(head.next == null) {
			System.out.println("链表为空");
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
			//代码有风险，假如要删除的结点是最后的结点，下面的话就有问题
			//下面这句话有个条件，如果是最后一个结点，就不需要执行下面这句话，否则报空指针异常
			if(temp.next != null) {
				temp.next.preHeroNode2 = temp.preHeroNode2;
			}
		}else {
			System.out.println("没找到");
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
			System.out.printf("待插入的英雄编号%d已存在\n",heroNode.no);
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
	//重写toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName +  "]";
	}
}

