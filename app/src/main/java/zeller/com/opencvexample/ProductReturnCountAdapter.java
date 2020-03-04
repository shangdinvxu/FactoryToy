package zeller.com.opencvexample;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ProductReturnCountAdapter extends BaseQuickAdapter<ProductReturnDataBean.DataBean.ProductDataBean, BaseViewHolder> {
    private ProductReturnDataBean.DataBean body;
    public ProductReturnCountAdapter(int layoutResId,List<ProductReturnDataBean.DataBean.ProductDataBean> data,ProductReturnDataBean.DataBean body) {
        super(layoutResId, data);
        this.body = body;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductReturnDataBean.DataBean.ProductDataBean item) {
        helper.setText(R.id.tv_name,item.getName()+"("+body.getProductSeriesCode()+item.getCode()+")");
        helper.setText(R.id.returnTv,""+item.getReturnCount());
        helper.setText(R.id.rejectTv,""+item.getRejectCount());
    }
}
