using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace HashTable.Intefaces
{
    public interface HashTableInterface<in k,v>
    {
        v insert(k key, v value);
        v find(k key);
        int size();
        bool isEmpty();

        void delete(k key);
        
    }
}
