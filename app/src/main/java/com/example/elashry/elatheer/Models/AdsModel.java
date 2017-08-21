package com.example.elashry.elatheer.Models;

/**
 * Created by ok on 21/08/2017.
 */

public class AdsModel {
    private String Adsimage;
    private String AdsTitle;

    public String getAdsTitle() {
        return AdsTitle;
    }

    public AdsModel(String adsimage, String adscontent, String adsTitle) {
        Adsimage = adsimage;
        Adscontent = adscontent;

        AdsTitle = adsTitle;
    }

    public String getAdsimage() {
        return Adsimage;
    }

    public String getAdscontent() {
        return Adscontent;
    }

    private String Adscontent;
}
