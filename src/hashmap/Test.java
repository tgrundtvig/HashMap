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
        for(int i = 0; i < 1000; ++i)
        {
            String s = "#" + i;
            Integer value = myMap.get(s);
        }

        Integer value = myMap.get("#10");
        System.out.println("Key: #10 Value: " + value);

        Integer value1 = myMap.remove("#10");
        System.out.println("Key: #10 Removed: " + value1);

        Integer value2 = myMap.get("#10");
        System.out.println("Key: #10 Value: " + value2);

    }
}
