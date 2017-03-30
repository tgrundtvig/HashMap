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
public class Test
{
    public static void main(String[] args)
    {
        Map<String, Integer> myMap = new HashMapLink<>();
        
        for(int i = 0; i < 1000; i += 2)
        {
            String s = "#" + i;
            myMap.put(s, i);
        }
        System.out.println("Size: " + myMap.size());
        for(int i = 0; i < 1000; ++i)
        {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }



        Map<String, Integer> myHashMap = new HashMap<>();
        for(int i = 0; i < 10; i += 2)
        {
            String s = "#" + i;
            myHashMap.put(s, i);
        }

        printMap(myHashMap);

        myHashMap.remove("#0");
        printMap(myHashMap);

        myHashMap.remove("#2");
        printMap(myHashMap);

        myHashMap.remove("#4");
        printMap(myHashMap);

        myHashMap.remove("#6");
        printMap(myHashMap);



    }


    private static void printMap(Map<String, Integer> myMap){
        for(int i = 0; i < 10; ++i)
        {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);

        }
        System.out.println(myMap.size());
    }
}
