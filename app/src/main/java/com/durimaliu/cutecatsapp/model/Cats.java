package com.durimaliu.cutecatsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by durim on 6/12/16.
 *
 */
public class Cats {

    @SerializedName("cats")
    @Expose
    private List<Cat> cats = new ArrayList<Cat>();

    /**
     *
     * @return
     * The cats
     */
    public List<Cat> getCats() {
        return cats;
    }

    /**
     *
     * @param cats
     * The cats
     */
    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
