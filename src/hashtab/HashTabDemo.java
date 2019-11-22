package hashtab;

import java.util.Scanner;

/**
 * @author WangMingMing
 * @creat 2019-11-22 11:15
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //����һ��hashTab
        HashTab hashtab = new HashTab(7);
        //дһ���˵�
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: ��ӹ�Ա");
            System.out.println("list: ��ʾ��Ա");
            System.out.println("exit: �˳�ϵͳ");
            System.out.println("find: ���ҹ�Ա");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("����id");
                    int id = scanner.nextInt();
                    System.out.println("��������");
                    String name = scanner.next();
                    //������Ա
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
                    System.out.println("������Ҫ���ҵ�id");
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
 * ����hashTab,���������������
 */
class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    //������
    public HashTab(int size){
        this.size = size;
        //��ʼ���������
        empLinkedListArray = new EmpLinkedList[size];
        //?�˴��п�
        //��ʱ����Ҫ���ֱ��ʼ��ÿһ������
        for(int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    //��ӹ�Ա
    public void add(Emp emp){
        //����Ա����id�õ���Ա��Ӧ����ӵ���������
        int empLinkedListNo = hashFun(emp.id);
        //����Ա���뵽��Ӧ�Ĺ�Ա������
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //��дһ��ɢ�к���,ʹ��һ���򵥵�ȡģ��
    public int hashFun(int id){
        return id % size;
    }

    //list�������鿴���е���Ϣ���������е�����
    public void list(){
        for(int i = 0; i < size; i++){
            empLinkedListArray[i].list(i);
        }
    }

    //�������뷢id���ҹ�Ա
    public void findEmpByNo(int id){
        //ʹ��ɢ�У��ж��������������
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){
            System.out.printf("�ڵ�%d�������ҵ��� ��Աid = %d\n", empLinkedListNo, id);
        }else{
            System.out.println("�ڹ�ϣ����û�ҵ��ù�Ա");
        }
    }


}

/**
 * ��Ա
 */
class Emp{
    public int id;
    public String name;
    public Emp next;//Ĭ��Ϊ��
    public Emp(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }
}

/**
 * ����һ����Ա����
 * ����������ӡ���ʾ����
 */
class EmpLinkedList{
    private Emp head;//ͷָ�룬ָ���һ��Emp�����û��ͷ���,Ĭ��Ϊ��
    //���Ա��,�ٶ���ӹ�Ա��ʱ��������
    //�ٶ�id������
    public void add(Emp emp){
        //�������ӵ�һ����Ա
        if(head == null){
            head = emp;
            return;
        }
        //���ǵ�һ����Ա
        Emp curEmp = head;
        while(true){
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        //�˳�ʱ�������
        curEmp.next = emp;
    }

    //��������
    public void list(int no){
        if(head == null){
            System.out.println("��" + no + "����Ϊ��");
            return;
        }
        System.out.println("��" + no + "������ϢΪ");
        Emp curEmp = head;
        while(true){
            System.out.printf("=> id = %d name = %s\n",curEmp.id, curEmp.name);
            if(curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //����id���ҹ�Ա,����ҵ�������Emp,û�ҵ�����-1
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("����Ϊ��");
            return null;
        }
        Emp curEmp = head;
        while(true){
            if(curEmp.id == id){
                break;
            }
            //�˳�����
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            //���û�ҵ���������
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
