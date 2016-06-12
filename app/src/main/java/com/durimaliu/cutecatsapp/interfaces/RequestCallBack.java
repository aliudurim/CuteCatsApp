package com.durimaliu.cutecatsapp.interfaces;

import com.durimaliu.cutecatsapp.model.Cats;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by durim on 6/12/16.
 *
 */
public interface RequestCallBack {

    @GET("cute-cats/kitties.json")
    Call<Cats> getCats();
}
