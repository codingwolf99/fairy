package com.qiliang.fariy.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qiliang.fariy.R;
import com.qiliang.fariy.model.DataItem;

import java.util.List;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<DataItem> cardItemList;

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewDescription;

        public CardViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.item_tv);
//            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }

    public CardAdapter(List<DataItem> cardItemList) {
        this.cardItemList = cardItemList;
    }

    public void setData(List<DataItem> cardItemList){
        this.cardItemList = cardItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        DataItem currentItem = cardItemList.get(position);
        holder.textViewTitle.setText(currentItem.getTitle());
//        holder.textViewDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        if(cardItemList == null){
            return  0;
        }
        return cardItemList.size();
    }
}
