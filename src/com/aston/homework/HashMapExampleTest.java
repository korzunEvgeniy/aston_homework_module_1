package com.aston.homework;

import org.junit.*;

public class HashMapExampleTest {

    HashMapExample<String, Integer> testMap = new HashMapExample<>();

    @Before
    public void init() {
        testMap.put("Apple", 24);
        testMap.put("Orange", 15);
        testMap.put("Pineapple", 12);
        testMap.put("Lemon", 32);
        testMap.put("Apple", 27);
        testMap.put("Banana", 18);
    }

    @Test
    public void putTest() {
        Assert.assertEquals(5, testMap.size());
        testMap.put("Berry", 30);
        Assert.assertEquals(6, testMap.size());
    }

    @Test
    public void getTest() {
        Assert.assertEquals(18, (int) testMap.get("Banana"));
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(5, testMap.size());
        testMap.remove("Banana");
        Assert.assertEquals(4, testMap.size());
    }
}
