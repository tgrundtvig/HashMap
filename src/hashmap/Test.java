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
        Map<String, Integer> myMapLink = new HashMapLink<>();
        
        for(int i = 0; i < 100; i ++)
        {
            String s = "#" + i;
            myMapLink.put(s, i);
        }
         
         myMapLink.remove("#2");
        System.out.println("#2 is equal "+ myMapLink.get("#2") +" because it was removed.");
        
          Map<String, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < 100; i ++)
        {
            String s = "#" + i;
            myMap.put(s, i);
        } 
        
         myMap.remove("#5");
         System.out.println("#5 is equal "+ myMap.get("#5") +" because it was removed.");
    }
}
