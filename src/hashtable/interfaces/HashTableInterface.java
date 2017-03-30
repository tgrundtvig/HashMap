/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable.interfaces;

/**
 *
 * @author Dennis
 */
public interface HashTableInterface<k,v> {
    public void insert(k key, v value);
    public v find(k key);
    public void delete(k key);
}
