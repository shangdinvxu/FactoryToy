package zeller.com.opencvexample;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Daniel.Xu on 2019-10-13.
 */
public class AllDataBean  {

    /**
     * code : 0
     * data : [{"productSeriesType":null,"userId":null,"productSeriesId":"1","productSeriesName":"今夕何夕","productSeriesCode":"ZA","productSeriesRemark":null,"productSeriesImage":"/productSeries/2019/09/627155229569187840.png","productSeriesImageWeChat":"/productSeries/2019/09/627155245893419008.png","drawBoxUrl":"","shoppingUrl":"","productList":[{"productId":"4","productName":"西施","productCode":"1","productImageHave":"/product/2019/09/627155353267601408.png","productImageLose":"/product/2019/09/627155362172108800.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"5","productName":"芈月","productCode":"2","productImageHave":"/product/2019/09/627155388646555648.png","productImageLose":"/product/2019/09/627155396141776896.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"6","productName":"卫子夫","productCode":"3","productImageHave":"/product/2019/09/627155417725665280.png","productImageLose":"/product/2019/09/627155425313161216.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"7","productName":"王昭君","productCode":"4","productImageHave":"/product/2019/09/627155469961527296.png","productImageLose":"/product/2019/09/627155477049901056.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"8","productName":"蔡文姬","productCode":"5","productImageHave":"/product/2019/09/627155508918222848.png","productImageLose":"/product/2019/09/627155516518301696.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"9","productName":"貂蝉","productCode":"6","productImageHave":"/product/2019/09/627155537175248896.png","productImageLose":"/product/2019/09/627155547505819648.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"10","productName":"花木兰","productCode":"7","productImageHave":"/product/2019/09/627155576807227392.png","productImageLose":"/product/2019/09/627155584117899264.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"11","productName":"武则天","productCode":"8","productImageHave":"/product/2019/09/627155614589517824.png","productImageLose":"/product/2019/09/627155621501730816.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"12","productName":"杨玉环","productCode":"9","productImageHave":"/product/2019/09/627155653583962112.png","productImageLose":"/product/2019/09/627155660294848512.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"13","productName":"李清照","productCode":"A","productImageHave":"/product/2019/09/627155682751152128.png","productImageLose":"/product/2019/09/627155689663365120.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"14","productName":"富察","productCode":"B","productImageHave":"/product/2019/09/627155714036465664.png","productImageLose":"/product/2019/09/627155729937072128.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"15","productName":"小美龄","productCode":"C","productImageHave":"/product/2019/09/627155749423808512.png","productImageLose":"/product/2019/09/627155755983699968.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"16","productName":"嫦娥","productCode":"D","productImageHave":"/product/2019/09/627155779220144128.png","productImageLose":"/product/2019/09/627155786467901440.png","productType":"0","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null}],"userToyDiyList":null},{"productSeriesType":null,"userId":null,"productSeriesId":"2","productSeriesName":"ABC","productSeriesCode":"ABC","productSeriesRemark":null,"productSeriesImage":"/productSeries/2019/10/632528258499346432.png","productSeriesImageWeChat":"/productSeries/2019/10/632528267026366464.png","drawBoxUrl":"","shoppingUrl":"","productList":[],"userToyDiyList":null}]
     * error_msg :
     */

    private int code;
    private String error_msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * productSeriesType : null
         * userId : null
         * productSeriesId : 1
         * productSeriesName : 今夕何夕
         * productSeriesCode : ZA
         * productSeriesRemark : null
         * productSeriesImage : /productSeries/2019/09/627155229569187840.png
         * productSeriesImageWeChat : /productSeries/2019/09/627155245893419008.png
         * drawBoxUrl :
         * shoppingUrl :
         * productList : [{"productId":"4","productName":"西施","productCode":"1","productImageHave":"/product/2019/09/627155353267601408.png","productImageLose":"/product/2019/09/627155362172108800.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"5","productName":"芈月","productCode":"2","productImageHave":"/product/2019/09/627155388646555648.png","productImageLose":"/product/2019/09/627155396141776896.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"6","productName":"卫子夫","productCode":"3","productImageHave":"/product/2019/09/627155417725665280.png","productImageLose":"/product/2019/09/627155425313161216.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"7","productName":"王昭君","productCode":"4","productImageHave":"/product/2019/09/627155469961527296.png","productImageLose":"/product/2019/09/627155477049901056.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"8","productName":"蔡文姬","productCode":"5","productImageHave":"/product/2019/09/627155508918222848.png","productImageLose":"/product/2019/09/627155516518301696.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"9","productName":"貂蝉","productCode":"6","productImageHave":"/product/2019/09/627155537175248896.png","productImageLose":"/product/2019/09/627155547505819648.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"10","productName":"花木兰","productCode":"7","productImageHave":"/product/2019/09/627155576807227392.png","productImageLose":"/product/2019/09/627155584117899264.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"11","productName":"武则天","productCode":"8","productImageHave":"/product/2019/09/627155614589517824.png","productImageLose":"/product/2019/09/627155621501730816.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"12","productName":"杨玉环","productCode":"9","productImageHave":"/product/2019/09/627155653583962112.png","productImageLose":"/product/2019/09/627155660294848512.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"13","productName":"李清照","productCode":"A","productImageHave":"/product/2019/09/627155682751152128.png","productImageLose":"/product/2019/09/627155689663365120.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"14","productName":"富察","productCode":"B","productImageHave":"/product/2019/09/627155714036465664.png","productImageLose":"/product/2019/09/627155729937072128.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"15","productName":"小美龄","productCode":"C","productImageHave":"/product/2019/09/627155749423808512.png","productImageLose":"/product/2019/09/627155755983699968.png","productType":"1","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null},{"productId":"16","productName":"嫦娥","productCode":"D","productImageHave":"/product/2019/09/627155779220144128.png","productImageLose":"/product/2019/09/627155786467901440.png","productType":"0","productSeriesId":"1","userToyList":null,"haveUserCount":null,"userId":null,"displayName":null,"avatar":null,"userWantsCount":null,"userHaveToyRankingsList":null}]
         * userToyDiyList : null
         */

        private Object productSeriesType;
        private Object userId;
        private String productSeriesId;
        private String productSeriesName;
        private String productSeriesCode;
        private Object productSeriesRemark;
        private String productSeriesImage;
        private String productSeriesImageWeChat;
        private String drawBoxUrl;
        private String shoppingUrl;
        private Object userToyDiyList;
        private List<ProductListBean> productList;

        public Object getProductSeriesType() {
            return productSeriesType;
        }

        public void setProductSeriesType(Object productSeriesType) {
            this.productSeriesType = productSeriesType;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getProductSeriesId() {
            return productSeriesId;
        }

        public void setProductSeriesId(String productSeriesId) {
            this.productSeriesId = productSeriesId;
        }

        public String getProductSeriesName() {
            return productSeriesName;
        }

        public void setProductSeriesName(String productSeriesName) {
            this.productSeriesName = productSeriesName;
        }

        public String getProductSeriesCode() {
            return productSeriesCode;
        }

        public void setProductSeriesCode(String productSeriesCode) {
            this.productSeriesCode = productSeriesCode;
        }

        public Object getProductSeriesRemark() {
            return productSeriesRemark;
        }

        public void setProductSeriesRemark(Object productSeriesRemark) {
            this.productSeriesRemark = productSeriesRemark;
        }

        public String getProductSeriesImage() {
            return productSeriesImage;
        }

        public void setProductSeriesImage(String productSeriesImage) {
            this.productSeriesImage = productSeriesImage;
        }

        public String getProductSeriesImageWeChat() {
            return productSeriesImageWeChat;
        }

        public void setProductSeriesImageWeChat(String productSeriesImageWeChat) {
            this.productSeriesImageWeChat = productSeriesImageWeChat;
        }

        public String getDrawBoxUrl() {
            return drawBoxUrl;
        }

        public void setDrawBoxUrl(String drawBoxUrl) {
            this.drawBoxUrl = drawBoxUrl;
        }

        public String getShoppingUrl() {
            return shoppingUrl;
        }

        public void setShoppingUrl(String shoppingUrl) {
            this.shoppingUrl = shoppingUrl;
        }

        public Object getUserToyDiyList() {
            return userToyDiyList;
        }

        public void setUserToyDiyList(Object userToyDiyList) {
            this.userToyDiyList = userToyDiyList;
        }

        public List<ProductListBean> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListBean> productList) {
            this.productList = productList;
        }

        public static class ProductListBean implements Serializable{
            /**
             * productId : 4
             * productName : 西施
             * productCode : 1
             * productImageHave : /product/2019/09/627155353267601408.png
             * productImageLose : /product/2019/09/627155362172108800.png
             * productType : 1
             * productSeriesId : 1
             * userToyList : null
             * haveUserCount : null
             * userId : null
             * displayName : null
             * avatar : null
             * userWantsCount : null
             * userHaveToyRankingsList : null
             */

            private String productId;
            private String productName;
            private String productCode;
            private String productImageHave;
            private String productImageLose;
            private String productType;
            private String productSeriesId;
            private Object userToyList;
            private Object haveUserCount;
            private Object userId;
            private Object displayName;
            private Object avatar;
            private Object userWantsCount;
            private Object userHaveToyRankingsList;

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

            public Object getUserToyList() {
                return userToyList;
            }

            public void setUserToyList(Object userToyList) {
                this.userToyList = userToyList;
            }

            public Object getHaveUserCount() {
                return haveUserCount;
            }

            public void setHaveUserCount(Object haveUserCount) {
                this.haveUserCount = haveUserCount;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public Object getDisplayName() {
                return displayName;
            }

            public void setDisplayName(Object displayName) {
                this.displayName = displayName;
            }

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public Object getUserWantsCount() {
                return userWantsCount;
            }

            public void setUserWantsCount(Object userWantsCount) {
                this.userWantsCount = userWantsCount;
            }

            public Object getUserHaveToyRankingsList() {
                return userHaveToyRankingsList;
            }

            public void setUserHaveToyRankingsList(Object userHaveToyRankingsList) {
                this.userHaveToyRankingsList = userHaveToyRankingsList;
            }
        }
    }
}
