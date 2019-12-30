package zeller.com.opencvexample;

import java.util.List;

/**
 * Created by Daniel.Xu on 2019/7/31.
 */
public class ToyScanBean {


    /**
     * code : 0
     * data : {"productId":"4","productName":"西施","productCode":"1","productImageHave":"/product/2019/07/606145837164134400.png","productImageLose":"/product/2019/07/606056063069847552.png","productType":"1","productSeriesId":"1","userToyList":[{"userToyId":null,"userId":null,"displayName":null,"productRecordId":"15","productId":null,"activationTime":null,"toyCode":"n4XXAKfRX6","wantsCount":null,"birthday":1564387097000,"identityCoding":"ZA106T007Q","haveRankings":null,"rankingRatio":null}]}
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
         * productId : 4
         * productName : 西施
         * productCode : 1
         * productImageHave : /product/2019/07/606145837164134400.png
         * productImageLose : /product/2019/07/606056063069847552.png
         * productType : 1
         * productSeriesId : 1
         * userToyList : [{"userToyId":null,"userId":null,"displayName":null,"productRecordId":"15","productId":null,"activationTime":null,"toyCode":"n4XXAKfRX6","wantsCount":null,"birthday":1564387097000,"identityCoding":"ZA106T007Q","haveRankings":null,"rankingRatio":null}]
         */

        private String productId;
        private String productName;
        private String productCode;
        private String productImageHave;
        private String productImageLose;
        private String productType;
        private String productSeriesId;
        private List<UserToyListBean> userToyList;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductImageHave() {
            return productImageHave;
        }

        public void setProductImageHave(String productImageHave) {
            this.productImageHave = productImageHave;
        }

        public String getProductImageLose() {
            return productImageLose;
        }

        public void setProductImageLose(String productImageLose) {
            this.productImageLose = productImageLose;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getProductSeriesId() {
            return productSeriesId;
        }

        public void setProductSeriesId(String productSeriesId) {
            this.productSeriesId = productSeriesId;
        }

        public List<UserToyListBean> getUserToyList() {
            return userToyList;
        }

        public void setUserToyList(List<UserToyListBean> userToyList) {
            this.userToyList = userToyList;
        }

        public static class UserToyListBean {
            /**
             * userToyId : null
             * userId : null
             * displayName : null
             * productRecordId : 15
             * productId : null
             * activationTime : null
             * toyCode : n4XXAKfRX6
             * wantsCount : null
             * birthday : 1564387097000
             * identityCoding : ZA106T007Q
             * haveRankings : null
             * rankingRatio : null
             */

            private String userToyId;
            private String userId;
            private String displayName;
            private String productRecordId;
            private Object productId;
            private Long activationTime;

            public Long getAcquireTime() {
                return acquireTime;
            }

            public void setAcquireTime(Long acquireTime) {
                this.acquireTime = acquireTime;
            }

            private Long acquireTime;
            private String toyCode;
            private Object wantsCount;
            private long birthday;
            private String identityCoding;
            private Integer haveRankings;
            private Double rankingRatio;
            private String avatar;

            public String getDisplayName() {
                return displayName;
            }

            public void setDisplayName(String displayName) {
                this.displayName = displayName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getImAccId() {
                return imAccId;
            }

            public void setImAccId(String imAccId) {
                this.imAccId = imAccId;
            }

            private String imAccId ;

            public String getUserToyId() {
                return userToyId;
            }

            public void setUserToyId(String userToyId) {
                this.userToyId = userToyId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getProductRecordId() {
                return productRecordId;
            }

            public void setProductRecordId(String productRecordId) {
                this.productRecordId = productRecordId;
            }

            public Object getProductId() {
                return productId;
            }

            public void setProductId(Object productId) {
                this.productId = productId;
            }

            public Long getActivationTime() {
                return activationTime;
            }

            public void setActivationTime(Long activationTime) {
                this.activationTime = activationTime;
            }

            public String getToyCode() {
                return toyCode;
            }

            public void setToyCode(String toyCode) {
                this.toyCode = toyCode;
            }

            public Object getWantsCount() {
                return wantsCount;
            }

            public void setWantsCount(Object wantsCount) {
                this.wantsCount = wantsCount;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public String getIdentityCoding() {
                return identityCoding;
            }

            public void setIdentityCoding(String identityCoding) {
                this.identityCoding = identityCoding;
            }

            public Integer getHaveRankings() {
                return haveRankings;
            }

            public void setHaveRankings(Integer haveRankings) {
                this.haveRankings = haveRankings;
            }

            public Double getRankingRatio() {
                return rankingRatio;
            }

            public void setRankingRatio(Double rankingRatio) {
                this.rankingRatio = rankingRatio;
            }
        }
    }
}
