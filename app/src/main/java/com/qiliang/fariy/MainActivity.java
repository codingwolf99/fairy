package com.qiliang.fariy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qiliang.fariy.callback.NetCallback;
import com.qiliang.fariy.list.CardAdapter;
import com.qiliang.fariy.list.SpacesItemDecoration;
import com.qiliang.fariy.model.DataResponse;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.qiliang.fariy.R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(this, null);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration((int) getResources().getDimension(R.dimen.list_gap)));
        NetHelper.getInstance(this).runGetRequest(new NetCallback() {
            @Override
            public void onResponse(DataResponse response) {
                cardAdapter.setData(response.getData());
            }
        });

    }

}