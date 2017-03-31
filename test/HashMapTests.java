

import hashmap.HashMapLink;
import hashmap.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.nullValue;


public class HashMapTests {
    
    public HashMapTests() {
    }
    

    @Test
    public void testHashMapLink() {
        
        Map<String, Integer> myMap = new HashMapLink<>();
        
        String keyToRemove = "#5";
        int expectedRemovedValue = 5;
        int addedKey;
        for(int i = 0; i < 10; i++)
        {
            String key = "#" + i;
            myMap.put(key, i);
            System.out.println("get by key: " + key + ", value: " + myMap.get(key));
        }

        MatcherAssert.assertThat(myMap.get(keyToRemove), Matchers.is(5));
        myMap.remove(keyToRemove);

        MatcherAssert.assertThat(myMap.get(keyToRemove), Matchers.is(nullValue()));
    }
}
