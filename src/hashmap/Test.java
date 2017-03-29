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
        Map<String, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < 1000; i += 2)
        {
            String s = "#" + i;
            myMap.put(s, i);
        }
        myMap.remove("#997");
        System.out.println("Size: " + myMap.size());
        for(int i = 0; i < 1000; ++i)
        {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }
        System.out.println(myMap.remove("#1001"));
        System.out.println(myMap.remove("#996"));
    }
}
