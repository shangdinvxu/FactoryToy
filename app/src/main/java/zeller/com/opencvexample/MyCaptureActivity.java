package zeller.com.opencvexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lib_zxing.activity.CaptureFragment;
import lib_zxing.activity.CodeUtils;
import lib_zxing.activity.ZXingLibrary;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Initial the camera
 * <p>
 * 默认的二维码扫描Activity
 */
public class MyCaptureActivity extends AppCompatActivity {
    TextView textTitle;
    ScanApi scanApi;
    AllDataBean.DataBean.ProductListBean dataBean;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.fl_zxing_container)
    FrameLayout flZxingContainer;
    @BindView(R.id.text)
    TextView text;
    String seriesCode;
    @BindView(R.id.image)
    ImageView image;

    AlertDialog builder;
    String type;
    @BindView(R.id.type)
    TextView typeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        textTitle = findViewById(R.id.text);
        ButterKnife.bind(this);
        ZXingLibrary.initDisplayOpinion(this);
        CaptureFragment captureFragment = new CaptureFragment();
        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
        captureFragment.setCameraInitCallBack(new CaptureFragment.CameraInitCallBack() {
            @Override
            public void callBack(Exception e) {
                if (e == null) {

                } else {
                    Log.e("TAG", "callBack: ", e);
                }
            }

        });
        scanApi = RetrofitClient.getInstance(this).create(ScanApi.class);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        if ("inactive".equals(type)) {
            typeTv.setText("激活");
        } else if ("check".equals(type)) {
            typeTv.setText("校验");
        }else if ("productReturn".equals(type)) {
            typeTv.setText("不良品退回");
        }
        seriesCode = intent.getStringExtra("seriesCode");
        if (seriesCode != null) {
            dataBean = (AllDataBean.DataBean.ProductListBean) intent.getSerializableExtra("data");
            tvTitle.setText(dataBean.getProductName() + "(" + seriesCode + dataBean.getProductCode() + ")");
            Glide.with(this).load(SysConstant.IMG_URL + dataBean.getProductImageHave()).into(image);
        }
        builder = new AlertDialog.Builder(MyCaptureActivity.this)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            if (result != null) {
                String toyCode = result.trim();
                int i = toyCode.indexOf("?c=");
                String resultString = "";
                if (!toyCode.startsWith(SysConstant.APP_ROBOTIME_URL) || i == -1) {
                    showSuccessDialog("无效二维码");
                    return;
                } else {
                    resultString = toyCode.substring(i + 3, toyCode.length());
                }
                if ("inactive".equals(type)) {
                    scanApi.toyCheck(resultString, seriesCode, dataBean.getProductCode()).enqueue(new Callback<CheckResponseBean>() {
                        @Override
                        public void onResponse(Call<CheckResponseBean> call, Response<CheckResponseBean> response) {
                            if (response.body() != null && response.body().getData() != null) {
                                showSuccessDialog(response.body().getData());
                            } else {
                                showSuccessDialog("扫描失败1");
                            }
                        }

                        @Override
                        public void onFailure(Call<CheckResponseBean> call, Throwable t) {
                            showSuccessDialog("扫描失败2");
                        }
                    });
                } else if ("check".equals(type)) {
                    scanApi.toyCheckSecondary(resultString, seriesCode, dataBean.getProductCode()).enqueue(new Callback<CheckSecondyResponseBean>() {
                        @Override
                        public void onResponse(Call<CheckSecondyResponseBean> call, Response<CheckSecondyResponseBean> response) {
                            if (response.body() != null && response.body().getData() != null) {
                                showSuccessDialog(response.body().getData().getMsg());
                            } else {
                                showSuccessDialog("扫描失败1");
                            }
                        }

                        @Override
                        public void onFailure(Call<CheckSecondyResponseBean> call, Throwable t) {
                            showSuccessDialog("扫描失败2");
                        }
                    });
                }else if ("productReturn".equals(type)) {
                    scanApi.productReturn(resultString).enqueue(new Callback<CodeBean>() {
                        @Override
                        public void onResponse(Call<CodeBean> call, Response<CodeBean> response) {
                            if (response.body() != null && response.body().getCode() == 0) {
                                showSuccessDialog("退回成功");
                            } else {
                                showSuccessDialog("退回失败");
                            }

                        }

                        @Override
                        public void onFailure(Call<CodeBean> call, Throwable t) {

                        }
                    });
                }

            } else {
                showSuccessDialog("扫描失败3");
            }
        }

        @Override
        public void onAnalyzeFailed() {
            showSuccessDialog("扫描失败4");
        }
    };


    Dialog dialog;

    public void showSuccessDialog(String tip) {
        if (tip.contains("成功")) {
            textTitle.setVisibility(View.VISIBLE);
            textTitle.setText(tip);
            textTitle.setBackgroundColor(getResources().getColor(R.color.green));
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    textTitle.setVisibility(View.GONE);
                }
            }, 1500);
        } else {
            showFailDialog(tip);
//            textTitle.setText(tip);
//            textTitle.setBackgroundColor(getResources().getColor(R.color.red));
        }

    }

    public void showFailDialog(String text) {
        if (!builder.isShowing()) {
            builder.setMessage(text);
            builder.show();
        }
    }


    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }
}