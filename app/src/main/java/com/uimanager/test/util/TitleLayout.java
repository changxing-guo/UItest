package com.uimanager.test.util;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.uimanager.test.R;

public class TitleLayout extends LinearLayout {
    private Button button_back, button_setting;

    public TitleLayout(Context context, AttributeSet att) {
        super(context, att);
        LayoutInflater.from(context).inflate(R.layout.layout_title, this);
        buttonOnClick();
    }

    public void buttonOnClick() {
        MyButtonOnClick myButtonOnClick = new MyButtonOnClick();
        button_back = (Button) findViewById(R.id.button_back);
        button_setting = (Button) findViewById(R.id.button_setting);

        button_back.setOnClickListener(myButtonOnClick);
        button_setting.setOnClickListener(myButtonOnClick);
    }

    class MyButtonOnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_back:
                    ((Activity) getContext()).finish();
                    break;
                case R.id.button_setting:
                    Toast.makeText(getContext(), "未实现", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
