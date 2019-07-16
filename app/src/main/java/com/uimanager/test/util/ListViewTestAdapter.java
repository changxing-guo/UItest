package com.uimanager.test.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.uimanager.test.R;

import java.util.List;

public class ListViewTestAdapter extends ArrayAdapter<ListViewTest> {
    private int resourceId;

    public ListViewTestAdapter(Context context, int textViewResourceId,
                               List<ListViewTest> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        ListViewTest listViewTest = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = (TextView) view.findViewById(R.id.one);
            viewHolder.textView2 = (TextView) view.findViewById(R.id.two);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText(listViewTest.getOneId());
        viewHolder.textView2.setText(listViewTest.getTwoId());
        return view;
    }
    class ViewHolder{
        TextView textView1;
        TextView textView2;
    }
}
