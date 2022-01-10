package com.atguigu.map;

import com.atguigu.collection.Person;
import org.junit.Test;

import java.util.*;

import static java.lang.System.out;
import static java.util.Arrays.sort;

public class MapTest {
    @Test
    public void test1(){
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        System.out.println(map);

        String value = map.remove(33);
        System.out.println(value);
        System.out.println(map);

    }
    @Test
    public void test2(){
        HashMap<Person, String> map = new HashMap<Person, String>();
	     		map.put(new Person("a",20), "里约热内卢");
	     		map.put(new Person("b",18), "索马里");
	     		map.put(new Person("b",18), "索马里");
	     		map.put(new Person("c",19), "百慕大");
	     		for(Person key : map.keySet()){
	     			String value = map.get(key);
	     			System.out.println(key+"..."+value);
	     		}
	     		System.out.println("===================");
	     		for(Map.Entry<Person, String> entry : map.entrySet()){
	     			System.out.println(entry.getKey()+"..."+entry.getValue());
	     		}

    }

    @Test
    public void test3(){
        HashMap<String, Person> map = new HashMap<String, Person>();
     		map.put("beijing", new Person("a",20));
     		map.put("tianjin", new Person("b",18));
     		map.put("shanghai", new Person("c",19));
     		map.put("shanghai", new Person("d",19));
	     		for(String key : map.keySet()){
	     			Person value = map.get(key);
	     			System.out.println(key+"..."+value);
	     		}
	     		System.out.println("=================");
	     		for(Map.Entry<String, Person> entry : map.entrySet()){
	     			String key = entry.getKey();
	     			Person value = entry.getValue();
	     			System.out.println(key+"..."+value);
	     		}

    }

    @Test
    public void test4(){
        LinkedList<String> link = new LinkedList<String>();
        link.add("1");
        link.add("2");
        link.add("3");
        link.add("4");

        String first = link.removeFirst();
        String last = link.removeLast();
        System.out.println(first);
        System.out.println(last);

        System.out.println(link);

    }

    @Test
    public void test5(){
        out.println("hello");

        int[] arr = {1,4,2};
        sort(arr);
        out.println(arr);

    }


    @Test
    public void test6(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(11);
        list.add(8);
        list.add(10);
        list.add(15);
        list.add(20);
        System.out.println(list);

        //调用工具类方法shuffle对集合随机排列
        Collections.shuffle(list);
        System.out.println(list);

    }

    @Test
    public void test7(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(15);
        list.add(20);
        //调用工具类静态方法binarySearch
        int index = Collections.binarySearch(list, 16);
        System.out.println(index);

    }

    @Test
    public void test8(){
        //创建List集合
        List<String> list = new ArrayList<String>();
        list.add("ewrew");
        list.add("qwesd");
        list.add("Qwesd");
        list.add("bv");
        list.add("wer");
        System.out.println(list);
        //调用集合工具类的方法sort
        Collections.sort(list);
        System.out.println(list);

    }
}
