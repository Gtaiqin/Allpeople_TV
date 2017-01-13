package com.lmc.allpeople_tv.bean;

import java.util.List;

/**
 * 作者：Created by ${李泰亲} on 2017/1/12 9:50.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class WeixinBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-12","title":"你有资格认命吗","description":"新世相","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5ROs96OaibIn1BOcicFoIUlibZuf95ybpZwV0HwFSw3IqAqtef8ibCn9haw4w2Mk9ic27yib9dPXzILUEDqTqqPm09cw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/H44Vf4L47oIm21fA84MGwQ"},{"ctime":"2017-01-12","title":"非要劝酒，你不喝他还不高兴？这种人还能不能做朋友啦！","description":"果壳网","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/icZklJrRfHgDVVYRDsLA7BOicecF5nvXvz0wNwAGSibOQM3rnE3jhndQrqWCDWjAAQHZtBiazsHwiclkyCano6D21Ww/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/EIDGoSr-AfTaN_CKZJcp5g"},{"ctime":"2017-01-11","title":"罗玉凤：求祝福，求鼓励","description":"我就是凤姐","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/LXUzxjZKhjpacnDo8Hspsq77Fgbf4h4Ceww6zicaQLlNY9Oh49LhKO0I6ybvyTLWaeOPb0ozyACZxqQ6C6Rh8eA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/gNZV-TSdVM96O4Mdln5KHQ"},{"ctime":"2017-01-10","title":"我为什么憎恨心灵鸡汤？","description":"快站服务","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/oibWjKibwj6b6PibnTyia2RxKKZ7gk8JQyWFbAroahVHNwiabFmlsAwGjsqPYc4qEKcuaLBEwI9icN2AqCwNAhODhawQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/lIslHWsBHiv49J5CtWSAdA"},{"ctime":"2017-01-10","title":"川普会见马云态度大变，称要一起做件了不起的大事！","description":"互联网新鲜事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/7rGQr7yPGJoUqopVfkXFlLRI16TGLRiaUzGsJzyV4MHxrnmL48biaNjQGhzO0Ho8XZic66eU5D0m3gdH5xZMicps2Q/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/IESqpqeXTcD0EKFMDgA0Dg"},{"ctime":"2017-01-10","title":"打脸梅姨，真相：川普从未嘲笑残疾记者","description":"丁辰灵","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/nC7NY1lbn4UgCFKQiawk4iapekX0YsCcaVKMsop2ga9PhdzENKZUtuTSHmdIkELvuf09PsZGgGSQthiaG8sxBWgicA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/_azkz9qcKf1WYdlDCMLVXQ"},{"ctime":"2017-01-10","title":"支付宝，你就不能好好做个钱包吗？","description":"槽边往事","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/Ia6gU9JNtkq9H5fnfTIZVrwc18C2N38jr42Y2nNOv8j0Z2o2ibgyvYDGjaHtiaj3IOgptffiadFjJpjD1RRkpLwWw/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ntXvCzr6PzcjyZy__gHvLQ"},{"ctime":"2017-01-09","title":"陈思诚: 为什么好男人都出轨了","description":"二更食堂","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/qicBf6M59n3EDvR0wQRsuyOFfcZD8mTN8aRDmDyPDTRvicIzDH2QHovXcIcbuEJf8mkZ26t2qUWGzkeeqFmSQBEA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/wH7bSm1CUFD4yGlnCl9v5A"},{"ctime":"2017-01-09","title":"iPhone今天10岁了，它现在应该哭还是笑呢？","description":"腾讯科技","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIHIQHw699lFic2EbtTtmZQRPo1HHpmn44VbrKj3S7Us79Ld0I8P44ib9iaqnK8p9t5k1bA7Q6EQqia3hQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/xHMGL30UM0Ckmzp-wPefuQ"},{"ctime":"2017-01-09","title":"腾讯研究院给出了一份VR全景图：不止是元年和寒冬这么简单","description":"VR次元","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/pumUw5Nahv0iaEHCXVicdBs2ZR3g01Zu457U33hpY5vma3nn3CCP7ByXuAiaW2KJJzvhtoQVAHVdQVvJw46icd4FDA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/Qy2TLIHapDYtakpde3elhw"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-01-12
         * title : 你有资格认命吗
         * description : 新世相
         * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/5ROs96OaibIn1BOcicFoIUlibZuf95ybpZwV0HwFSw3IqAqtef8ibCn9haw4w2Mk9ic27yib9dPXzILUEDqTqqPm09cw/0?wx_fmt=jpeg
         * url : http://mp.weixin.qq.com/s/H44Vf4L47oIm21fA84MGwQ
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
