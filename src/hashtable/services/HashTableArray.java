/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable.services;

import hashtable.interfaces.HashTableInterface;

/**
 *
 * @author Dennis
 */
public class HashTableArray<k, v> implements HashTableInterface<k, v> {

    private Node[] arr;
    private int elementsInArray;

    public HashTableArray() {
        this.arr = new Node[7];
        elementsInArray = 0;
    }

    @Override
    public void insert(k key, v value) {
        int index = (Math.abs(key.hashCode()) % arr.length);
        if (null == arr[index]) {
            arr[index] = new Node(key, value);
            elementsInArray++;
        } else {
            for (int i = index; i < arr.length; i = (i + 1) % arr.length) {
                if (null == arr[i]) {
                    arr[i] = new Node(key, value);
                    elementsInArray++;
                    break;
                }
            }
        }
        if (((elementsInArray * 10) / arr.length) > 7) {
            increaseArr();
        }
    }

    @Override
    public v find(k key) {
        int index = (Math.abs(key.hashCode()) % arr.length);
        if (null == arr[index]) {
            return null;
        } else {
            for (int i = index; i < arr.length; i = (i + 1) % arr.length) {
                if (null == arr[i]) {
                    return null;
                }
                if (arr[i].key.equals(key)) {
                    return (v) arr[i].value;
                }
            }
        }
        return null;
    }

    @Override
    public void delete(k key) {
        int index = (key.hashCode() % arr.length);
        for (int i = index; i < arr.length; i = i + 1 % arr.length) {
            if(arr[index] == null) break;
            if (arr[index].key == key) {
                arr[index] = null;
                elementsInArray--;
                index++;
                while (arr[index % arr.length] != null) {
                    insert((k) arr[index + 1].key, (v) arr[index + 1].value);
                    arr[index+1] = null;
                    index++;
                }
                break;
            }
        }
        if (((double) elementsInArray / (double) arr.length) < 0.3) {
            decreaseArr();
        }
    }

    private void increaseArr() {
        Node[] x = this.arr;
        this.arr = new Node[x.length * 2];
        elementsInArray = 0;
        for (int i = 0; i < x.length; i++) {
            if (null != x[i]) {
                this.insert((k) x[i].key, (v) x[i].value);
            }
        }
    }

    private void decreaseArr() {
        Node[] x = this.arr;
        this.arr = new Node[Math.abs(x.length / 3)];
        elementsInArray = 0;
        for (int i = 0; i < x.length; i++) {
            if (null != x[i]) {
                this.insert((k) x[i].key, (v) x[i].value);
            }
        }
    }

    private class Node<k, v> {

        public k key;
        public v value;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

}
