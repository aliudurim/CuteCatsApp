package com.durimaliu.cutecatsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Random;

/**
 * Created by durim on 6/12/16.
 *
 */
public class Cat {

    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("background_color")
    @Expose
    private String backgroundColor;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("intelligence")
    @Expose
    private String intelligence;
    @SerializedName("playfulness")
    @Expose
    private String playfulness;
    @SerializedName("craziness")
    @Expose
    private String craziness;
    @SerializedName("friendliness")
    @Expose
    private String friendliness;
    @SerializedName("happiness")
    @Expose
    private String happiness;
    @SerializedName("agility")
    @Expose
    private String agility;
    @SerializedName("stretchiness")
    @Expose
    private String stretchiness;
    @SerializedName("funniness")
    @Expose
    private String funniness;
    @SerializedName("tediousness")
    @Expose
    private String tediousness;

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     *
     * @param backgroundColor
     * The background_color
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     *
     * @return
     * The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     * The intelligence
     */
    public String getIntelligence() {
        return intelligence;
    }

    /**
     *
     * @param intelligence
     * The intelligence
     */
    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    /**
     *
     * @return
     * The playfulness
     */
    public String getPlayfulness() {
        return playfulness;
    }

    /**
     *
     * @param playfulness
     * The playfulness
     */
    public void setPlayfulness(String playfulness) {
        this.playfulness = playfulness;
    }

    /**
     *
     * @return
     * The craziness
     */
    public String getCraziness() {
        return craziness;
    }

    /**
     *
     * @param craziness
     * The craziness
     */
    public void setCraziness(String craziness) {
        this.craziness = craziness;
    }

    /**
     *
     * @return
     * The friendliness
     */
    public String getFriendliness() {
        return friendliness;
    }

    /**
     *
     * @param friendliness
     * The friendliness
     */
    public void setFriendliness(String friendliness) {
        this.friendliness = friendliness;
    }

    /**
     *
     * @return
     * The happiness
     */
    public String getHappiness() {
        return happiness;
    }

    /**
     *
     * @param happiness
     * The happiness
     */
    public void setHappiness(String happiness) {
        this.happiness = happiness;
    }

    /**
     *
     * @return
     * The agility
     */
    public String getAgility() {
        return agility;
    }

    /**
     *
     * @param agility
     * The agility
     */
    public void setAgility(String agility) {
        this.agility = agility;
    }

    /**
     *
     * @return
     * The stretchiness
     */
    public String getStretchiness() {
        return stretchiness;
    }

    /**
     *
     * @param stretchiness
     * The stretchiness
     */
    public void setStretchiness(String stretchiness) {
        this.stretchiness = stretchiness;
    }

    /**
     *
     * @return
     * The funniness
     */
    public String getFunniness() {
        return funniness;
    }

    /**
     *
     * @param funniness
     * The funniness
     */
    public void setFunniness(String funniness) {
        this.funniness = funniness;
    }

    /**
     *
     * @return
     * The tediousness
     */
    public String getTediousness() {
        return tediousness;
    }

    /**
     *
     * @param tediousness
     * The tediousness
     */
    public void setTediousness(String tediousness) {
        this.tediousness = tediousness;
    }

    public boolean isValid(){
        return ((getPlayfulness() != null || getCraziness() != null) && getTediousness() != null)
                || (getPlayfulness() == null && getCraziness() == null && getTediousness() == null);
    }
}
