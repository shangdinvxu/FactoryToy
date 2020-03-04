package zeller.com.opencvexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class SelectDateActivity extends Activity {

    @BindView(R.id.selectStartBtn)
    Button selectStartBtn;
    @BindView(R.id.startDate)
    TextView startDate;
    @BindView(R.id.selectEndBtn)
    Button selectEndBtn;
    @BindView(R.id.endDate)
    TextView endDate;
    @BindView(R.id.sureBtn)
    Button sureBtn;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;


    DateFormat format= DateFormat.getDateTimeInstance();
    Calendar calendar= Calendar.getInstance(Locale.CHINA);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.img_back, R.id.selectStartBtn, R.id.selectEndBtn, R.id.sureBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.selectStartBtn:
                setSelectStartBtn(true);
                break;
            case R.id.selectEndBtn:
                setSelectStartBtn(false);
                break;
            case R.id.sureBtn:
                setSureBtn();
                break;
        }
    }

    private void setSureBtn(){
        if(startDate.getText().toString().length()==0){
            Toast.makeText(SelectDateActivity.this,"请先选择开始时间",Toast.LENGTH_SHORT).show();
            return;
        }
        if(endDate.getText().toString().length()==0){
            Toast.makeText(SelectDateActivity.this,"请先选择结束时间",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("type", "productReturnCount");
        intent.putExtra("startTime",startDate.getText().toString());
        intent.putExtra("endTime",endDate.getText().toString());
        startActivity(intent);
    }


    private void setSelectStartBtn(final boolean isStart){
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(this, DatePickerDialog.THEME_HOLO_DARK, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作
                if(isStart){
                    startDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );
                }else {
                    if(startDate.getText().toString().length()==0){
                        Toast.makeText(SelectDateActivity.this,"请先选择开始时间",Toast.LENGTH_SHORT).show();
                    }else {
                        int i = timeCompare(startDate.getText().toString(), year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        if(i<=1){
                            Toast.makeText(SelectDateActivity.this,"结束日期不能小于开始日期",Toast.LENGTH_SHORT).show();
                        }else {
                            endDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth );
                        }
                    }
                }
            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();

    }


    public static int timeCompare(String startTime, String endTime){
        int i=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = dateFormat.parse(startTime);//开始时间
            Date date2 = dateFormat.parse(endTime);//结束时间
            // 1 结束时间小于开始时间 2 开始时间与结束时间相同 3 结束时间大于开始时间
            if (date2.getTime()<date1.getTime()){
                //结束时间小于开始时间
                i= 1;
            }else if (date2.getTime()==date1.getTime()){
                //开始时间与结束时间相同
                i= 2;
            }else if (date2.getTime()>date1.getTime()){
                //结束时间大于开始时间
            i= 3;
            }
        } catch (Exception e) {

        }
        return  i;
    }

}
