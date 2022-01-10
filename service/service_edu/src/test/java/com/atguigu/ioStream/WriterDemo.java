package com.atguigu.ioStream;

import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class WriterDemo {
    @Test
    public void test1() throws IOException {
        FileWriter fw = new FileWriter("d:\\a.txt");

        //写1个字符
        fw.write(100);
        fw.flush();

        //写1个字符数组
        char[] c = {'a','b','c','d','e'};
        fw.write(c);
        fw.flush();

        //写字符数组一部分
        fw.write(c, 2, 2);
        fw.flush();

        //写如字符串
        fw.write("hello");
        fw.flush();

        fw.close();

    }

    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("d:\\1.txt");
        /*int len = 0 ;
          while((len = fr.read())!=-1){
         System.out.print((char)len);
                    }*/
        char[] ch = new char[1024];
        int len = 0 ;
        while((len = fr.read(ch))!=-1){
            System.out.print(new String(ch,0,len));
        }

        fr.close();


    }

    @Test
    public void test3() throws IOException {
                //创建字节输出流,绑定文件
                //FileOutputStream fos = new FileOutputStream("c:\\buffer.txt");
                //创建字节输出流缓冲流的对象,构造方法中,传递字节输出流
                BufferedOutputStream bos = new
                        BufferedOutputStream(new FileOutputStream("d:\\buffer.txt"));

                bos.write(55);

                byte[] bytes = "HelloWorld".getBytes();

                bos.write(bytes);

                bos.write(bytes, 3, 2);

                bos.close();

    }

    @Test
    public void test4() throws IOException {
        FileWriter fw = new FileWriter("d:\\buffer.txt");
        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write(100);
        bfw.flush();
        bfw.write("你好".toCharArray());
        bfw.flush();

        bfw.write("你好");
        bfw.newLine();
        bfw.flush();


        bfw.write("我好好");
        bfw.newLine();
        bfw.flush();

        bfw.write("大家都好");
        bfw.flush();

        bfw.close();

    }

    @Test
    public void test5() throws IOException {
        int lineNumber = 0;
        //创建字符输入流缓冲流对象,构造方法传递字符输入流,包装数据源文件
        BufferedReader bfr = new BufferedReader(new FileReader("d:\\buffer.txt"));
        //调用缓冲流的方法 readLine()读取文本行
        //循环读取文本行, 结束条件 readLine()返回null
        String line = null;
        while((line = bfr.readLine())!=null){
            lineNumber++;
            System.out.println(lineNumber+"  "+line);
        }
        bfr.close();

    }

    @Test
    public void test6() throws IOException {
        Properties pro = new Properties();
        FileReader fr = new FileReader("d:\\pro.properties");
        //调用集合的方法load,传递字符输入流
        pro.load(fr);
        fr.close();
        System.out.println(pro);


    }

    @Test
    public void test7() throws IOException {
        Properties pro = new Properties();
        pro.setProperty("name", "zhangsan");
        pro.setProperty("age", "31");
        pro.setProperty("email", "123456789@163.com");
        FileWriter fw = new FileWriter("d:\\pro.properties");
        //键值对,存回文件,使用集合的方法store传递字符输出流
        pro.store(fw, "");
        fw.close();

    }

    @Test
    public void writeObject() throws IOException{
        //创建字节输出流,封装文件
        FileOutputStream fos = new FileOutputStream("d:\\person.txt");
        //创建写出对象的序列化流的对象,构造方法传递字节输出流
        ObjectOutputStream oss = new ObjectOutputStream(fos);
        Person p = new Person("lisi",25);
        //调用序列化流的方法writeObject,写出对象
        oss.writeObject(p);
        oss.close();
    }

    @Test
    public void redObject() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("d:\\person.txt");
        //创建反序列化流,构造方法中,传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(fis);
        //调用反序列化流的方法 readObject()读取对象
        Object obj =ois.readObject();
        System.out.println(obj);
        ois.close();

    }

    @Test
    public void test8() {
        int[] arr = {1};
        System.out.println(arr);

        char[] ch = {'a','b'};
        System.out.println(ch);

        byte[] b = {};
        System.out.println(b);


    }

    @Test
    public void test9(){
        for (int i=0;i<100;i++){
            System.out.println(new Random().nextInt(2));
        }
    }

}
