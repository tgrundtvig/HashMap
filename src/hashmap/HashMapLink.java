/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmap;

import java.util.List;

/**
 * @author Tobias
 */
public class HashMapLink<K, V> implements Map<K, V> {
    private Link<K, V>[] array;
    private int size;

    public HashMapLink() {
        array = new Link[8];
        size = 0;
    }


    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        Link<K, V> cur = array[index];
        while (true) {
            if (cur == null) {
                Link<K, V> newLink = new Link(new MapEntry(key, value), array[index]);
                array[index] = newLink;
                ++size;
                expandArray();
                return null;
            } else if (cur.getEntry().getKey().equals(key)) {
                V oldValue = cur.getEntry().getValue();
                cur.setEntry(new MapEntry<>(key, value));
                return oldValue;
            } else {
                cur = cur.getNext();
            }
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        Link<K, V> cur = array[index];
        int collisions = 0;
        while (true) {
            if (cur == null) {
                if (collisions > 0)
                    System.out.println("Collisions: " + collisions);
                return null;
            } else if (cur.getEntry().getKey().equals(key)) {
                if (collisions > 0)
                    System.out.println("Collisions: " + collisions);
                return cur.getEntry().getValue();
            } else {
                ++collisions;
                cur = cur.getNext();
            }
        }
    }

    //TODO: Implement downsize array method
    @Override
    public V remove(K key) {
        int index = getIndex(key);
        Link<K, V> prev = null;
        Link<K, V> current = array[index];

        if (current == null) {
            return null;
        } else if (current.getNext() == null) {
            Link<K, V> temp = current;
            array[index] = null;
            return temp.getEntry().getValue();
        }

        while (current != null) {
            if (current.getEntry().getKey().equals(key)) {
                if (prev == null) {
                    array[index] = current.getNext();
                    return current.getEntry().getValue();
                } else {
                    prev.setNext(current.getNext());
                    return current.getEntry().getValue();
                }
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void expandArray() {
        if ((size * 100) / array.length > 20) {
            Link<K, V>[] oldArray = array;
            array = new Link[array.length * 2];
            size = 0;
            for (int i = 0; i < oldArray.length; ++i) {
                Link<K, V> cur = oldArray[i];
                while (cur != null) {
                    put(cur.getEntry().getKey(), cur.getEntry().getValue());
                    cur = cur.getNext();
                }
            }
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % array.length;
    }

    private static class MapEntry<K, V> {
        private final K key;
        private final V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private static class Link<K, V> {
        private MapEntry<K, V> entry;
        private Link<K, V> next;

        public Link(MapEntry<K, V> entry, Link<K, V> next) {
            this.entry = entry;
            this.next = next;
        }

        public MapEntry<K, V> getEntry() {
            return entry;
        }

        public void setEntry(MapEntry<K, V> entry) {
            this.entry = entry;
        }

        public Link<K, V> getNext() {
            return next;
        }

        public void setNext(Link<K, V> next) {
            this.next = next;
        }


    }
}
