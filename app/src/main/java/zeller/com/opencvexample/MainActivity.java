package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private Bitmap mFaceBitmap;

    public static final int PERMISSIONS_REQUEST_CALL_STORAGE = 2;//权限
    private static final int TO_SETTING_PERMISSIONS = 4;//跳转至设置申请图片读取权限
    ScanApi scanApi;
    List<AllDataBean.DataBean> data = new ArrayList<>();
    FirstPageAdapter firstPageAdapter;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initAutoUpdateApp();
        scanApi = RetrofitClient.getInstance(this).create(ScanApi.class);
        initView();
        Intent intent = getIntent();
        type = intent.getStringExtra("type");

    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        firstPageAdapter = new FirstPageAdapter(R.layout.first_item, data);
        recycler.setAdapter(firstPageAdapter);
        firstPageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AllDataBean.DataBean dataBean = data.get(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", dataBean);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        Call<AllDataBean> checkData = scanApi.findCheckData();
        checkData.enqueue(new Callback<AllDataBean>() {
            @Override
            public void onResponse(Call<AllDataBean> call, Response<AllDataBean> response) {
                if (response.body() != null && response.body().getCode() == 0) {
                    data.clear();
                    data.addAll(response.body().getData());
                    firstPageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<AllDataBean> call, Throwable t) {

            }
        });
    }


    private void initAutoUpdateApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
            int i = ContextCompat.checkSelfPermission(MainActivity.this, permissions[0]);
            int j = ContextCompat.checkSelfPermission(MainActivity.this, permissions[1]);
            int k = ContextCompat.checkSelfPermission(MainActivity.this, permissions[2]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED && j != PackageManager.PERMISSION_GRANTED && k != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSIONS_REQUEST_CALL_STORAGE);
                return;
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CALL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // Toast.makeText(PermissionActivity.this, "request false", Toast.LENGTH_SHORT).show();
                }
            }

        }
        if (requestCode == PERMISSIONS_REQUEST_CALL_STORAGE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivityForResult(intent, TO_SETTING_PERMISSIONS);
            } else {
//                    UpdateKey.API_TOKEN = SysConstant.APITOKEN;
//                    UpdateKey.APP_ID = SysConstant.APPID;
//
//                    UpdateKey.DialogOrNotification = UpdateKey.WITH_DIALOG;
//                    UpdateFunGO.init(this);
            }
        }
    }

    @OnClick({R.id.img_back, R.id.tv_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_title:
                break;
        }
    }
}
