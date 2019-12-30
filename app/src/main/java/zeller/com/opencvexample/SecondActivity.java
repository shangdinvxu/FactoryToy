package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class SecondActivity extends Activity {

    SecondPageAdapter secondPageAdapter;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    List<AllDataBean.DataBean.ProductListBean> productList;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    AllDataBean.DataBean data;
    String type ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        data = (AllDataBean.DataBean) intent.getSerializableExtra("data");
        type = intent.getStringExtra("type");
        productList = data.getProductList();
        tvTitle.setText(data.getProductSeriesName());
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        secondPageAdapter = new SecondPageAdapter(R.layout.first_item, productList,data.getProductSeriesCode());
        recycler.setAdapter(secondPageAdapter);
        secondPageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AllDataBean.DataBean.ProductListBean productListBean = productList.get(position);
                Intent intent = new Intent(SecondActivity.this, MyCaptureActivity.class);
                intent.putExtra("data", productListBean);
                intent.putExtra("seriesCode",data.getProductSeriesCode());
                intent.putExtra("type",type);
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
