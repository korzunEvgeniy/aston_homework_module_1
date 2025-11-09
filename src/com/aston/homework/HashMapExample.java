package com.aston.homework;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class HashMapExample<K, V> implements MapExample<K, V>, Serializable {

    private static class Entry<K, V> {

        final K key;
        V value;
        Entry<K, V> next;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }
    private static final int DEFAULT_CAPACITY = 16;

    private final Entry<K, V>[] table;
    private int size = 0;

    public HashMapExample() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    private int hash(Object key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        if(table[index] == null) {
            table[index] = newEntry;
            size++;
        } else {
            Entry<K, V> current = table[index];
            Entry<K, V> next = null;
            while (current != null) {
                if(current.key.hashCode() == key.hashCode() && Objects.equals(current.key, key)) {
                    current.value = value;
                    return;
                }
                next = current;
                current = newEntry;
                size++;
            }
            next.next = newEntry;
            size++;
        }
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> current = table[index];
        Entry<K, V> next = null;
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (next == null) {
                    table[index] = current.next;
                } else {
                    next.next = current.next;
                }
                size--;
                return;
            }
            next = current;
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(table) + " size " + size;
    }

    @Override
    public int size() {
        return size;
    }
}
