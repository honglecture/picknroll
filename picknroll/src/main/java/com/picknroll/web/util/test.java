package com.picknroll.web.util;

import java.util.HashMap;
import java.util.Map;

public class test {
	
	public static Map<String, String> mapping(String... strs) {
		Map<String, String> map = new HashMap<String, String>();
		int size = strs.length;
		String pName = "";
		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
				pName = strs[i];
			}
			else {
				map.put(pName, strs[i]);
				pName = "";
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		Map<String,String> map =  mapping("id", "flwj", "password", "1", "pp", "qq");
		for(String key : map.keySet()) {
			System.out.print(key + " : ");
			System.out.print(map.get(key));
			System.out.println();
		}
		
		

	}

}
