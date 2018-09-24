package com.collectiondatastorespringboot.neelima;

import java.util.*;

public class HashMapStore<T> implements CollectionDataStore<T> {
	HashMap<Integer, T> hashMap = new HashMap<Integer, T>();

	public boolean newData(T data) {
		int key = hashMap.size() + 1;
		hashMap.put(key, data);
		return false;
	}

	public T get(int key) {
		return hashMap.get(key);
	}

	public boolean update(int key, T data) {
		for (Integer key1 : hashMap.keySet()) {
			if (key1 == key) {
				hashMap.replace(key, data);
			}
		}

		return false;
	}

	public boolean delete(int key) {
		for (Integer del : hashMap.keySet()) {
			if (del == key) {
				 hashMap.get(key);
				 
			}
		}
		return false;
		
	}


	@Override
	public String[][] getAll() {
		String values[][] = new String[2][2];
		for (int i = 0; i < hashMap.size(); i++) {
			values[i][0] = (String) hashMap.get(i);
		}

		return values;
	
	}


	public boolean contains(T data) {
		if(hashMap.containsValue(data)) {
			return true;
		}

		return false;
	}

	public String[][] find(T data) {

		return null;
	}

	public String[][] subset(int start, int end) {

		return null;
	}

	public String[][] subsetids(T... args) {

		return null;
	}

	



	
}
