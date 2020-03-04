package zeller.com.opencvexample;

/**
 * Created by Daniel.Xu on 2020-02-26.
 */
public class VerifyBean {

    /**
     * code : 0
     * data : {"id":2,"code":"nbnb","remark":"测试2"}
     * error_msg :
     */

    private int code;
    private DataBean data;
    private String error_msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public static class DataBean {
        /**
         * id : 2
         * code : nbnb
         * remark : 测试2
         */

        private int id;
        private String code;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
