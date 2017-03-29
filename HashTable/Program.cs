using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HashTable.HashTableServices;

namespace HashTable
{
    public class Program
    {
        public static void Main(string[] args)
        {
            HashMapLink<string, int> hta = new HashMapLink<string, int>();
            for (int i = 0; i < 1000; i += 2) 
            {
                hta.insert("#" + i, i);
            }

            hta.delete("#906");

            for (int i = 0; i < 1000; i++)
            {
                Console.WriteLine(hta.find("#" + i));
            }

            while (true)
            {
                
            }
        }
    }
}
