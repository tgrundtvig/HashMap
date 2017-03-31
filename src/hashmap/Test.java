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

    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMapLink<>();

        for (int i = 0; i < 100; i += 2) {
            String s = "#" + i;
            myMap.put(s, i);
        }
        System.out.println("Size: " + myMap.size());  
        System.out.println("#20 equals: " + myMap.get("#" + 20));
        myMap.remove("#" + 20);
        System.out.println("#20 equals: " + myMap.get("#" + 20));
        
        
//        for (int i = 0; i < 100; ++i) {
//            String s = "#" + i;
//            Integer value = myMap.get(s);
//            System.out.println("Key: " + s + " Value: " + value);
//        }
    }
}
