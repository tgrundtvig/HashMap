package hashmap;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMapLink<>();

        for (int i = 0; i < 1000; i += 2) {
            String s = "#" + i;
            myMap.put(s, i);
        }

        System.out.println("Size: " + myMap.size());

        for (int i = 0; i < 1000; ++i) {
            String s = "#" + i;
            Integer value = myMap.get(s);
            System.out.println("Key: " + s + " Value: " + value);
        }

        System.out.println(myMap.get("#996"));
        myMap.remove("#996");
        System.out.println(null == myMap.get("#996") ? "Entry deleted" : "Entry not deleted");
    }
}
