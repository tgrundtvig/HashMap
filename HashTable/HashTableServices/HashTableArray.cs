using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HashTable.Intefaces;

namespace HashTable.HashTableServices
{
    public class HashTableArray<k, v> : HashTableInterface<k, v>
    {
        private Node[] arr;
        private int count;

        public HashTableArray()
        {
            arr = new Node[8];
            count = 0;
        }

        public v insert(k key, v value)
        {
            int index = getIndex(key);

            while (true)
            {
                if (arr[index] == null)
                {
                    arr[index] = new Node(key, value);
                    ++count;
                    increaseArr();
                    return default(v);
                }

                if (arr[index].key.Equals(key))
                {
                    v oldValue = arr[index].value;
                    arr[index] = new Node(key, value);
                    return oldValue;
                }

                index = increaseIndex(index);
            }
        }

        public v find(k key)
        {
            int index = getIndex(key);
            while (true)
            {
                if (arr[index] == null) return default(v);
                if (arr[index].key.Equals(key)) return arr[index].value;
                index = increaseIndex(index);
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
            while (true)
            {
                if (arr[index] == null) break;
                if (arr[index].key.Equals(key))
                {
                    arr[index] = null;
                    restructureArray(index + 1);
                    count--;
                    decreseArr();
                    break;
                }
                index = increaseIndex(index);
            }
        }

        private int getIndex(k key)
        {
            return Math.Abs(key.GetHashCode()) % arr.Length;
        }

        private int increaseIndex(int index)
        {
            ++index;
            if (index >= arr.Length) index = 0;
            return index;
        }

        private void increaseArr()
        {
            if ((count * 10) / arr.Length <= 4) return;
            Node[] oldArray = arr;
            arr = new Node[arr.Length * 2];
            count = 0;
            foreach (Node n in oldArray)
            {
                if (n != null) insert(n.key, n.value);
            }
        }

        private void decreseArr()
        {
            if ((count * 10) / arr.Length >= 1) return;
            Node[] oldArray = arr;
            arr = new Node[arr.Length / 2];
            count = 0;
            foreach (Node n in oldArray)
            {
                if (n != null) insert(n.key, n.value);
            }
        }

        private void restructureArray(int index)
        {
            Node[] nodes = new Node[arr.Length];
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[index] == null) break;
                nodes[i] = arr[index];
                arr[index] = null;
                index = increaseIndex(index);
            }

            foreach (Node n in nodes)
            {
                if (n != null) insert(n.key, n.value);
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
    }
}
