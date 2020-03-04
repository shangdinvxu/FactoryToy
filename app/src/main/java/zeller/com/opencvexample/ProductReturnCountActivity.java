package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class ProductReturnCountActivity extends Activity {

    ProductReturnCountAdapter productReturnCountAdapter;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    List<AllDataBean.DataBean.ProductListBean> productList;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    AllDataBean.DataBean data;
    String type;

    ScanApi scanApi;
    @BindView(R.id.returnTv)
    TextView returnTv;
    @BindView(R.id.rejectTv)
    TextView rejectTv;

    String startTime;
    String endTime;
    @BindView(R.id.timeTv)
    TextView timeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_return);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        data = (AllDataBean.DataBean) intent.getSerializableExtra("data");
        type = intent.getStringExtra("type");
        startTime = intent.getStringExtra("startTime");
        endTime = intent.getStringExtra("endTime");
        timeTv.setText("选择的时间是:   "+startTime+"  --   "+endTime);
        scanApi = RetrofitClient.getInstance(this).create(ScanApi.class);
        tvTitle.setText(data.getProductSeriesName());
        initRecyclerView();
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initRecyclerView() {
        Call<ProductReturnDataBean> productReturnData = scanApi.findProductReturnData(data.getProductSeriesId(),startTime,endTime);
        productReturnData.enqueue(new Callback<ProductReturnDataBean>() {
            @Override
            public void onResponse(Call<ProductReturnDataBean> call, Response<ProductReturnDataBean> response) {
                if (response.body() != null && response.body().getCode() == 0) {
                    ProductReturnDataBean body = response.body();
                    returnTv.setText("" + body.getData().getReturnCount());
                    rejectTv.setText("" + body.getData().getRejectCount());
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductReturnCountActivity.this);
                    recycler.setLayoutManager(linearLayoutManager);
                    productReturnCountAdapter = new ProductReturnCountAdapter(R.layout.return_count_item, body.getData().getProductData(), body.getData());
                    recycler.setAdapter(productReturnCountAdapter);
                }
            }

            @Override
            public void onFailure(Call<ProductReturnDataBean> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
