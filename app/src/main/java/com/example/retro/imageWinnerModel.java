package com.example.retro;

import java.util.Date;

public class imageWinnerModel {
    public String getImagename() {

        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    String imagename;
    String imageurl;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Date date;

}
