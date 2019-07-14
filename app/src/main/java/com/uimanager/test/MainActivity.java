package com.uimanager.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.ActionBar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button button_img, button_progress_bar, button_progress_dialog;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    int[] images = new int[]{R.drawable.img_1, R.drawable.img_2};
    int currentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Log.d(TAG, "onCreate: " + getActivityName());
        init();
    }

    void init() {
        initView();
        onClick();
    }

    void initView() {
        button_img = (Button) findViewById(R.id.button_img);
        button_progress_bar = (Button) findViewById(R.id.button_progress_bar);
        button_progress_dialog = (Button) findViewById(R.id.button_progress_dialog);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    void onClick() {
        button_img.setOnClickListener(this);
        button_progress_bar.setOnClickListener(this);
        button_progress_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_img:
                //获取inputText中的数据
                //String inputText = editText.getText().toString();
                //图片切换
                if (currentImage >= (images.length - 1)) {
                    currentImage = -1;
                }
                imageView.setImageResource(images[++currentImage]);
                break;
            case R.id.button_progress_bar:
                //弹出AlertDialog
                startAlertDialog();
                break;
            case R.id.button_progress_dialog:
                startProgressDialog();
                break;
            default:
                break;
        }
    }

    public String getActivityName() {
        return getClass().getSimpleName();
    }

    public String getActivityAllName() {
        return getClass().getName();
    }


    /**
     * AlertDialog
     * 在当前的界面弹出一个对话框，这个对话框是置顶于所有界面元素之上的，能够屏蔽掉其他控件的交互能力
     * AlerDialog一般用于提示一些非常重要的内容或者警告信息
     */
    public void startAlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("注意");
        dialog.setMessage("此按钮会关闭或打开进度条！");
        dialog.setCancelable(false);
        dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //切换progressBar可见和不可见
                if (progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
    }

    public void startProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("this is a progressDialog");
        progressDialog.setMessage("please wait a minute !");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + getActivityName());
    }
}
