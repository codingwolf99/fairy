package com.qiliang.fariy.list;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;



public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private final int space ;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        // 为每个项设置向下的间距
        outRect.bottom = space;
    }
}

