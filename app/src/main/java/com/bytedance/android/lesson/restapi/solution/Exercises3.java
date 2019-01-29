package com.bytedance.android.lesson.restapi.solution;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

import com.bytedance.android.lesson.restapi.solution.model.Message;
import com.bytedance.android.lesson.restapi.solution.model.PullParser;


public class Exercises3 extends AppCompatActivity {

    private static final String TAG = "exexexex";
    private static final int NUM_LIST_ITEMS = 30;

    private  MyAdapter myAdapter;
    private RecyclerView mNumView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        mNumView = findViewById(R.id.rv_list);

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        LayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNumView.setLayoutManager(LayoutManager);

        List<Message> messages = null;
        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        myAdapter = new MyAdapter( messages);
        mNumView.setAdapter(myAdapter);
    }

}
