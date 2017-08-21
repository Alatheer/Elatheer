package com.example.elashry.elatheer.Models;

/**
 * Created by ok on 21/08/2017.
 */

public class DesignModel {

    private String dtitle;
    private String dimage;

    public DesignModel() {
    }

    public DesignModel(String dtitle, String dimage) {
        this.dtitle = dtitle;
        this.dimage = dimage;
    }

    public String getDtitle() {
        return dtitle;
    }

    public String getDimage() {
        return dimage;
    }
}
