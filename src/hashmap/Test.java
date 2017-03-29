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
//        Map<String, Integer> myMap = new HashMap<>();;
//        
//        for(int i = 0; i < 1000; i += 1)
//        {
//            String s = "#" + i;
//            myMap.put(s, i);
//        }
//        System.out.println("Size: " + myMap.size());
//        for(int i = 0; i < 1000; i++)
//        {
//            String s = "#" + i;
//            Integer value = myMap.get(s);
//            System.out.println("Key: " + s + " Value: " + value);
//        }

        Map<String, Integer> myMap = new HashMap<>();
        
        int numOfElements = 5;

        for (int i = 0; i < numOfElements; i++) {
            String s = "#" + i;
            myMap.put(s, i);
        }
        System.out.println("Size: " + myMap.size());

        for (int i = 0; i < numOfElements; i++) {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }

        // Integer intObj1 = new Integer(3);
        Integer value = myMap.remove("#452");
        System.out.println("The deleted element: " + value);

        // System.out.println("Size: " + myMap.size());
        for (int i = 0; i < numOfElements; i++) {
            String s = "#" + i;
            Integer value2 = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value2);
        }

    }
}
