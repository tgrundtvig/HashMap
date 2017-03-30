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
        TestMap(100);
        TestLink(100);
    }
    
    public static void TestMap(int times){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < times; i ++){
            map.put(i, i+10);
        }
        System.out.println("Hash size before:" + map.size());
        map.remove(50);
        System.out.println("Hash size after:" + map.size());
    }
    
    public static void TestLink(int times){
        Map<String, Integer> link = new HashMapLink<>();
        for(int i = 0; i < times; i ++){
            link.put("@"+i, i);
        }
        System.out.println("Link size before:" + link.size());
        link.remove("@50");
        System.out.println("Link size after:" + link.size());
    }
    
}
