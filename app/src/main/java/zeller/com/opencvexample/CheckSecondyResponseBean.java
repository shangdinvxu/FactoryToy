package zeller.com.opencvexample;

/**
 * Created by Daniel.Xu on 2019-10-17.
 */
public class CheckSecondyResponseBean {


    /**
     * code : 0
     * data : {"code":"2","msg":"未激活!","productName":null,"productSeriesCode":null,"productCode":null}
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
         * code : 2
         * msg : 未激活!
         * productName : null
         * productSeriesCode : null
         * productCode : null
         */

        private String code;
        private String msg;
        private Object productName;
        private Object productSeriesCode;
        private Object productCode;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getProductName() {
            return productName;
        }

        public void setProductName(Object productName) {
            this.productName = productName;
        }

        public Object getProductSeriesCode() {
            return productSeriesCode;
        }

        public void setProductSeriesCode(Object productSeriesCode) {
            this.productSeriesCode = productSeriesCode;
        }

        public Object getProductCode() {
            return productCode;
        }

        public void setProductCode(Object productCode) {
            this.productCode = productCode;
        }
    }
}
