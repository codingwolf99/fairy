package com.qiliang.fariy.model;

import java.util.List;

/*
 * author: huangkuncan
 * date: 2024/9/14
 * desc:
 */
public class DataResponse {
    private List<DataItem> data;

    // Getters and Setters
    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "data=" + data +
                '}';
    }
}
