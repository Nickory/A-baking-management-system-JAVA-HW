package DataStructure;

import BakingInformationSystem.BakingSystem;

public class HashTable<K, V> {
    private static final int CAPACITY = 32;
    private Entry<K, V>[] table;
    private int size;

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        this.table = new Entry[CAPACITY];
        this.size = 0;
    }

    private int hash(K key) {
        return (int)(BakingSystem.abs(key.hashCode() % table.length));
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
        }
        else {

            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = table[index];
            table[index] = newEntry;
        }
        size++;
        if (size > table.length * 0.75) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);

        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;

        }
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void resize() {
        Entry<K, V>[] newTable = new Entry[table.length * 2];
        size = 0;

        for (Entry<K, V> kvEntry : table) {
            Entry<K, V> current = kvEntry;
            while (current != null) {
                Entry<K, V> entry = current;
                current = current.next;

                int newIndex = entry.key.hashCode() % newTable.length;
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                size++;
            }
        }

        table = newTable;
    }

    public void updateWithNewKey(K oldKey, K newKey) {
        int oldIndex = hash(oldKey);
        Entry<K, V> current = table[oldIndex];
        Entry<K, V> prev = null;

        // Find the entry with the old key
        while (current != null) {
            if (current.key.equals(oldKey)) {
                current.key = newKey;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void clear() {
        table = new Entry[CAPACITY];
        size = 0;
    }
}
