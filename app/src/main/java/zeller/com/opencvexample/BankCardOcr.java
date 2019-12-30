package zeller.com.opencvexample;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/9/6.
 */

public class BankCardOcr {

    static {
        System.loadLibrary("native-lib");
    }



    public static native String cardOcr(Bitmap bitmap);


    public static native String getQrCodeResult(Bitmap bitmap);

    public static native int getGmin();


    public static native int setMin(int min);
}
