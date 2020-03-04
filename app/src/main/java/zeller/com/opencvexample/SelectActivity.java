package zeller.com.opencvexample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hugeterry.updatefun.UpdateFunGO;
import cn.hugeterry.updatefun.config.UpdateKey;

/**
 * Created by Daniel.Xu on 2019-10-17.
 */
public class SelectActivity extends Activity {
    @BindView(R.id.inactive)
    Button inactive;
    @BindView(R.id.check)
    Button check;
    @BindView(R.id.productReturn)
    Button productReturn;

    public static final int PERMISSIONS_REQUEST_CALL_STORAGE = 2;//权限
    private static final int TO_SETTING_PERMISSIONS = 4;//跳转至设置申请图片读取权限

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_select);
        ButterKnife.bind(this);
//        new FirUpdater(SelectActivity.this)
//                .apiToken("f2a3d1973878abb5ba921a0176a5c1fb")
//                .appId("5dad05ceb2eb4654cdb7a611")
//                .checkVersion();
        UpdateKey.API_TOKEN = "f2a3d1973878abb5ba921a0176a5c1fb";
        UpdateKey.APP_ID = "5dad05ceb2eb4654cdb7a611";
        UpdateFunGO.init(this);
        initAutoUpdateApp();
    }


    @OnClick({R.id.inactive, R.id.check,R.id.productReturn,R.id.productReturnCount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.inactive:
                Intent intent = new Intent(SelectActivity.this, MainActivity.class);
                intent.putExtra("type", "inactive");
                startActivity(intent);
                break;
            case R.id.check:
                Intent intent2 = new Intent(SelectActivity.this, MainActivity.class);
                intent2.putExtra("type", "check");
                startActivity(intent2);
                break;
            case R.id.productReturn:
                Intent intent3 = new Intent(SelectActivity.this, SelectToyStateActivity.class);
                intent3.putExtra("type", "productReturn");
                startActivity(intent3);
                break;
            case R.id.productReturnCount:
                Intent intent4 = new Intent(SelectActivity.this, SelectDateActivity.class);
                intent4.putExtra("type", "productReturnCount");
                startActivity(intent4);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        UpdateFunGO.onResume(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        UpdateFunGO.onStop(this);
    }

    private void initAutoUpdateApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
            int i = ContextCompat.checkSelfPermission(this, permissions[0]);
            int j = ContextCompat.checkSelfPermission(this, permissions[1]);
            int k = ContextCompat.checkSelfPermission(this, permissions[2]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (i != PackageManager.PERMISSION_GRANTED && j != PackageManager.PERMISSION_GRANTED && k != PackageManager.PERMISSION_GRANTED) {
                // 如果没有授予该权限，就去提示用户请求
                ActivityCompat.requestPermissions(this, permissions, PERMISSIONS_REQUEST_CALL_STORAGE);
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

}
