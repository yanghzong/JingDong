package com.bw.jingdong.Adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.jingdong.R;
import com.bw.jingdong.bean.Fen_left;

import java.util.List;

/**
 * Created by 择木 on 2018/10/19.
 */

public class Fen_leftAdapter  extends  RecyclerView.Adapter<Fen_leftAdapter.ViewHolder>{

    private Context context;
    private List<Fen_left.DataBean>leftlist;

    public Fen_leftAdapter(Context context, List<Fen_left.DataBean> leftlist) {
        this.context = context;
        this.leftlist = leftlist;
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
            holder.tvName.setText(leftlist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return leftlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tv_name);
        }
    }
}
