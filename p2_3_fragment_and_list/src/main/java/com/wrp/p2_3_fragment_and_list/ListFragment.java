package com.wrp.p2_3_fragment_and_list;

import android.app.Fragment;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;

import java.util.Arrays;

/**
 * Created by Girish on 26-02-2016.
 */
public class ListFragment extends Fragment {

    ListView listView;
    View fragment_view;
    String[] dataSet;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragment_view = inflater.inflate(R.layout.list_fragment, container);
        String data;
        try{
            Bundle bundle = getArguments();
            data = bundle.getString("data");
        }
        catch (NullPointerException exception){
            data = "A";
        }

        Log.i("FRAGMENTLIST",data);

        dataSet = DataStore.getInstance().contactData.get(data);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(fragment_view.getContext(),android.R.layout.simple_list_item_1,
                dataSet);
        listView = (ListView) fragment_view.findViewById(R.id.contactList);

        listView.setAdapter(adapter);

        return fragment_view;
    }
    public void changeData(String data,Context context){
        String[] dataStore = DataStore.getInstance().contactData.get(data);
        Log.i("FRAGMENTLIST", Arrays.toString(dataStore));

        ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
        dataStore[0]="Girish";
        adapter.notifyDataSetChanged();
//        adapter.clear()
//        adapter.notifyDataSetChanged();


    }
}
