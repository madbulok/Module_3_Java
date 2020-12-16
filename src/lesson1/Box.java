package lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<T>();
    }

    /**
     * @param fruit добавляемый фрукт в ящик
     * **/
    public void add(T fruit){
        fruits.add(fruit);
    }

    /**
     * @param fruit забираем фрукт из ящика
     * **/
    public void remove(T fruit){
        fruits.remove(fruit);
    }

    /**
     * @return вес ящика с фруктами
     * **/
    public float getWeight(){
        if (fruits.isEmpty()) return 0;
        return fruits.size() * fruits.get(0).getWeight();
    }

    /**
     * @param dest ящик в который перекладываем фрукты
     * **/
    public void pourOver(Box<T> dest){
        dest.getFruits().addAll(fruits);
        clearBox();
    }

    /**
     * выкидываем из ящика все фрукты
     * **/
    public void clearBox(){
        fruits.clear();
    }

    /**
     * берем ссылку на все фрукты в ящике
     * **/
    public List<T> getFruits() {
        return fruits;
    }

    @Override
    public int compareTo(Box anotherBox) {
        return Float.compare(getWeight(), anotherBox.getWeight());
    }
}
