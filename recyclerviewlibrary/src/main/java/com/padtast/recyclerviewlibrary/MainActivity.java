package com.padtast.recyclerviewlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.padtast.recyclerviewlibrary.Adapter.BusinessAdapter;
import com.padtast.recyclerviewlibrary.entity.BusinessEntity;
import com.padtast.recyclerviewlibrary.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;

    private BusinessAdapter businessAdapter;

    private List<Object> mDatas;


    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initData();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        businessAdapter = new BusinessAdapter(this, mDatas);
//        businessAdapter.setOnRecyclerViewListener(this);

        recyclerView.setAdapter(businessAdapter);
        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(MainActivity.this);
        businessAdapter.setOnRecyclerViewListener(new BusinessAdapter.OnRecyclerViewListener() {
            @Override
            public void onBusinessImgClick(View view, int position) {

            }

            @Override
            public void onBusinessNameClick(View view, int position) {

            }
        });
    }

    // 数据
    protected void initData() {
        mDatas = new ArrayList<>();
        List<ProductEntity> products = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName("我是一个商品哈哈哈哈或或或" + i);
            productEntity.setProductImage("https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=71cd4229be014a909e3e41bd99763971/472309f7905298221dd4c458d0ca7bcb0b46d442.jpg");
            productEntity.setProductPrice("99." + i);
            products.add(productEntity);
        }
        for (int i = 1; i < 30; i++) {
            BusinessEntity entity = new BusinessEntity();
            entity.setBusinessName("ddddfsdfdsfsdfsdfzzzz" + i);
            entity.setBusinessImage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1564533037,3918553373&fm=116&gp=0.jpg");
            entity.setProducts(products);
            mDatas.add(entity);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
