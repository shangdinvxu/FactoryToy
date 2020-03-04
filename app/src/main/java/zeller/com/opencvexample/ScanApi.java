package zeller.com.opencvexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daniel.Xu on 2019/8/7.
 */
public interface ScanApi {

    //激活
    @GET("toyCheck")
    Call<CheckResponseBean> toyCheck(@Query("c") String toy_code,@Query("productSeriesCode") String productSeriesCode, @Query("productCode") String productCode);


    //重新激活
    @GET("toyReInactive")
    Call<CheckResponseBean> toyReInactive(@Query("c") String toy_code,@Query("productSeriesCode") String productSeriesCode, @Query("productCode") String productCode);


    //校验
    @GET("toyCheckSecondary")
    Call<CheckSecondyResponseBean> toyCheckSecondary(@Query("c") String toy_code,@Query("productSeriesCode") String productSeriesCode, @Query("productCode") String productCode);

    // 获取玩具系列数据详细情况
    @GET("findCheckData")
    Call<AllDataBean> findCheckData();

    // 根据不同权限获取玩具系列数据详细情况
    @GET("findNewCheckDataById")
    Call<AllDataBean> findNewCheckDataById(@Query("id") int id);

    //退回
    @GET("productReturn")
    Call<CodeBean> productReturn(@Query("c") String toyCode, @Query("toyState") String toyState);

    //    获取玩具系列售后数据详细情况
    @GET("findProductReturnData")
    Call<ProductReturnDataBean> findProductReturnData(@Query("seriesId") String seriesId,
                                                      @Query("startDate") String startDate,
                                                      @Query("endDate") String endDate );

    @GET("factoryVerify")
    Call<VerifyBean> factoryVerify(@Query("code") String code);

}
