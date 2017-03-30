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
            node.setNext(new Node<k, v>(key, value));
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
            v result = (v) find(key, arr[index]);
            return ((result == null)) ? null: (v)find(key,arr[index]);
        }
    }

    private v find(k key, Node<k, v> node) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node.value;
        } else {
            return find(key, node.getNext());
        }
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
        if (node.key.equals(key)) {
            if(node.getNext() == null) {
                return null;
            } else {
                return node.getNext();
            }
        } else if(node.getNext().key == key) {
            if(node.getNext().getNext() == null) {
                Node<k, v> x = node.getNext().getNext();
                node.getNext().setNext(null);
                node.setNext(x);
                return node;
            } else {
                node.setNext(null);
                return node;
            }
        } else {
            return delete(key, node.getNext());
        }
    }

    private void increaseArr() {
        Node[] x = this.arr;
        this.arr = new Node[x.length * 2];
        elementsInArray = 0;
        for (int i = 0; i < x.length; i++) {
            if (null != x[i]) {
                Node<k, v> node = x[i];
                do {
                    this.insert((k) node.key, (v) node.value);
                    node = node.getNext();
                } while (node != null);
            }
        }
    }

    private void decreaseArr() {
        Node[] x = this.arr;
        this.arr = new Node[Math.abs(x.length / 3)];
        elementsInArray = 0;
        for (int i = 0; i < x.length; i++) {
            if (null != x[i]) {
                Node<k, v> node = x[i];
                do {
                    this.insert((k) x[i].key, (v) x[i].value);
                    node = node.getNext();
                } while (node != null);
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
