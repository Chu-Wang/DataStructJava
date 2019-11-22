package hashtab;

import java.util.Scanner;

/**
 * @author WangMingMing
 * @creat 2019-11-22 11:15
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建一个hashTab
        HashTab hashtab = new HashTab(7);
        //写一个菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");
            System.out.println("find: 查找雇员");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashtab.add(emp);
                    break;
                case "list":
                    hashtab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashtab.findEmpByNo(id);
                    break;
                default:
                    break;
            }
        }
    }
}

/**
 * 创建hashTab,用来管理多条链表
 */
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    //构造器
    public HashTab(int size){
        this.size = size;
        //初始化链表个数
        empLinkedListArray = new EmpLinkedList[size];
        //?此处有坑
        //这时很重要，分别初始化每一个链表
        for(int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的id得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将雇员加入到对应的雇员链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //编写一个散列函数,使用一个简单的取模法
    public int hashFun(int id){
        return id % size;
    }

    //list方法，查看所有的信息，遍历所有的链表
    public void list(){
        for(int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入发id查找雇员
    public void findEmpByNo(int id){
        //使用散列，判断在哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){
            System.out.printf("在第%d条链表找到了 雇员id = %d\n", empLinkedListNo, id);
        }else{
            System.out.println("在哈希表中没找到该雇员");
        }
    }


}

/**
 * 雇员
 */
class Emp{
    public int id;
    public String name;
    public Emp next;//默认为空
    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}

/**
 * 创建一个雇员链表
 * 该链表有添加、显示方法
 */
class EmpLinkedList{
    private Emp head;//头指针，指向第一个Emp，因此没有头结点,默认为空
    //添加员工,假定添加雇员的时候加在最后
    //假定id自增长
    public void add(Emp emp){
        //如果是添加第一个雇员
        if(head == null){
            head = emp;
            return;
        }
        //不是第一个雇员
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时加在最后
        curEmp.next = emp;
    }

    //遍历链表
    public void list(int no){
        if(head == null){
            System.out.println("第" + no + "链表为空");
            return;
        }
        System.out.println("第" + no + "链表信息为");
        Emp curEmp = head;
        while(true){
            System.out.printf("=> id = %d name = %s\n",curEmp.id, curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //根据id查找雇员,如果找到，返回Emp,没找到返回-1
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }
            //退出条件
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            //如果没找到，往后移
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
