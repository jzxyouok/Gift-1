package com.example.hrr.gift.entity;

/**
 * Created by HRR on 2016/6/13.
 */
public class Sift {
    private int imgid;
    private String content;
    private String url;

    public Sift(int imgid, String content, String url) {
        this.imgid = imgid;
        this.content = content;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sift{" +
                "imgid=" + imgid +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
