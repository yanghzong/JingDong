package com.bw.jingdong.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.jingdong.Adapter.shou_nineAdapter;
import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.R;
import com.bw.jingdong.bean.Shou_ninebean;
import com.bw.jingdong.utils.HttpUtils;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 择木 on 2018/10/16.
 */

public class ShouFragment extends Fragment {
    private List<Shou_ninebean.DataBean> ninelist;
    private shou_nineAdapter shou_nineAdapter1;
    private ViewPager vpBanner;
    private List<String> bannerlist;
    public static final int FLAG = 123;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == FLAG) {
                int current = vpBanner.getCurrentItem();
                if (current < bannerlist.size() - 1) {
                    current++;
                } else {
                    current = 0;
                }
                vpBanner.setCurrentItem(current);
                sendEmptyMessageDelayed(FLAG, 2000);
            }
        }
    };
    private GridView gvShou;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.item_shou,container,false);
        vpBanner = v.findViewById(R.id.vp_banner);
        gvShou = v.findViewById(R.id.gv_shou);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ninelist = new ArrayList<>();
        shou_nineAdapter1 = new shou_nineAdapter(getActivity(), ninelist);
        gvShou.setAdapter(shou_nineAdapter1);


        Type type = new TypeToken<Shou_ninebean>() {
        }.getType();
        HttpUtils.getInstance().get("https://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void success(Object obj) {
               Shou_ninebean ninebean = (Shou_ninebean) obj;
                if (ninebean != null) {
                    List<Shou_ninebean.DataBean> data = ninebean.getData();
                    if (data != null) {
                        ninelist.clear();
                        ninelist.addAll(data);
                        shou_nineAdapter1.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void failure(Exception e) {

            }


        }, type);

        bannerlist = new ArrayList<>();
        bannerlist.add("http://01.imgmini.eastday.com/mobile/20180512/20180512072505_0fe08f494e7c090764244e3581b3e5ca_5_mwpm_03200403.jpg");
        bannerlist.add("http://01.imgmini.eastday.com/mobile/20180512/20180512072505_0fe08f494e7c090764244e3581b3e5ca_1_mwpm_03200403.jpg");
        bannerlist.add("http://06.imgmini.eastday.com/mobile/20180512/20180512_38f5183808987be3783b180740d12a2a_cover_mwpm_03200403.jpg");
        bannerlist.add("http://04.imgmini.eastday.com/mobile/20180512/20180512064621_bab229c7b39e6fa7e59dd27703ddfb38_3_mwpm_03200403.jpg");
        bannerlist.add("http://04.imgmini.eastday.com/mobile/20180512/20180512064621_bab229c7b39e6fa7e59dd27703ddfb38_1_mwpm_03200403.jpg");
        bannerlist.add("http://01.imgmini.eastday.com/mobile/20180512/20180512072505_0fe08f494e7c090764244e3581b3e5ca_2_mwpm_03200403.jpg");

        vpBanner.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return bannerlist.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView img = new ImageView(getActivity());
                img.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(getActivity()).load(bannerlist.get(position)).into(img);
                container.addView(img);
                return img;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        handler.sendEmptyMessageDelayed(FLAG,2000);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(handler);
    }
}
