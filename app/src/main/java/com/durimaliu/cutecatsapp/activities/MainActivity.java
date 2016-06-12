package com.durimaliu.cutecatsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.durimaliu.cutecatsapp.R;
import com.durimaliu.cutecatsapp.adapter.CatAdapter;
import com.durimaliu.cutecatsapp.interfaces.RequestCallBack;
import com.durimaliu.cutecatsapp.model.Cats;
import com.durimaliu.cutecatsapp.utilities.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    @Bind(R.id.listForCats)
    RecyclerView listForCats;

    CatAdapter catAdapter;

    RecyclerView.LayoutManager mLayoutManager;


    RequestCallBack reqCall;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRetrofit();

        setUpRecyclerView();

        if (Utils.isNetworkAvailable(getApplicationContext())) {
            callTask();
        } else {
            Toast.makeText(MainActivity.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
        }
    }

    private void initRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(Utils.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        reqCall = retrofit.create(RequestCallBack.class);
    }

    private void setUpRecyclerView() {

        listForCats.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        listForCats.setLayoutManager(mLayoutManager);

        catAdapter = new CatAdapter(getApplicationContext());
        listForCats.setAdapter(catAdapter);

    }

    private void callTask() {

        progressBar.setVisibility(View.VISIBLE);
        Call<Cats> call = reqCall.getCats();
        call.enqueue(new Callback<Cats>() {
            @Override
            public void onResponse(Call<Cats> call, Response<Cats> response) {

                progressBar.setVisibility(View.GONE);

                if (response.code() == 200) {
                    if (response.body() != null) {

                        catAdapter.setCats(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Cats> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, R.string.internal_error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
