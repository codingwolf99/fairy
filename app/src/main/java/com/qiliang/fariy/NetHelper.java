package com.qiliang.fariy;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qiliang.fariy.callback.NetCallback;
import com.qiliang.fariy.model.DataResponse;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
 * author: huangkuncan
 * date: 2024/9/14
 * desc:
 */
public class NetHelper {
    // 创建 OkHttpClient 实例
    OkHttpClient client;
    Activity context;

    private static volatile NetHelper instance;


    // 私有构造函数 - 防止外部实例化
    private NetHelper(Activity context) {
        // 初始化代码
        client =new OkHttpClient.Builder().build();
        this.context = context;
    }

    // 公共静态方法，供外部获取实例，并传递参数进行初始化
    public static NetHelper getInstance(Activity context) {
        if (instance == null) {
            synchronized (NetHelper.class) {
                if (instance == null) {
                    instance = new NetHelper(context);
                }
            }
        }
        // 如果实例已经存在，可以根据需求决定是否更新配置
        return instance;
    }

    // 示例方法 - 实现网络请求功能
    public void sendRequest(String url) {
        // 在这里实现具体的网络请求逻辑，例如使用 OkHttp
        System.out.println("Sending request to: " + url);
    }

    public void runGetRequest(NetCallback callback) {
        // 创建请求对象
        Request request = new Request.Builder()
                .url("https://d1.adbegin.com/applist.json")
                .build();

        // 通过 OkHttpClient 发起请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 请求失败处理
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // 请求成功，处理响应
                    final String responseData = response.body().string();
                    Gson gson = new Gson();
                    Type responseType = new TypeToken<DataResponse>() {}.getType();
                    final DataResponse res = gson.fromJson(responseData, responseType);
                    // 切换到主线程更新 UI
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           callback.onResponse(res);
                        }
                    });
                }
            }

        });
    }





}
