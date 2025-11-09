package com.aston.homework;

public interface MapExample<K, V> {

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    int size();
}
