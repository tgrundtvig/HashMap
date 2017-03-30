package hashtable.services;

import hashtable.interfaces.HashTableInterface;

public class HashTableLinked<k, v> implements HashTableInterface<k, v> {

    private Node[] arr;
    private int elementsInArray;

    public HashTableLinked() {
        this.arr = new Node[7];
        this.elementsInArray = 0;
    }

    @Override
    public void insert(k key, v value) {
        int index = (Math.abs(key.hashCode()) % arr.length);
        if (null == arr[index]) {
            arr[index] = new Node(key, value);
            elementsInArray++;
        } else {
            insert(key, value, arr[index]);
        }
        if (((elementsInArray * 10) / arr.length) > 7) {
            increaseArr();
        }
    }

    private void insert(k key, v value, Node<k, v> node) {
        if (node.getNext() == null) {
            node.setNext(new Node<k,v>(key, value));
        } else {
            insert(key, value, node.getNext());
        }
    }

    @Override
    public v find(k key) {
        int index = (Math.abs(key.hashCode()) % arr.length);
        if (null == arr[index]) {
            return null;
        } else {
            return (v) find(key, arr[index]);
        }
    }

    private v find(k key, Node<k, v> node) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node.value;
        } else {
            find(key, node.getNext());
        }
        return null;
    }

    @Override
    public void delete(k key) {
        int index = (key.hashCode() % arr.length);
        if (arr[index] != null) {
            arr[index] = delete(key, arr[index]);
        }
        if (((double) elementsInArray / (double) arr.length) < 0.3) {
            decreaseArr();
        }
    }

    private Node<k, v> delete(k key, Node<k, v> node) {
        if (node != null) {
            if (node.key.equals(key)) {
                if (node.key == key) {
                    Node<k, v> x = node.getNext();
                    node.setNext(null);
                    return x;
                }
            } else {
                delete(key, node.getNext());
            }
        }
        return node;
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

        k key;
        v value;
        Node<k, v> next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setNext(Node<k, v> node) {
            this.next = node;
        }

        public Node<k, v> getNext() {
            return this.next;
        }
    }
}
