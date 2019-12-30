package zeller.com.opencvexample;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SecondPageAdapter extends BaseQuickAdapter<AllDataBean.DataBean.ProductListBean, BaseViewHolder> {
    private String productSeriesCode;
    public SecondPageAdapter(int layoutResId, @Nullable List<AllDataBean.DataBean.ProductListBean> data,String productSeriesCode) {
        super(layoutResId, data);
        this.productSeriesCode = productSeriesCode;
    }

    @Override
    protected void convert(BaseViewHolder helper, AllDataBean.DataBean.ProductListBean item) {
        helper.setText(R.id.tv_name,item.getProductName()+"("+productSeriesCode+item.getProductCode()+")");
    }
}
