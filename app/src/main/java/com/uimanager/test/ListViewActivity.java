package com.uimanager.test;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.AdvertiseData;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initListView();
    }

    void initListView() {
        adapter = new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_list_item_1, data);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        ListViewOnClick onClick = new ListViewOnClick();
        listView.setOnItemClickListener(onClick);
    }

    class ListViewOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String str = data[i] + data[i] +data[i];
            Toast.makeText(ListViewActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    }
}
