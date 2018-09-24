package com.collectiondatastorespringboot.neelima;

import java.util.Hashtable;
import java.util.Dictionary;

public class DictionaryStore<T> implements CollectionDataStore<T> {
	Dictionary<Integer, T> dictionary = new Hashtable<Integer, T>();

	public boolean newData(T Data) {
		int key = dictionary.size() + 1;
		if (Data != null) {
			dictionary.put(key, Data);
		}
		System.out.println("");
		return false;
	}

	public T get(int key) {

		return dictionary.get(key);
	}

	public boolean update(int key, T data) {
		for (Integer key1 : ((Hashtable<Integer, T>) dictionary).keySet()) {
			if (key1 == key) {
				dictionary.put(key1, data);
			}
		}
		return false;
	}

	public boolean delete(int key) {
		for (Integer del : ((Hashtable<Integer, T>) dictionary).keySet()) {
			if (del == key) {
				dictionary.remove(key);
			}
		}
		return false;
	}

	public String[][] getAll() {
		for (int key : ((Hashtable<Integer, T>) dictionary).keySet()) {
		}
		return null;
	}

	public boolean contains(T data) {
		((Hashtable<Integer, T>) dictionary).containsValue(data);

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
