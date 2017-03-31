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
        
        for(int i = 0; i < 10; i += 1)
        {
            String s = "#" + i;
            myMap.put(s, i);
        }
        System.out.println("Size: " + myMap.size());
        for(int i = 0; i < 10; ++i)
        {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }
        myMap.remove("#8");
        myMap.remove("#3");
        myMap.remove("#1");
        System.out.println(myMap.get("#1"));
        System.out.println(myMap.get("#2"));
        System.out.println(myMap.get("#3"));
        System.out.println(myMap.get("#4"));
        System.out.println(myMap.get("#5"));
        System.out.println(myMap.get("#6"));
        System.out.println(myMap.get("#7"));
        System.out.println(myMap.get("#8"));
        System.out.println(myMap.get("#9"));
    }
}
