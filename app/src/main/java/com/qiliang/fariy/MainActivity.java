package com.qiliang.fariy;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.qiliang.fariy.callback.NetCallback;
import com.qiliang.fariy.model.DataResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.qiliang.fariy.R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(com.qiliang.fariy.R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       NetHelper.getInstance(this).runGetRequest(new NetCallback() {
           @Override
           public void onResponse(DataResponse response) {
               Log.d("hkc_test", "onResponse: "+response.toString());
           }
       });

//        Picasso.get().load(imageUrl).into(imageView);

    }
}