package zeller.com.opencvexample;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class FirstPageAdapter extends BaseQuickAdapter<AllDataBean.DataBean, BaseViewHolder> {
    public FirstPageAdapter(int layoutResId, @Nullable List<AllDataBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllDataBean.DataBean item) {
        helper.setText(R.id.tv_name,item.getProductSeriesName()+"("+item.getProductSeriesCode()+")");
    }
}
