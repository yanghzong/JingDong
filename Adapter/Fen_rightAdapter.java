package com.bw.jingdong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.Fen_right;

import java.util.List;

/**
 * Created by 择木 on 2018/10/18.
 */

public class Fen_rightAdapter extends RecyclerView.Adapter<Fen_rightAdapter.ViewHolder> {

    private Context context;
    private List<Fen_right.DataBean.ListBean> rightlist;

    public Fen_rightAdapter(Context context, List<Fen_right.DataBean.ListBean> rightlist) {
        this.context = context;
        this.rightlist = rightlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=View.inflate(context, R.layout.item_fenright,null);
        ViewHolder holder=new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(rightlist.get(position).getIcon()).into(holder.imgRight);
        holder.tvRightName.setText(rightlist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return rightlist.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgRight;
        private final TextView tvRightName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgRight= itemView.findViewById(R.id.img_right);
            tvRightName = itemView.findViewById(R.id.tv_right_name);
        }
    }
}
