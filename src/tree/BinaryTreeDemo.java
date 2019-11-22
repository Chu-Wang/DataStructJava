package tree;


/**
 * @author WangMingMing
 * @creat 2019-11-22 16:16
 * 二叉树的遍历和查找、前序后序中序
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //现需要创建一个二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建结点
        HeroNode root = new HeroNode(1, "松江");
        HeroNode heroNode2 = new HeroNode(2, "无用");
        HeroNode heroNode3 = new HeroNode(3, "卢俊义");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "关胜");
        //先手动创建二叉树，再后续遍历
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        binaryTree.setRoot(root);
        //先前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后续遍历");
        binaryTree.postOrder();

        //前序遍历查找
        System.out.println("前序遍历查找");
        HeroNode resNode = binaryTree.preOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了、信息为no=%d name=%s\n",resNode.getNo(), resNode.getName());
        }else{
            System.out.printf("没有找到编号no=%d的人物\n",5);
        }

        System.out.println("中序遍历查找");
        HeroNode resNode1 = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了、信息为no=%d name=%s\n",resNode1.getNo(), resNode1.getName());
        }else{
            System.out.printf("没有找到编号no=%d的人物\n",5);
        }

        System.out.println("后序遍历查找");
        HeroNode resNode2 = binaryTree.infixOrderSearch(5);
        if(resNode != null){
            System.out.printf("找到了、信息为no=%d name=%s\n",resNode2.getNo(), resNode2.getName());
        }else{
            System.out.printf("没有找到编号no=%d的人物\n",5);
        }
    }
}
//定义一个二叉树
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("当前二叉树为空，无法遍历");
        }
    }
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("当前二叉树为空，无法中序遍历");
        }
    }

    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("当前二叉树为空，无法后序遍历");
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
 * 结点
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
    //结点的方法
    //先前序遍历、再中序、再后续
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){//向左子树递归遍历
            this.left.preOrder();
        }
        if(this.right != null){//向右子树递归前序遍历
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
    //前序遍历查找

    /**
     *
     * @param no 要查找的编号
     * @return 找到的话返回Node,找不到返回null
     */
    public HeroNode preOrderSearch(int no){
        HeroNode resultheroNode = null;
        if(this.no == no){//比较当前结点是不是要查找的
            return this;
        }
        if(this.left != null){//向左来查询
            resultheroNode = this.left.preOrderSearch(no);
        }
        if(resultheroNode != null){
            //说明找到了
            return resultheroNode;
        }
        if(this.right != null){//前面没有找到，向右查找
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

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resheroNode = null;
        if(this.right != null){//从右子树开始
            resheroNode = this.left.preOrderSearch(no);
        }
        if(resheroNode != null){//找到了就返回
            return resheroNode;
        }
        if(this.left != null){
            resheroNode = this.left.postOrderSearch(no);
        }
        if(resheroNode != null){
            return resheroNode;
        }
        if(this.no == no){//左右子树都没有找到，就比较当前结点
            return this;
        }
        return null;
    }

}










