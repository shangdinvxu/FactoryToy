package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel.Xu on 2020-02-26.
 */
public class VerificationActivity extends Activity {

    @BindView(R.id.editTv)
    EditText editTv;
    @BindView(R.id.confirm)
    Button confirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.confirm)
    public void onViewClicked() {
        String s = editTv.getText().toString();
        if(s.length()==0){
            Toast.makeText(this,"请输入验证信息",Toast.LENGTH_SHORT).show();
            return;
        }
        ScanApi scanApi = RetrofitClient.getInstance(this).create(ScanApi.class);
        Call<VerifyBean> verifyBeanCall = scanApi.factoryVerify(s);
        verifyBeanCall.enqueue(new Callback<VerifyBean>() {
            @Override
            public void onResponse(Call<VerifyBean> call, Response<VerifyBean> response) {
                if(response.body()!=null&&response.body().getCode()==0){
                    SPUtils.getInstance().put("id",response.body().getData().getId());
                    finish();
                    Intent intent = new Intent(VerificationActivity.this, SelectActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(VerificationActivity.this,"请输入正确的验证信息",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VerifyBean> call, Throwable t) {
                Toast.makeText(VerificationActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
