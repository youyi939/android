package com.example.youyi.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private ArrayList <String> imagePath;               //图片url
    private ArrayList <String> imageTitle;              //图片对应的标签
    private MyImageLoader myImageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        initData();
        initView();

    }



    private void initData(){
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add("https://www.mercedes-benz.com.cn/content/dam/mb-cn/vehicles/amg/amg-c63/banner-pc4.jpg");
        imagePath.add("https://www.jeep.com.cn/wrangler/img/kv.jpg");
        imageTitle.add("奔驰C63 AMG");
        imageTitle.add("牧马人");
    }


    private void initView(){
        myImageLoader = new MyImageLoader();
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);             //设置banner样式
        banner.setImageLoader(myImageLoader);                                   //设置图片加载器
//        banner.setBannerAnimation(Transformer.ZoomIn);                         //设置轮播动画效果
//        banner.setBannerTitles(imageTitle);                                     //设置banner的文字
        banner.setDelayTime(1000);                                              //设置轮播的间隔时间
        banner.isAutoPlay(true);                                                //设置是否为自动轮播
//        banner.setIndicatorGravity(BannerConfig.CENTER);                        //设置指示器的位置，小点点，居中显示
        banner.setImages(imagePath)                                             //设置图片加载地址
                                   .setOnBannerListener(new OnBannerListener() {                //轮播监听
                                       @Override
                                       public void OnBannerClick(int position) {
                                           switch (position){

                                           }
                                       }
                                   }).start();

    }

}
