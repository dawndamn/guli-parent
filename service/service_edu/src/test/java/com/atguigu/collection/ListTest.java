package com.atguigu.collection;

import com.atguigu.exception.Fu;
import com.atguigu.exception.Zi;
import org.junit.Test;

import java.util.*;

public class ListTest {
    @Test
    public void list(){
        List<String> list = new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        System.out.println(list);

        list.add(1, "itcast");
        System.out.println(list);


    }

    @Test
    public void linkedList(){
        LinkedList<String> link = new LinkedList<String>();

        link.addLast("heima");

        link.add("abc");
        link.add("bcd");

        link.add(2,"2");
        link.addFirst("itcast");
        System.out.println(link);
        System.out.println(link.get(2));


    }

    @Test
    public void hashSet(){
        Set<String> set = new HashSet<String>();
        set.add("cn");
        set.add("heima");
        set.add("java");
        set.add("java");
        set.add("itcast");

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("==============");

        for(String s : set){
            System.out.println(s);
        }
    }

    @Test
    public void hash(){
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

          System.out.println("重地".hashCode());
          System.out.println("通话".hashCode());

        System.out.println(new Fu().hashCode());
        System.out.println(new Zi().hashCode());

    }

    @Test
    public void test(){

        //将Person对象中的姓名,年龄,相同数据,看作同一个对象
        //判断对象是否重复,依赖对象自己的方法 hashCode,equals
        HashSet<Person> setPerson = new HashSet<Person>();
        setPerson.add(new Person("a",11));
        setPerson.add(new Person("b",10));
        setPerson.add(new Person("b",10));
        setPerson.add(new Person("c",25));
        setPerson.add(new Person("d",19));
        setPerson.add(new Person("e",17));//每个对象的地址值都不同,调用Obejct类的hashCode方法返回不同哈希值,直接存入
        System.out.println(setPerson);
    }

}
