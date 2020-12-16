package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        // Task #1 -- Test
        String[] v = {"2", "33", "1"};
        Integer[] v2 = {1,2,3,4,5};
        swap(v, 0, 2);
        System.out.println(Arrays.toString(v));
        swap(v2, 0, 2);
        System.out.println(Arrays.toString(v2));

        // Task #2 -- Test
        ArrayList list = convertArrayToArrList(new Integer[]{1,2,3,4,});
        System.out.println(list.getClass());

        // Task #3 -- Test
        // Коробка с апельсинами
        Box<Orange> oranges = new Box<>();
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());
        oranges.add(new Orange());

        // Коробка с яблоками
        Box<Apple> apples = new Box<>();
        apples.add(new Apple());
        apples.add(new Apple());

        // Вторая коробка с яблоками
        Box<Apple> apples2 = new Box<>();
        apples2.add(new Apple());
        apples2.add(new Apple());
        apples2.add(new Apple());
        apples2.add(new Apple());

        System.out.println(apples.getWeight());
        System.out.println(apples2.getWeight());
        System.out.println(apples.compareTo(oranges));

        // Пересыпаем из 1 во 2
        apples.pourOver(apples2);
    }

    /** Task #1
     * @param arrays исходный массив в котором будут менятся элементы
     * @param s1 первый изменяемый элемент
     * @param s2 второй изменяемый элемент
     * **/
    static <T> void swap(T[] arrays, int s1, int s2){
        if (arrays.length < s1 || arrays.length < s2) return;
        T value = arrays[s1];
        arrays[s1] = arrays[s2];
        arrays[s2] = value;
    }

    /** Task #2
     * @param array исходный массив в котором будут менятся элементы
     * @return созданный ArrayList на основе  array
     * **/
    static <T>  ArrayList<T> convertArrayToArrList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    // #2 Не привязываемся к конкретной реалиации
    static <T> List<T> convertArrayToList(T[] arrays){
        return Arrays.asList(arrays);
    }



}