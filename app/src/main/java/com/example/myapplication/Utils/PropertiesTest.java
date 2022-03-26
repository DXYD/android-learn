package com.example.myapplication.Utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @desc: Properties读取配置文件属性值的方式
 * @author: cao_wencao
 * @date: 2020-12-29 10:08
 */
public class PropertiesTest {

    /**
     * 1. 方式一
     * 从当前的类加载器的getResourcesAsStream来获取
     * InputStream inputStream = this.getClass().getResourceAsStream(name)
     *
     * @throws IOException
     */
    public void test1() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("sqlite.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.list(System.out);
        System.out.println("==============================================");
        String property = properties.getProperty("sqlite.url");
        System.out.println("property = " + property);
    }


    /**
     * 3. 方式三
     * 使用Class类的getSystemResourceAsStream方法 和使用当前类的ClassLoader是一样的
     * InputStream inputStream = ClassLoader.getSystemResourceAsStream(name)
     *
     * @throws IOException
     */
    public void test4() throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("Utils/sqlite.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.list(System.out);
        System.out.println("==============================================");
        String property = properties.getProperty("sqlite.sqlite");
        System.out.println("property = " + property);
    }


    /**
     * 5. 方式五
     * 从文件中获取,使用InputStream字节,主要是需要加上当前配置文件所在的项目src目录地址。路径配置需要精确到绝对地址级别
     * BufferedInputStream继承自InputStream
     * InputStream inputStream = new BufferedInputStream(new FileInputStream(name)
     * 这种方法读取需要完整的路径，优点是可以读取任意路径下的文件，缺点是不太灵活
     * @throws IOException
     */
    public void test3() throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("com/example/myapplication/Utils/sqlite.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.list(System.out);
        System.out.println("==============================================");
        String property = properties.getProperty("sqlite.sqlite");
        System.out.println("property = " + property);
    }


    /**
     * 单独抽取的方法，用户检测能否正确操纵Properties
     *
     * @param inputStream
     * @throws IOException
     */
    private void printKeyValue(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.out.println(key + " = " + properties.get(key));
        }
    }
}