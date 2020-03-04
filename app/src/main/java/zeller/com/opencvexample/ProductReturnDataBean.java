package zeller.com.opencvexample;

import java.util.List;

/**
 * Created by Daniel.Xu on 2020-01-08.
 */
public class ProductReturnDataBean {

    /**
     * code : 0
     * data : {"returnCount":4,"rejectCount":3,"productData":[{"returnCount":3,"rejectCount":1,"name":"西施","code":"1"},{"returnCount":0,"rejectCount":0,"name":"芈月","code":"2"},{"returnCount":1,"rejectCount":2,"name":"卫子夫","code":"3"},{"returnCount":0,"rejectCount":0,"name":"王昭君","code":"4"},{"returnCount":0,"rejectCount":0,"name":"蔡文姬","code":"5"},{"returnCount":0,"rejectCount":0,"name":"貂蝉","code":"6"},{"returnCount":0,"rejectCount":0,"name":"花木兰","code":"7"},{"returnCount":0,"rejectCount":0,"name":"武则天","code":"8"},{"returnCount":0,"rejectCount":0,"name":"杨玉环","code":"9"},{"returnCount":0,"rejectCount":0,"name":"李清照","code":"A"},{"returnCount":0,"rejectCount":0,"name":"富察","code":"B"},{"returnCount":0,"rejectCount":0,"name":"小美龄","code":"C"},{"returnCount":0,"rejectCount":0,"name":"嫦娥","code":"D"}],"productSeriesCode":"ZA"}
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
         * returnCount : 4
         * rejectCount : 3
         * productData : [{"returnCount":3,"rejectCount":1,"name":"西施","code":"1"},{"returnCount":0,"rejectCount":0,"name":"芈月","code":"2"},{"returnCount":1,"rejectCount":2,"name":"卫子夫","code":"3"},{"returnCount":0,"rejectCount":0,"name":"王昭君","code":"4"},{"returnCount":0,"rejectCount":0,"name":"蔡文姬","code":"5"},{"returnCount":0,"rejectCount":0,"name":"貂蝉","code":"6"},{"returnCount":0,"rejectCount":0,"name":"花木兰","code":"7"},{"returnCount":0,"rejectCount":0,"name":"武则天","code":"8"},{"returnCount":0,"rejectCount":0,"name":"杨玉环","code":"9"},{"returnCount":0,"rejectCount":0,"name":"李清照","code":"A"},{"returnCount":0,"rejectCount":0,"name":"富察","code":"B"},{"returnCount":0,"rejectCount":0,"name":"小美龄","code":"C"},{"returnCount":0,"rejectCount":0,"name":"嫦娥","code":"D"}]
         * productSeriesCode : ZA
         */

        private int returnCount;
        private int rejectCount;
        private String productSeriesCode;
        private List<ProductDataBean> productData;

        public int getReturnCount() {
            return returnCount;
        }

        public void setReturnCount(int returnCount) {
            this.returnCount = returnCount;
        }

        public int getRejectCount() {
            return rejectCount;
        }

        public void setRejectCount(int rejectCount) {
            this.rejectCount = rejectCount;
        }

        public String getProductSeriesCode() {
            return productSeriesCode;
        }

        public void setProductSeriesCode(String productSeriesCode) {
            this.productSeriesCode = productSeriesCode;
        }

        public List<ProductDataBean> getProductData() {
            return productData;
        }

        public void setProductData(List<ProductDataBean> productData) {
            this.productData = productData;
        }

        public static class ProductDataBean {
            /**
             * returnCount : 3
             * rejectCount : 1
             * name : 西施
             * code : 1
             */

            private int returnCount;
            private int rejectCount;
            private String name;
            private String code;

            public int getReturnCount() {
                return returnCount;
            }

            public void setReturnCount(int returnCount) {
                this.returnCount = returnCount;
            }

            public int getRejectCount() {
                return rejectCount;
            }

            public void setRejectCount(int rejectCount) {
                this.rejectCount = rejectCount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
