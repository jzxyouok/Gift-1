package com.example.hrr.gift.entity;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Created by HRR on 2016/6/14.
 */
public class ButtomChange {
   private ImageView img;
    private int before;
    private int after;
    private Fragment change;

    public ButtomChange(ImageView img, int before, int after, Fragment change) {
        this.img = img;
        this.before = before;
        this.after = after;
        this.change = change;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    public Fragment getChange() {
        return change;
    }

    public void setChange(Fragment change) {
        this.change = change;
    }

    @Override
    public String toString() {
        return "ButtomChange{" +
                "img=" + img +
                ", before=" + before +
                ", after=" + after +
                ", change=" + change +
                '}';
    }
}
