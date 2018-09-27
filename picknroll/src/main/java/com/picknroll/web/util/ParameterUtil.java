package com.picknroll.web.util;

import java.util.HashMap;
import java.util.Map;

public class ParameterUtil {

	public static Map<String, String> mapping(String... strs) {
		Map<String, String> map = new HashMap<String, String>();
		int size = strs.length;
		String pName = "";
		for (int i = 0; i < size; i++) {
			if (i % size == 0)
				pName = strs[i];
			else {
				map.put(pName, strs[i]);
				pName = "";
			}
		}
		return map;
	}

}