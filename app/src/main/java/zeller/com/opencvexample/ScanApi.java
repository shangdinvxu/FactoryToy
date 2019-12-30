package zeller.com.opencvexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel.Xu on 2019/8/7.
 */
public interface ScanApi {

    //解析玩具
    @GET("toyCheck")
    Call<CheckResponseBean> toyCheck(@Query("c") String toy_code,@Query("productSeriesCode") String productSeriesCode, @Query("productCode") String productCode);



    //解析玩具
    @GET("toyCheckSecondary")
    Call<CheckSecondyResponseBean> toyCheckSecondary(@Query("c") String toy_code,@Query("productSeriesCode") String productSeriesCode, @Query("productCode") String productCode);




    //    获取玩具系列数据详细情况
    @GET("findCheckData")
    Call<AllDataBean> findCheckData();


    //解析玩具
    @GET("productReturn")
    Call<CodeBean> productReturn(@Query("c") String toy_code);




}
