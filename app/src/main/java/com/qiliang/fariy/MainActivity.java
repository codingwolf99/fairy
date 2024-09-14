package com.qiliang.fariy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qiliang.fariy.callback.NetCallback;
import com.qiliang.fariy.list.CardAdapter;
import com.qiliang.fariy.model.DataResponse;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.qiliang.fariy.R.layout.activity_main);
       recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(this,null);
        recyclerView.setAdapter(cardAdapter);
        NetHelper.getInstance(this).runGetRequest(new NetCallback() {
           @Override
           public void onResponse(DataResponse response) {
               Log.d("hkc_test", "onResponse: "+response.toString());
               cardAdapter.setData(response.getData());
           }
       });

//        Picasso.get().load(imageUrl).into(imageView);

    }
}