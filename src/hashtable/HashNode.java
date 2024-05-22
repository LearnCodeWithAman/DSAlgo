package hashtable;

class HashNode<K,V> {

    K key;
    V value;
    HashNode<K,V> next;

    final int hashCode;

    public HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
        this.next = null;
    }
}

