package com.vamshi.proj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {


	HashMap<String, String> keyValueStore;
	private String fileLocation;

	public ConfigReader(String fileLocation) {
		
		this.fileLocation = fileLocation;
	}



	public void fileReader(){
		
		File file;
		String st;
		keyValueStore = new HashMap<>();
		file = new File(fileLocation);
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		

		while ((st = br.readLine()) != null)
			if (st.isBlank() || st.startsWith("#")) {
				System.out.println();

			} else {
				String[] valueKey = st.split("=");
				if (valueKey.length == 2) {
					keyValueStore.put(valueKey[0], valueKey[1]);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public Map<String, String> getKeyAndValues() {
		return this.keyValueStore;
	}

	public String getValueBykey(String key) {
		return keyValueStore.get(key);
	}
}
