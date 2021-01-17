package lesson7;

import lesson7.annotation.AfterSuite;
import lesson7.annotation.BeforeSuite;
import lesson7.annotation.Test;
import lesson7.annotation.TestedClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {

    private static Method beforeMethod = null;
    private static Method afterMethod = null;



    public static void start(Class c){
        if (!c.isAnnotationPresent(TestedClass.class)){
            throw new RuntimeException("Переданный класс не является тестируемым!");
        } else {
            Method[] allMethod = c.getDeclaredMethods();

            for (Method m : allMethod){
                if (m.isAnnotationPresent(BeforeSuite.class)){
                    if (beforeMethod != null) throw new RuntimeException("В тестируемом классе разрешен только один метод с аннотацией BeforeSuite");
                    beforeMethod = m;
                }
                if (m.isAnnotationPresent(AfterSuite.class)){
                    if (afterMethod != null) throw new RuntimeException("В тестируемом классе разрешен только один метод с аннотацией AfterSuite");
                    afterMethod = m;
                }
            }

            // при наличие метода с аннотацией BeforeSuite запускаем метод
            if (beforeMethod != null) {
                try {
                    beforeMethod.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            //Контейнер для хранения тестируемых методов
            List<Method> testedMethodList = new LinkedList<>();

            //наполнение данного контейнера
            for (Method m : allMethod){
                if (m.isAnnotationPresent(Test.class)){
                    int p = m.getAnnotation(Test.class).priority();
                    if (p > 0 && p <= 10) {
                        testedMethodList.add(m);
                    } else throw new RuntimeException("Приоритет теста метода " + m.getName() +
                            " не лежит в диапазоне 1-10. priority = " + p);
                }
            }

            // сортировка
            testedMethodList.sort(Comparator.comparingInt(value -> value.getAnnotation(Test.class).priority()));

            // выполнение меодов с аннотацией Test в порядке приоритета
            testedMethodList.forEach(method -> {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

            // при наличие метода с аннотацией AfterSuite запускаем метод
            if (afterMethod != null) {
                try {
                    afterMethod.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}