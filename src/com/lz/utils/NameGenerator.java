package com.lz.utils;

import java.util.Random;

public class NameGenerator {
    private static final String[] surnames = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"
        // 添加更多的姓氏
    };
    
    private static final String[] givenNames = {
        "James", "John", "Robert", "Michael", "William", "David", "Joseph", "Charles", "Daniel", "Christopher"
        // 添加更多的名字
    };
    
    private static final Random random = new Random();
    
    public static String generateSurnName() {
        String surname = getRandomElement(surnames);
        
        return surname;
    }
    public static String generateGivenName() {
        String givenName = getRandomElement(givenNames);
        
        return givenName;
    }
    
    private static String getRandomElement(String[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String fullName = generateSurnName() + generateGivenName();
            System.out.println(fullName);
        }
    }
}
