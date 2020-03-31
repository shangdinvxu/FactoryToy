package zeller.com.opencvexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SPUtils;

import java.util.HashMap;

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

    private static final int PERMISSIONS_REQUEST_CALL_STORAGE = 2;//权限

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        ButterKnife.bind(this);
        initAutoUpdateApp();
    }

    private void initAutoUpdateApp() {
//        UpdateKey.API_TOKEN = SysConstant.APITOKEN;
//        UpdateKey.APP_ID = SysConstant.APPID;
//        //下载方式:
////        UpdateKey.DialogOrNotification = UpdateKey.WITH_DIALOG;
//        UpdateFunGO.init(this);
        ScanApi posApi = RetrofitFirClient.getInstance(this).create(ScanApi.class);
        Call<FirBean> firVersion = posApi.getFirVersion(SysConstant.APITOKEN);
        firVersion.enqueue(new Callback<FirBean>() {
            @Override
            public void onResponse(Call<FirBean> call, final Response<FirBean> response) {
                if(response.body()!=null){
                    try {
                        String version = response.body().getVersion();
                        Integer integer = Integer.valueOf(version);
                        if (getAppVersionCode(VerificationActivity.this)<integer){
                            final AlertDialog.Builder builder = new AlertDialog.Builder(VerificationActivity.this)
                                    .setTitle("下载更新")
                                    .setMessage(response.body().getChangelog()).setCancelable(false)
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            //do  delete thing
                                            Intent intent=new Intent();
                                            intent.setAction("android.intent.action.VIEW");
                                            Uri CONTENT_URI_BROWSERS = Uri.parse(response.body().getUpdate_url());
                                            intent.setData(CONTENT_URI_BROWSERS);
                                            intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
                                            startActivity(intent);
                                        }
                                    });
                            builder.create().show();
                        }
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<FirBean> call, Throwable t) {

            }
        });
    }


    /**
     * 返回当前程序版本号
     */
    public static int getAppVersionCode(Context context) {
        int versioncode = 0;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            // versionName = pi.versionName;
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versioncode ;
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
