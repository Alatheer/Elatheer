package com.example.elashry.elatheer.Models;

/**
 * Created by ok on 21/08/2017.
 */

public class FhrsaModel {

    private String ftitle;
    private String fimage;

    public FhrsaModel() {
    }

    public FhrsaModel(String ftitle, String fimage) {
        this.ftitle = ftitle;
        this.fimage = fimage;
    }

    public String getFtitle() {
        return ftitle;
    }

    public String getFimage() {
        return fimage;
    }
}
