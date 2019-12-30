#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>
#include "BitmapMatUtils.h"
#include "cardocr.h"
#include <android/log.h>
#define LOG_TAG "QrCodeResults"
#define LOGE(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)


using namespace cv;


extern "C"
JNIEXPORT jstring JNICALL
Java_zeller_com_opencvexample_BankCardOcr_cardOcr(JNIEnv *env, jclass type, jobject bitmap) {

    // TODO
    Mat mat;
    bitmap_to_mat(env, bitmap, mat);

    Rect card_rect;
    co1::find_card_area(mat, card_rect);

    Mat card_mat(mat, card_rect);
    imwrite("/storage/emulated/0/ocr/card_mat.jpg", card_mat);

    return env->NewStringUTF("123456");
}

int GMax = 190;
int GMin = 120;

String translateImg(Mat mat);

extern "C"
JNIEXPORT jstring JNICALL Java_zeller_com_opencvexample_BankCardOcr_getQrCodeResult(JNIEnv *env,  jclass type,jobject bitmap ) {
    Mat imageResult;
    bitmap_to_mat(env, bitmap, imageResult);
    int Mult = 255 / (GMax-GMin);
    int Add  = - Mult*GMin;
    for (int i = 0; i < imageResult.rows;i++)
    {
        for (int j = 0; j <imageResult.cols;j++)   //遍历图片的每一个像素点
        {
            //灰度处理之后，只需处理色差值 一维度的色彩
            float length = (Mult *imageResult.at<uchar>(i, j) + Add);
            if (length > 255.0) {
                imageResult.at<uchar>(i, j) = 255;
            }else if (length < 0) {
                imageResult.at<uchar>(i, j) = 0;
            }else {
                imageResult.at<uchar>(i, j) = (int)length;
            }

        }
    }
    QRCodeDetector qrCodeDetector;
    String text = qrCodeDetector.detectAndDecode(imageResult);
    char *theBts = (char *)text.c_str();
    if (GMin < 150) {
        GMin ++;
    }else if(GMin >= 150){
        GMin = 120;
    }

    return env->NewStringUTF(theBts);
}



extern "C"
JNIEXPORT jint JNICALL Java_zeller_com_opencvexample_BankCardOcr_getGmin(JNIEnv *env,  jclass type ) {
    return GMin;
}

extern "C"
JNIEXPORT jint JNICALL Java_zeller_com_opencvexample_BankCardOcr_setMin(JNIEnv *env,  jclass type ,jint min) {
    GMin = min ;
    return GMin;
}





