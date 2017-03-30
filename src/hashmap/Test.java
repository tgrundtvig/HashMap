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
        
        /*for(int i = 0; i < 1000; i += 2)
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
        */
         myMap.put("This is a test", 1);
         myMap.put("This is also a test", 2);
         myMap.put("This is also a test + 1", 3);
         
         System.out.println("Size before remove: " + myMap.size());
         myMap.remove("This is also a test");
         System.out.println("Size after remove : " + myMap.size());
    }
}
