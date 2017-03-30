/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

/**
 *
 * @author Tobias
 */
public class Test {

    public static void linkImpl() {
        Map<Integer, Integer> myMap = new HashMapLink<>();

        for (int i = 0; i < 1000; i++) {
            int z = i;
            myMap.put(z, i);
        }
        System.out.println("Size: " + myMap.size());

        for (int i = 0; i < 1000; ++i) {
            int y = i;
            myMap.remove(5);
            Integer value = myMap.get(y);
            System.out.println("Key: " + y + " Value: " + value);
        }
    }

    public static void hmImpl() {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int s = i;
            myMap.put(s, i);
        }
        System.out.println("Size: " + myMap.size());

        for (int i = 0; i < 1000; ++i) {
            int sz = +i;
            myMap.remove(4);
            Integer value = myMap.get(sz);
            System.out.println("Key: " + sz + " Value: " + value);
        }
    }

    public static void main(String[] args) {
        linkImpl();
        //hmImpl();

    }

}
