package zeller.com.opencvexample;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private  static Retrofit retrofit;

    private RetrofitClient(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor()).build();

        retrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(client)
//                http://192.168.3.197:8086/app/
                .baseUrl(SysConstant.ROBOTIME_URL)
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Retrofit getInstance(Context context) {
        new RetrofitClient(context);
        return retrofit;
    }
}
