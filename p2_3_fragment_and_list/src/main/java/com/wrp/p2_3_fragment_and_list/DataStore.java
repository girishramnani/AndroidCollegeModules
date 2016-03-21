package com.wrp.p2_3_fragment_and_list;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Girish on 26-02-2016.
 */
public class DataStore {

    public Map<String,String[]> contactData;
    private static DataStore ourInstance = new DataStore();

    public static DataStore getInstance() {
        return ourInstance;
    }

    private DataStore() {

        contactData = new TreeMap<>();
        contactData.put("A",new String[]{
                "Ashok",
                "Anil",
                "Akshay"
        });
        contactData.put("B",new String[]{
                "Babu",
                "Bhavesh",
                "Bhavin"
        });

    }
    public String[] getKeySet(){
        String[] data = new String[contactData.size()];
        Iterator<String> iterator =contactData.keySet().iterator();
        for(int i = 0;i< contactData.size();i++){
            data[i] = iterator.next();
        }
        return data;
    }
}
