package com.bw.jingdong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.ShopBean;

import java.util.List;

/**
 * Created by 择木 on 2018/10/19.
 */

public class Shop_dataAdapter extends RecyclerView.Adapter<Shop_dataAdapter.ViewHolder>{
    private Context context;
    private List<ShopBean.DataBean> shoplist;

    public Shop_dataAdapter(Context context, List<ShopBean.DataBean> shoplist) {
        this.context = context;
        this.shoplist = shoplist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=View.inflate(context, R.layout.item_fenleft,null);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(shoplist.get(position).getImages()).into(holder.imgShop);
        holder.tvPrice.setText((int) shoplist.get(position).getPrice());
        holder.tvText.setText(shoplist.get(position).getSubhead());
    }


    @Override
    public int getItemCount() {
        return shoplist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imgShop;
        private final TextView tvPrice;
        private final TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
            imgShop= itemView.findViewById(R.id.img_shop_tu);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvText = itemView.findViewById(R.id.tv_text);

        }
    }
}
