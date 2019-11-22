package tree;


/**
 * @author WangMingMing
 * @creat 2019-11-22 16:16
 * �������ı����Ͳ��ҡ�ǰ���������
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //����Ҫ����һ��������
        BinaryTree binaryTree = new BinaryTree();
        //�������
        HeroNode root = new HeroNode(1, "�ɽ�");
        HeroNode heroNode2 = new HeroNode(2, "����");
        HeroNode heroNode3 = new HeroNode(3, "¬����");
        HeroNode heroNode4 = new HeroNode(4, "�ֳ�");
        HeroNode heroNode5 = new HeroNode(5, "��ʤ");
        //���ֶ��������������ٺ�������
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        binaryTree.setRoot(root);
        //��ǰ�����
        System.out.println("ǰ�����");
        binaryTree.preOrder();

        System.out.println("�������");
        binaryTree.infixOrder();

        System.out.println("��������");
        binaryTree.postOrder();

        //ǰ���������
        System.out.println("ǰ���������");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("�ҵ��ˡ���ϢΪno=%d name=%s\n",resNode.getNo(), resNode.getName());
        }else{
            System.out.printf("û���ҵ����no=%d������\n",5);
        }

        System.out.println("�����������");
        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("�ҵ��ˡ���ϢΪno=%d name=%s\n",resNode1.getNo(), resNode1.getName());
        }else{
            System.out.printf("û���ҵ����no=%d������\n",5);
        }

        System.out.println("�����������");
        HeroNode resNode2 = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("�ҵ��ˡ���ϢΪno=%d name=%s\n",resNode2.getNo(), resNode2.getName());
        }else{
            System.out.printf("û���ҵ����no=%d������\n",5);
        }
    }
}
//����һ��������
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //ǰ�����
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("��ǰ������Ϊ�գ��޷�����");
        }
    }
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("��ǰ������Ϊ�գ��޷��������");
        }
    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("��ǰ������Ϊ�գ��޷��������");
        }
    }

    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        if(root != null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if(root != null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

}

/**
 * ���
 */
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //���ķ���
    //��ǰ��������������ٺ���
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){//���������ݹ����
            this.left.preOrder();
        }
        if(this.right != null){//���������ݹ�ǰ�����
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    //ǰ���������

    /**
     *
     * @param no Ҫ���ҵı��
     * @return �ҵ��Ļ�����Node,�Ҳ�������null
     */
    public HeroNode preOrderSearch(int no){
        HeroNode resultheroNode = null;
        if(this.no == no){//�Ƚϵ�ǰ����ǲ���Ҫ���ҵ�
            return this;
        }
        if(this.left != null){//��������ѯ
            resultheroNode = this.left.preOrderSearch(no);
        }
        if(resultheroNode != null){
            //˵���ҵ���
            return resultheroNode;
        }
        if(this.right != null){//ǰ��û���ҵ������Ҳ���
            resultheroNode = this.right.preOrderSearch(no);
        }
        return resultheroNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode resheroNode = null;
        if(this.left != null){
            resheroNode = this.left.infixOrderSearch(no);
        }
        if(resheroNode != null){
            return resheroNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resheroNode = this.right.infixOrderSearch(no);
        }
        return resheroNode;
    }

    //�����������
    public HeroNode postOrderSearch(int no){
        HeroNode resheroNode = null;
        if(this.right != null){//����������ʼ
            resheroNode = this.left.preOrderSearch(no);
        }
        if(resheroNode != null){//�ҵ��˾ͷ���
            return resheroNode;
        }
        if(this.left != null){
            resheroNode = this.left.postOrderSearch(no);
        }
        if(resheroNode != null){
            return resheroNode;
        }
        if(this.no == no){//����������û���ҵ����ͱȽϵ�ǰ���
            return this;
        }
        return null;
    }

}










