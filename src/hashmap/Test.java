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
        //Map<String, Integer> myMap = new HashMapLink<>();
        Map<String, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < 1000; i += 2)
        {
            String s = "#" + i;
            myMap.put(s, i);
        }

        
        System.out.println("Test remove link: "+myMap.get("#2"));
        myMap.remove("#2");
        System.out.println("Test remove link: "+myMap.get("#2"));
        
    }
}
