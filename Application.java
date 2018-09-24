package com.collectiondatastorespringboot.neelima;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//java -Dspring.profiles.active=dev -jar example-springboot-profiles-variables-0.0.1-SNAPSHOT.jar
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${configuration.datastore1:}")
	private String collectiondev;
	CollectionDataStore collectiondata = null;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("collectiondata: " + collectiondev);
		if (collectiondev.equals("HashMapStore-dev")) {

			System.out.println(" hashmap used");
		}

		else if (collectiondev.equals("Dictionary-stage")) {
			System.out.println(" dictionary used");
		}
		String datastore = args[0];
		String functions = args[1];
		HashMapStore<String> hashMap = new HashMapStore<String>();
		DictionaryStore<String> dictionary = new DictionaryStore<String>();

		hashMap.newData("FIRST VALUE");
		hashMap.newData("SECOND VALUE");
		hashMap.newData("THIRD VALUE");

		if (datastore.equals("HashMapStore")) {
			collectiondata = hashMap;

		} else if (datastore.equals("DictionaryStore")) {
			collectiondata = dictionary;
		}

		if (functions.equals("newdata")) {
			String key = args[2];
			int k = Integer.parseInt(key);
			String Data = args[3];
			collectiondata.newData(Data);

			System.out.println("Value stored:" + Data);
		}

		else if (functions.equals("update")) {

			String key = args[2];
			int k = Integer.parseInt(key);
			String Data = args[3];
			collectiondata.update(k, Data);
			System.out.println("Updated Value: " + hashMap.get(k));
		}

		else if (functions.equals("get")) {
			String key = args[2];
			int k = Integer.parseInt(key);
			collectiondata.get(k);
			System.out.println(hashMap.get(k));

		} else if (functions.equals("delete")) {
			String key = args[2];
			int k = Integer.parseInt(key);
			collectiondata.delete(k);
			System.out.println("Deleting Value: " + hashMap.get(k));
		} else if (functions.equals("getall")) {
			
			collectiondata.getAll();
		
			System.out.println(hashMap.getAll());

		} else if (functions.equals("contains")) {
			String Data = args[2];
			collectiondata.contains(Data);
			System.out.println(hashMap.contains(Data));

		} /*
			 * else if (functions.equals("find")) { String Data = args[2];
			 * collectiondata.find(Data); System.out.println("");
			 * 
			 * } else if (functions.equals("subset")) { String key = args[2]; int k =
			 * Integer.parseInt(key); collectiondata.subset(k, k);
			 * 
			 * } else if (functions.equals("subsetids")) { String key = args[2]; int k =
			 * Integer.parseInt(key); collectiondata.subsetids(k, k, k, k); }
			 */

	}
}
