/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import hashtable.services.HashTableArray;
import hashtable.services.HashTableLinked;

/**
 *
 * @author Dennis
 */
public class HashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTableArray<Integer, Integer> hta = new HashTableArray<>();
        hta.insert(1, 1);
        hta.insert(7, 7);
        hta.insert(21, 21);
        
        hta.delete(11);
        
        System.out.println("Value was: " + hta.find(21));
        
        HashTableLinked<Integer, Integer> htl = new HashTableLinked<>();
        htl.insert(1, 1);
        htl.insert(7, 7);
        htl.insert(21, 21);
        
        htl.delete(7);
        
        System.out.println("Value was: " + htl.find(21));
    }
    
}
