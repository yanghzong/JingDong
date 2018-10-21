package com.bw.jingdong.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bw.jingdong.LoginActivity;
import com.bw.jingdong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 择木 on 2018/10/16.
 */

public class FoundFragment extends Fragment implements View.OnClickListener {

    private TabLayout tbFound;
    private List<String> titles;
    private List<Fragment> foundFragmentlist;
    private ViewPager vpFound;
    private Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.item_found,container,false);
        tbFound = v.findViewById(R.id.tb_found);
        vpFound = v.findViewById(R.id.vp_found);
        btnLogin = v.findViewById(R.id.btn_login);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnLogin.setOnClickListener(this);
        foundFragmentlist = new ArrayList<>();
        foundFragmentlist.add(new Fragment_found_guanfragment());
        foundFragmentlist.add(new Fragment_found_jingxuanfragment());
        foundFragmentlist.add(new Fragment_found_dapeifragment());
        foundFragmentlist.add(new Fragment_found_shipinfragment());
        foundFragmentlist.add(new Fragment_found_nuojiyafragment());
        foundFragmentlist.add(new Fragment_found_zhibofragment());


        titles = new ArrayList<>();
        titles.add("关注");
        titles.add("精选");
        titles.add("搭配");
        titles.add("视频");
        titles.add("诺基亚");
        titles.add("直播");
        vpFound.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return foundFragmentlist.size();
            }

            @Override
            public Fragment getItem(int position) {
                return foundFragmentlist.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        tbFound.setTabMode(TabLayout.MODE_FIXED);
        tbFound.setupWithViewPager(vpFound);


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
