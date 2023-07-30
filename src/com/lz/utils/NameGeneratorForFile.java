package com.lz.utils;


	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;

	public class NameGeneratorForFile {
	    private static final String SURNAME_FILE = "surnames.txt"; // 姓氏列表的文本文件路径
	    
	    private static List<String> surnames = new ArrayList<>();
	    private static final Random random = new Random();
	    
	    static {
	        loadSurnames();
	    }
	    
	    private static void loadSurnames() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(SURNAME_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                surnames.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static String generateFullName() {
	        String surname = getRandomSurname();
	        String givenName = getRandomGivenName();
	        
	        return givenName + " " + surname;
	    }
	    
	    private static String getRandomSurname() {
	        int index = random.nextInt(surnames.size());
	        return surnames.get(index);
	    }
	    
	    private static String getRandomGivenName() {
	        // 生成随机的名字逻辑
	        // ...
	        return "John"; // 示例中使用固定的名字
	    }
	    
	    public static void main(String[] args) {
	        for (int i = 0; i < 100; i++) {
	            String fullName = generateFullName();
	            System.out.println(fullName);
	        }
	    }
	}

