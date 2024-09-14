package com.qiliang.fariy.list;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qiliang.fariy.R;
import com.qiliang.fariy.model.DataItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<DataItem> cardItemList;
    private Context context;

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewImage;
        public ImageView imageViewLogo;
        public TextView textViewTitle;
        public TextView textViewDescription;
        public TextView textViewRating;
        public TextView textViewRatingCount;

        public CardViewHolder(View itemView) {
            super(itemView);
            imageViewImage = itemView.findViewById(R.id.image);
            imageViewLogo = itemView.findViewById(R.id.logo);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewDescription = itemView.findViewById(R.id.description);
            textViewRating = itemView.findViewById(R.id.rating);
            textViewRatingCount = itemView.findViewById(R.id.rating_count);

        }



    }
    private void jumpH5(String url){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            // 指定 Chrome 浏览器的包名
            intent.setPackage("com.android.chrome");
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // 如果没有安装 Chrome 浏览器，使用默认浏览器打开链接
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        }
    }

    public CardAdapter(Context context, List<DataItem> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    public void setData(List<DataItem> cardItemList) {
        this.cardItemList = cardItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        DataItem currentItem = cardItemList.get(position);

        Picasso.get().load(currentItem.getImage()).fit()
                .transform(new RoundedCornersTransformation(16, 0)) .into(holder.imageViewImage);
        Picasso.get().load(currentItem.getLogo()).into(holder.imageViewLogo);
        holder.textViewTitle.setText(currentItem.getTitle());
        holder.textViewDescription.setText(currentItem.getDescription());
        holder.textViewRating.setText(String.valueOf(currentItem.getRating()));
        holder.textViewRatingCount.setText("(" + currentItem.getRating_count() + ")");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpH5(currentItem.getLanding_page());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItemList == null ? 0 : cardItemList.size();
    }
}
