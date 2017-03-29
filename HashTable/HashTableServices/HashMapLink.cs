using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HashTable.Intefaces;

namespace HashTable.HashTableServices
{
    public class HashMapLink<k, v> : HashTableInterface<k, v>
    {
        private Link[] array;
        private int count;

        public HashMapLink()
        {
            array = new Link[8];
            count = 0;
        }

        public v insert(k key, v value)
        {
            int index = getIndex(key);
            Link current = array[index];
            while (true)
            {
                if (current == null)
                {
                    array[index] = new Link(new Node(key, value), array[index]);
                    ++count;
                    increaseArray();
                    return default(v);
                }
                if (current.node.key.Equals(key))
                {
                    v oldValue = current.node.value;
                    current.node = new Node(key, value);
                    return oldValue;
                }
                current = current.next;
            }
        }

        public v find(k key)
        {
            int index = getIndex(key);
            Link cur = array[index];
            while (true)
            {
                if (cur == null) return default(v);
                if (cur.node.key.Equals(key)) return cur.node.value;
                cur = cur.next;
            }
        }

        public int size()
        {
            return count;
        }

        public bool isEmpty()
        {
            return size() == 0;
        }

        public void delete(k key)
        {
            int index = getIndex(key);
            Link current = array[index];
            Link previous = current;
            while (current != null)
            {
                if (current.node.key.Equals(key))
                {
                    if (current.Equals(previous))
                    {
                        Link temp = current.next;
                        current.next = null;
                        array[index] = temp;
                        count--;
                    }
                    else
                    {
                        previous.next = current.next;
                        current.next = null;
                        count--;
                    }
                    decreaseArray();
                }
                previous = current;
                current = current.next;
            }
        }

        private int getIndex(k key)
        {
            return Math.Abs(key.GetHashCode()) % array.Length;
        }

        private void increaseArray()
        {
            if ((count * 100) / array.Length <= 75) return;
            Link[] oldArray = array;
            array = new Link[array.Length * 2];
            count = 0;
            foreach (Link l in oldArray)
            {
                Link cur = l;
                while (cur != null)
                {
                    insert(cur.node.key, cur.node.value);
                    cur = cur.next;
                }
            }
        }

        private void decreaseArray()
        {
            if ((count * 100) / array.Length >= 65) return;
            Link[] oldArray = array;
            array = new Link[array.Length / 2];
            count = 0;
            foreach (Link l in oldArray)
            {
                if (l != null) insert(l.node.key, l.node.value);
            }
        }

        private class Node
        {
            public k key;
            public v value;

            public Node(k key, v value)
            {
                this.key = key;
                this.value = value;
            }
        }

        private class Link
        {
            public Node node;
            public Link next;

            public Link(Node node, Link next)
            {
                this.node = node;
                this.next = next;
            }
        }
    }
}
