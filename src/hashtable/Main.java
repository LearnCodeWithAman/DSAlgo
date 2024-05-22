package hashtable;

public class Main {

    public static void main(String[] args) {

        HashTable<String, Integer> hashtable = new HashTable<String,Integer>();

        hashtable.put("Sachin", 55);
        hashtable.put("Aman", 7);
        hashtable.put("Rohit", 23);
        hashtable.put("Vivek", 31);
        hashtable.put("Akshay", 40);

        System.out.println("Value of Key:Akshay "+ "= " +hashtable.getValueByKey("Akshay"));

        hashtable.print();
        hashtable.remove("Akshay");
        hashtable.put("Aman", 10);
        hashtable.print();



        //hashtable.remove("Vivek");
        hashtable.print();

        System.out.println(hashtable.contains("Aman"));
        System.out.println(hashtable.contains("Akshay"));


        hashtable.iterate();
    }
}
