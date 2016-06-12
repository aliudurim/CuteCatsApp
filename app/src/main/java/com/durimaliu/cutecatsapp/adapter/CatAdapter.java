package com.durimaliu.cutecatsapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.durimaliu.cutecatsapp.R;
import com.durimaliu.cutecatsapp.model.Cat;
import com.durimaliu.cutecatsapp.model.Cats;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by durim on 6/12/16.
 * 
 */
public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private Cats cats = new Cats();
    private Context context;

    public CatAdapter(Context context) {
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.cardView)
        CardView cardView;

        @Bind(R.id.imgForCats)
        ImageView imgForCats;

        @Bind(R.id.txtNotes)
        TextView txtNotes;

        @Bind(R.id.txtIntelligence)
        TextView txtIntelligence;

        @Bind(R.id.txtPlayfulness)
        TextView txtPlayfulness;

        @Bind(R.id.txtCraziness)
        TextView txtCraziness;

        @Bind(R.id.txtFriendliness)
        TextView txtFriendliness;

        @Bind(R.id.txtHappiness)
        TextView txtHappiness;

        @Bind(R.id.txtAgility)
        TextView txtAgility;

        @Bind(R.id.txtStretchiness)
        TextView txtStretchiness;

        @Bind(R.id.txtFunniness)
        TextView txtFunniness;

        @Bind(R.id.txtTediousness)
        TextView txtTediousness;

        @Bind(R.id.llIntelligence)
        LinearLayout llIntelligence;

        @Bind(R.id.llPlayfulness)
        LinearLayout llPlayfulness;

        @Bind(R.id.llCraziness)
        LinearLayout llCraziness;

        @Bind(R.id.llFriendliness)
        LinearLayout llFriendliness;

        @Bind(R.id.llHappiness)
        LinearLayout llHappiness;

        @Bind(R.id.llAgility)
        LinearLayout llAgility;

        @Bind(R.id.llStretchiness)
        LinearLayout llStretchiness;

        @Bind(R.id.llFunniness)
        LinearLayout llFunniness;

        @Bind(R.id.llTediousness)
        LinearLayout llTediousness;

        @Bind(R.id.viewValid)
        RelativeLayout viewValid;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public CatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_for_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CatAdapter.ViewHolder holder, int position) {

        Cat cat = getCats().getCats().get(position);

        Glide.with(context)
                .load(cat.getImageUrl())
                .placeholder(R.mipmap.placeholder)
                .error(R.mipmap.placeholder)
                .into(holder.imgForCats);


        if (cat.isValid()) {
            holder.viewValid.setVisibility(View.VISIBLE);
        } else {
            holder.viewValid.setVisibility(View.GONE);
        }

        holder.cardView.setCardBackgroundColor(Color.parseColor(getCats().getCats().get(position).getBackgroundColor()));

        holder.txtNotes.setText(getCats().getCats().get(position).getNotes());

        showField(cat.getIntelligence(), holder.txtIntelligence, holder.llIntelligence);
        showField(cat.getPlayfulness(), holder.txtPlayfulness, holder.llPlayfulness);
        showField(cat.getCraziness(), holder.txtCraziness, holder.llCraziness);
        showField(cat.getFriendliness(), holder.txtFriendliness, holder.llFriendliness);
        showField(cat.getHappiness(), holder.txtHappiness, holder.llHappiness);
        showField(cat.getAgility(), holder.txtAgility, holder.llAgility);
        showField(cat.getStretchiness(), holder.txtStretchiness, holder.llStretchiness);
        showField(cat.getFunniness(), holder.txtFunniness, holder.llFunniness);
        showField(cat.getTediousness(), holder.txtTediousness, holder.llTediousness);
    }

    @Override
    public int getItemCount() {
        return getCats().getCats().size();
    }


    private void showField(String text, TextView textView, LinearLayout linearLayout) {
        if (text == null) {
            linearLayout.setVisibility(View.GONE);
        } else {
            linearLayout.setVisibility(View.VISIBLE);
            textView.setText(text);
        }
    }

    public void setCats(Cats cats) {
        this.cats = cats;
        notifyDataSetChanged();
    }

    public Cats getCats() {
        return cats;
    }
}
