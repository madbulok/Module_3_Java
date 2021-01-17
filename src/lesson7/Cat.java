package lesson7;

import lesson7.annotation.AfterSuite;
import lesson7.annotation.BeforeSuite;
import lesson7.annotation.Test;
import lesson7.annotation.TestedClass;

@TestedClass
public class Cat {

    @BeforeSuite
    public static  void before(){
        System.out.println("before");
    }

    @Test(priority = 1)
    public static void test1(){
        System.out.println("test1 " + 1);
    }
    @Test
    public static void test2(){
        System.out.println("test2 " + 5);
    }
    @Test(priority = 2)
    public static void test3(){
        System.out.println("test3 " + 2);
    }
    @Test(priority = 8)
    public static void test4(){
        System.out.println("test4 " + 8);
    }
    @Test(priority = 2)
    public static void test5(){
        System.out.println("test5 " + 2);
    }

    @AfterSuite
    public static  void after(){
        System.out.println("after");
    }
}
