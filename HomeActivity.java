package com.bw.jingdong;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.jingdong.Fragment.FenFragment;
import com.bw.jingdong.Fragment.FoundFragment;
import com.bw.jingdong.Fragment.MineFragment;
import com.bw.jingdong.Fragment.ShopFragment;
import com.bw.jingdong.Fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgFen;
    private ViewPager vpButtom;
    private ImageView imgFound;
    private ImageView imgMine;
    private ImageView imgShop;
    private ImageView imgShou;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        imgFen.setOnClickListener(this);
        imgFound.setOnClickListener(this);
        imgMine.setOnClickListener(this);
        imgShop.setOnClickListener(this);
        imgShou.setOnClickListener(this);

        list = new ArrayList<>();
        list.add(new ShouFragment());
        list.add(new FenFragment());
        list.add(new FoundFragment());
        list.add(new ShopFragment());
        list.add(new MineFragment());

        vpButtom.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }


        });

        vpButtom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeBackGround(position);

            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void changeBackGround(int index) {
        switch (index){
            case 0:
                imgShou.setImageResource(R.drawable.ac1);
                imgFen.setImageResource(R.drawable.abw);
                imgFound.setImageResource(R.drawable.abu);
                imgShop.setImageResource(R.drawable.aby);
                imgMine.setImageResource(R.drawable.ac2);
                break;
            case 1:
                imgShou.setImageResource(R.drawable.ac0);
                imgFen.setImageResource(R.drawable.abx);
                imgFound.setImageResource(R.drawable.abu);
                imgShop.setImageResource(R.drawable.aby);
                imgMine.setImageResource(R.drawable.ac2);
                break;
            case 2:
                imgShou.setImageResource(R.drawable.ac0);
                imgFen.setImageResource(R.drawable.abw);
                imgFound.setImageResource(R.drawable.abv);
                imgShop.setImageResource(R.drawable.aby);
                imgMine.setImageResource(R.drawable.ac2);
                break;
            case 3:
                imgShou.setImageResource(R.drawable.ac0);
                imgFen.setImageResource(R.drawable.abw);
                imgFound.setImageResource(R.drawable.abu);
                imgShop.setImageResource(R.drawable.abz);
                imgMine.setImageResource(R.drawable.ac2);
                break;
            case 4:
                imgShou.setImageResource(R.drawable.ac0);
                imgFen.setImageResource(R.drawable.abw);
                imgFound.setImageResource(R.drawable.abu);
                imgShop.setImageResource(R.drawable.aby);
                imgMine.setImageResource(R.drawable.ac3);
                break;



        }




    }

    private void initView() {
        vpButtom = findViewById(R.id.vp_buttom);
        imgFen = findViewById(R.id.img_fen);
        imgFound = findViewById(R.id.img_found);
        imgMine = findViewById(R.id.img_mine);
        imgShop = findViewById(R.id.img_shop);
        imgShou = findViewById(R.id.img_shou);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_shou:
                vpButtom.setCurrentItem(0);
                changeBackGround(0);

                break;
            case R.id.img_fen:
                vpButtom.setCurrentItem(1);
                changeBackGround(1);

                break;
            case R.id.img_found:
                vpButtom.setCurrentItem(2);
                changeBackGround(2);

                break;
            case R.id.img_shop:
                vpButtom.setCurrentItem(3);
                changeBackGround(3);

                break;
            case R.id.img_mine:
                vpButtom.setCurrentItem(4);
                changeBackGround(4);

                break;

        }
    }
}
