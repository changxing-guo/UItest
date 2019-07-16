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

import com.uimanager.test.util.ListViewTest;
import com.uimanager.test.util.ListViewTestAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "8", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
    private String[] two = {"像", "我", "这", "么", "优", "秀", "的", "人", "，", "本", "来", "灿",
            "烂", "过", "一", "生", "。", "怎", "么", "20", "多", "年", "到", "头", "来"};

    ArrayAdapter<String> adapter;
    ListView listView, listView2;
    //two
    private List<ListViewTest> listViewTestList = new ArrayList<>();
    ListViewTestAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //commit 记录：ListView入门：listview的布局和点击事件
        //initListView();
        //中级：自定义Adapter
        initListView2();
    }

    //初级
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
            //String str = two[i];
            ListViewTest li = listViewTestList.get(i);
            Toast.makeText(ListViewActivity.this, li.getTwoId(), Toast.LENGTH_SHORT).show();
        }
    }

    //中级
    private void initListView2() {

        for (int i = 0; i < 25; i++) {
            //ListViewTest s1 = new ListViewTest(data[1], two[1]);
            listViewTestList.add(new ListViewTest(data[i], two[i]));
        }
        //listViewTestList.add(s1);
        adapter2 = new ListViewTestAdapter(ListViewActivity.this, R.layout.listview_test,
                listViewTestList);
        listView2 = (ListView) findViewById(R.id.list_view);
        listView2.setAdapter(adapter2);

        ListViewOnClick onClick = new ListViewOnClick();
        listView2.setOnItemClickListener(onClick);
    }

}
