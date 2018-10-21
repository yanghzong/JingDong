package com.bw.jingdong.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bw.jingdong.Adapter.Fen_rightAdapter;
import com.bw.jingdong.Adapter.Shop_dataAdapter;
import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.LoginActivity;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.Fen_right;
import com.bw.jingdong.bean.ShopBean;
import com.bw.jingdong.utils.HttpUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 择木 on 2018/10/16.
 */

public class ShopFragment extends Fragment implements View.OnClickListener {

    private Button btnLogin;
    private RecyclerView rvShop;
    private Shop_dataAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.item_shop,container,false);
        btnLogin = v.findViewById(R.id.btn_login);
        rvShop = v.findViewById(R.id.rv_shop);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnLogin.setOnClickListener(this);

        RecyclerView.LayoutManager  gridLayoutManager= new GridLayoutManager(getActivity(),1);
        rvShop.setLayoutManager(gridLayoutManager);

        final List<ShopBean.DataBean> shoplist= new ArrayList<>();
        adapter = new Shop_dataAdapter(getActivity(), shoplist);
        rvShop.setAdapter(adapter);
        Type type = new TypeToken<ShopBean>() {
        }.getType();
        HttpUtils.getInstance().get("https://www.zhaoapi.cn/product/getProducts?pscid=2", new ICallBack() {


            @Override
            public void success(Object obj) {
                ShopBean shopBean = (ShopBean) obj;
                if (shopBean != null) {
                    List<ShopBean.DataBean> data = shopBean.getData();
                    shoplist.clear();
                    shoplist.addAll(data);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void failure(Exception e) {

            }
        }, type);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
