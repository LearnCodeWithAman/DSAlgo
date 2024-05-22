package hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class HashTable<K,V> implements Iterable<Entry<K,V>>{

    private ArrayList<HashNode<K,V>> bucket;

    private int numberOfBuckets;

    private int size;

    public HashTable() {

        bucket = new ArrayList<>();
        numberOfBuckets = 10;
        size = 0;

        for(int i=0; i<numberOfBuckets; i++)
            bucket.add(null);
    }


    private Entry[] entryset;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    //insert an Node in the hashtable
    public void put(K key, V value) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K,V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = bucket.get(bucketIndex);
        HashNode<K,V> newNode = new HashNode<K,V>(key, value, hashCode);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);
        size++;

        //managing threshold
        if ((size*1.0) / numberOfBuckets >= 0.7) {
            ArrayList<HashNode<K,V>> temp = bucket;
            bucket = new ArrayList<>();
            numberOfBuckets = 2*numberOfBuckets;
            size = 0;
            for (int i=0; i<numberOfBuckets; i++)
                bucket.add(null);
            for (HashNode<K,V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public int getBucketIndex(K key) {

        int hashCode = hashCode(key);
        int index = hashCode % numberOfBuckets;
        index = index<0 ? index*-1 : index;
        return index;
    }

    //Get the value against a key
    public V getValueByKey(K key) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K,V> head = bucket.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    //Remove a node from hashtable
    public V remove(K key) {

        if(size() == 0){
            System.out.println("Hash Table is empty***");
            return null;
        }

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K,V> head = bucket.get(bucketIndex);

        HashNode<K,V> prev = null;
        while(head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                break;

            prev = head;
            head = head.next;
        }

        if(head == null)
            return null;

        if(prev != null)
            prev.next = head.next;
        else
            bucket.set(bucketIndex,head.next);

        size--;
        return head.value;
    }

    //Traverse the HashTable
    public void print() {

        System.out.println("Printing Hash Table");

        if(size() == 0){
            System.out.println("Hash Table is empty***");
            return;
        }

        System.out.println("Key : Value");
        for(int bucketIndex=0; bucketIndex<numberOfBuckets; bucketIndex++) {

            HashNode<K,V> head = bucket.get(bucketIndex);
            while(head != null) {
                System.out.println(head.key +" : "+head.value);
                head = head.next;
            }
        }
    }

    //Check if a node is present in the HashTable
    public boolean contains(K key) {

        if(size() == 0){
            System.out.println("Hash Table is empty***");
            return false;
        }

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        HashNode<K,V> head = bucket.get(bucketIndex);

        while(head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return true;

            head = head.next;
        }

        return false;
    }

    public void entrySet() {

        boolean flag;
        int x=-1;
        entryset = new Entry[size];
        for(int bucketIndex=0; bucketIndex<numberOfBuckets; bucketIndex++) {

            HashNode<K,V> head = bucket.get(bucketIndex);
            while(head != null) {

                flag = false;
                for(int i=0; i<entryset.length; i++){
                    if(entryset[i]!=null && head.key==entryset[i].key && head.value==entryset[i].value){
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    entryset[++x] = new Entry<>(head.key, head.value);

                head = head.next;
            }
        }
    }

    @Override
    public Iterator<Entry<K,V>> iterator() {

        Iterator<Entry<K,V>> iterator = new Iterator<Entry<K,V>>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return currentIndex<entryset.length;
            }

            @Override
            public Entry<K, V> next() {
                if(hasNext())
                    return entryset[currentIndex++];
                return null;
            }
        };
        return iterator;
    }

    //Iterate the HashTable
    public void iterate() {

        System.out.println("HashTable Iteration ----");
        entrySet();

        if(isEmpty()) {
            System.out.println("HashTable is Empty");
            return;
        }

        Iterator<Entry<K,V>> iterator = iterator();

        while(iterator.hasNext()) {
            Entry<K,V> entry = iterator.next();
            System.out.println(entry.key + " - " +entry.value);
        }
    }
}
