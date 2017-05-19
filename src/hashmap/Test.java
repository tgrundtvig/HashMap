/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

/**
 *
 * @author Mohammed Salameh
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
            myMap.remove("#5");
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }
        testImplementation();
    }
    
    
    public static void testImplementation() {
    
        Map<String, Integer> myMap = new HashMapLink<>();
        
        //populate
        for (int i = 0; i<1000; i++) {
            String s = "#"+i;
            myMap.put(s ,i);
        }
        System.out.println("Size: " + myMap.size());
        
        for (int i = 0; i < 1000; ++i) {
            String s = "#"+i;
            myMap.remove("#4");
            Integer value = myMap.get(s);
            System.out.printf("Key: " + s + " Value: "+ value);
        }
        
    }
}
