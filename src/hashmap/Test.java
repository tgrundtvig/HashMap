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
//        Map<String, Integer> myMap = new HashMapLink<>();
//        
//        for(int i = 0; i < 1000; i += 2)
//        {
//            String s = "#" + i;
//            myMap.put(s, i);
//        }
//        System.out.println("Size: " + myMap.size());
//        for(int i = 0; i < 1000; ++i)
//        {
//            String s = "#" + i;
//            Integer value = myMap.get(s);
//            System.out.println("Key: " + s + " Value: " + value);
//        }
         Map<String, Integer> myMap = new HashMap<>();
         Map<String, Integer> myLinkHashMap = new HashMapLink<>();
        
        myMap.put("testing", 1);
        myMap.put("testing2", 2);
        myMap.put("testing4", 3);
        myMap.put("testing5", 4);
        
        System.out.println("Size before delete: " + myMap.size());
    
        myMap.remove("testing4");
        
        System.out.println("Size after delete: " + myMap.size());
        
        
        /// testing myLinkHashmap
        myLinkHashMap.put("testing", 1);
        myLinkHashMap.put("testing2", 2);
        myLinkHashMap.put("testing4", 3);
        myLinkHashMap.put("testing5", 4);
        
        System.out.println("LinkHashMap size before delete: " + myLinkHashMap.size());
    
        myLinkHashMap.remove("testing4");
        
        System.out.println("LinkHashMap size after delete: " + myLinkHashMap.size());
       
        
    }
}
