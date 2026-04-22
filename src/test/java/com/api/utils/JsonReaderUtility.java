package com.api.utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderUtility {

	public static <T> Iterator<T> loadJson(String fileName, Class<T[]> clazz) {

		try {
			InputStream load = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

			if (load == null) {
				throw new RuntimeException("File not found: " + fileName);
			}

			ObjectMapper objectMapper = new ObjectMapper();

			T[] dataArray = objectMapper.readValue(load, clazz);

			List<T> dataList = Arrays.asList(dataArray);

			return dataList.iterator();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}