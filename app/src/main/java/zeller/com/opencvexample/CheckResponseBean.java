package zeller.com.opencvexample;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class CheckResponseBean {

    /**
     * code : 0
     * data : 玩具码不存在
     * error_msg :
     */

    private int code;
    private String data;
    private String error_msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
