package com.lmc.allpeople_tv.bean;

/**
 * 作者：Created by ${李泰亲} on 2017/1/6 21:42.
 * 邮箱：15711299361@163.com
 * 模块：
 */

public class MStoriesBean {
    private String url;
    private String title;

    public MStoriesBean() {
    }

    public MStoriesBean(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
