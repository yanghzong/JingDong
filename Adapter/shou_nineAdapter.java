package com.bw.jingdong.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.Shou_ninebean;

import java.util.List;


/**
 * Created by 择木 on 2018/10/17.
 */

public class shou_nineAdapter extends BaseAdapter {
    private Context context;
    private List<Shou_ninebean.DataBean> ninelist;
    private ImageView imgShow;
    private TextView tvTitle;

    public shou_nineAdapter(Context context, List<Shou_ninebean.DataBean> ninelist) {
        this.context = context;
        this.ninelist = ninelist;
    }

    @Override
    public int getCount() {
        return ninelist.size();
    }

    @Override
    public Object getItem(int position) {
        return ninelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item_nine,null);
            holder.imgShow = convertView.findViewById(R.id.img_show);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);

          convertView.setTag(holder);


        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(ninelist.get(position).getIcon()).into(holder.imgShow);
        holder.tvTitle.setText(ninelist.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        ImageView imgShow;
        TextView tvTitle;
    }
  /* private Context context;
   private List<Shou_ninebean.DataBean> ninelist;
    private ViewHolder holder1;

    public shou_nineAdapter(Context context, List<Shou_ninebean.DataBean> ninelist) {
        this.context = context;
        this.ninelist = ninelist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder=null;
        View v=View.inflate(context,R.layout.item_nine,null);
         holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder = (ViewHolder) holder;
        Glide.with(context).load(ninelist.get(position).getIcon()).into(holder1.imgShow);
        holder1.tvName.setText(ninelist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return ninelist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgShow;
        private TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            // 类似于BaseAdapter中的holder.txtTitle = convertView.findViewById()
           TextView tvName = itemView.findViewById(R.id.tv_title);
           ImageView imgShow = itemView.findViewById(R.id.img_show);
        }
    }*/
/*   *//* private Context context;
    private List<Shou_ninebean.DataBean> list;


    public shou_nineAdapter(Context context, List<Shou_ninebean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    *//**//*//**//*//* 创建ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;




    }*//**//*
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.item_nine, null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Glide.with(context).load(list.get(position).getIcon()).into(holder.imgShow);
       holder.tvTitle.setText(list.get(position).getName());
    }




    // 获取条目的数量，类似于BaseAdapter中的getCount方法
    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgShow;
        private TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            // 类似于BaseAdapter中的holder.txtTitle = convertView.findViewById()
            tvTitle = itemView.findViewById(R.id.tv_title);
            imgShow = itemView.findViewById(R.id.img_show);
        }


    }*/

}
