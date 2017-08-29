package com.muzi.lasyloadfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by muzi on 2017/8/29.
 * 727784430@qq.com
 */

public class ExampleFragment extends LazyLoadFragment {

    private Context context;
    private TextView textView;
    private ProgressBar progressBar;
    private Button button;

    private String string;

    public ExampleFragment() {
    }

    public ExampleFragment(String string) {
        this.string = string;
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment;
    }

    @Override
    protected void finishCreateView(View view) {
        context = getActivity();
        textView = findViewById(R.id.textview);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, SecondActivity.class));
            }
        });
    }

    @Override
    protected void lazyLoad() {
        //请求网络，获取数据
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                textView.setText(string);
            }
        }, 1000);
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        //取消网络请求,并清空数据
        textView.setText(null);
        progressBar.setVisibility(View.VISIBLE);
    }
}
