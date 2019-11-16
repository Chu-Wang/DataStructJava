# 仅仅用来学习.md文件的使用
## 请忽略！

* Object类
* Date类
* DateFormat类


-[ ] 能够说出Object类的特点
-[ ] 能够重写Object类的toString方法


**JDK8**

* `public Date()`：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
> tips: 由于我们处于东八区，所以我们的基准时间为1970年1月1日8时0分0秒。

```java
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        System.out.println(sb1); // (空白)
        // 使用带参构造
        StringBuilder sb2 = new StringBuilder("itcast");
        System.out.println(sb2); // itcast
    }
}
```