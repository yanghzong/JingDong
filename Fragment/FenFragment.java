package com.bw.jingdong.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bw.jingdong.Adapter.Fen_leftAdapter;
import com.bw.jingdong.Adapter.Fen_rightAdapter;
import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.Fen_left;
import com.bw.jingdong.bean.Fen_right;
import com.bw.jingdong.bean.Shou_ninebean;
import com.bw.jingdong.utils.HttpUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 择木 on 2018/10/16.
 */

public class FenFragment extends Fragment {
    public static final String TAG = "FenFragment";
    private RecyclerView rvLeft;
    private RecyclerView rvRight;
    private Fen_leftAdapter adapter;
    private Fen_rightAdapter adapter1;
    private List<Fen_left.DataBean> leftlist;
    private List<Fen_right.DataBean.ListBean> rightlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_fen, container, false);
        rvLeft = v.findViewById(R.id.rv_left);
        rvRight = v.findViewById(R.id.rv_right);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvLeft.setLayoutManager(layoutManager);

        leftlist = new ArrayList<>();
        adapter = new Fen_leftAdapter(getActivity(), leftlist);
        rvLeft.setAdapter(adapter);
        Type type = new TypeToken<Fen_left>() {
        }.getType();
        HttpUtils.getInstance().get("https://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void success(Object obj) {
                Fen_left fenLeft = (Fen_left) obj;
                if (fenLeft != null) {
                    List<Fen_left.DataBean> data = fenLeft.getData();
                    leftlist.clear();
                    leftlist.addAll(data);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void failure(Exception e) {

            }
        }, type);

        RecyclerView.LayoutManager  gridLayoutManager= new GridLayoutManager(getActivity(),1);
        rvRight.setLayoutManager(gridLayoutManager);

        rightlist = new ArrayList<>();
        adapter1 = new Fen_rightAdapter(getActivity(), rightlist);
        rvRight.setAdapter(adapter1);
        Type type1 = new TypeToken<Fen_right>() {
        }.getType();
        HttpUtils.getInstance().get("https://www.zhaoapi.cn/product/getProductCatagory?cid=1", new ICallBack() {


            @Override
            public void success(Object obj) {
                Fen_right fenRight = (Fen_right) obj;
                if (fenRight != null) {
                    List<Fen_right.DataBean> data = fenRight.getData();
                    rightlist.clear();
                    rightlist.addAll(data.get(0).getList());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void failure(Exception e) {

            }
        }, type1);
    }
}




