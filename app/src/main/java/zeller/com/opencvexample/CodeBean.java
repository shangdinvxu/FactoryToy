package zeller.com.opencvexample;

/**
 * Created by Daniel.Xu on 2019/4/26.
 */
public class CodeBean {
    /**
     * code : 0
     * data : null
     * error_msg :
     */

    private int code;
    private Object data;
    private String error_msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

}
