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
        
        myMap.put("test", 1);
        myMap.put("test2", 2);
        
        System.out.println("Size: " + myMap.size());
    
        myMap.remove("test");
        
        System.out.println("Size: " + myMap.size());
    
    }
}
