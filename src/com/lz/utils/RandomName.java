package com.lz.utils;

	import java.util.Random;

import net.bytebuddy.asm.Advice.This;

	public class RandomName {
	    private static final String[] letters = {
	        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
	        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	    };
	    
	    private static final Random random = new Random();
	    
	    public static String generatefirstName() {
	        String firstName = generateName();
	        
	        return firstName;
	    }
	    public static String generatelastName() {
	        String lastName = generateName();
	        
	        return lastName;
	    }
	    public static String generateFullName() {
	        String FullName = generatefirstName() + generatelastName();
	        
	        return FullName;
	    }
	    
	    private static String generateName() {
	        StringBuilder nameBuilder = new StringBuilder();
	        int nameLength = random.nextInt(5) + 4; // 随机生成名字长度为 4-8
	        
	        for (int i = 0; i < nameLength; i++) {
	            int randomIndex = random.nextInt(26);
	            String letter = letters[randomIndex];
	            nameBuilder.append(letter);
	        }
	        
	        return nameBuilder.toString();
	    }
	    
	    public static void main(String[] args) {
	        for (int i = 0; i < 100; i++) {
	            String fullName = generateFullName();
	            System.out.println(fullName);
	        }
	    }
	}

