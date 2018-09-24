package com.collectiondatastorespringboot.neelima;
public interface CollectionDataStore<T> {
	public boolean newData(T data);

	public T get(int key);

	public boolean update(int key, T data);

	public boolean delete(int key);

	public String[][] getAll();

	public boolean contains(T data);

	public String[][] find(T data);

	public String[][] subset(int start, int end);

	public String[][] subsetids(T... args);


}