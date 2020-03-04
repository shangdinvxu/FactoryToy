package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniel.Xu on 2019-10-17.
 */
public class SelectToyStateActivity extends Activity {


    @BindView(R.id.state1)
    Button state1;
    @BindView(R.id.state2)
    Button state2;
    @BindView(R.id.img_back)
    ImageView imgBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select_toy_state);
        ButterKnife.bind(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @OnClick({R.id.state1, R.id.state2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.state1:
                Intent intent1 = new Intent(SelectToyStateActivity.this, MyCaptureActivity.class);
                intent1.putExtra("type", "productReturn");
                intent1.putExtra("state", "1");
                startActivity(intent1);
                break;
            case R.id.state2:
                Intent intent2 = new Intent(SelectToyStateActivity.this, MyCaptureActivity.class);
                intent2.putExtra("type", "productReturn");
                intent2.putExtra("state", "2");
                startActivity(intent2);
                break;
        }
    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}
