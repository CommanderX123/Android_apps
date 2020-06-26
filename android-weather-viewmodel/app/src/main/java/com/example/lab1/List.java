
package com.example.lab1;

import java.util.ArrayList;
import javax.annotation.Generated;
import javax.validation.Valid;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class List implements Parcelable
{

    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("main")
    @Expose
    @Valid
    private Main main;
    @SerializedName("weather")
    @Expose
    @Valid
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("clouds")
    @Expose
    @Valid
    private Clouds clouds;
    @SerializedName("wind")
    @Expose
    @Valid
    private Wind wind;
    @SerializedName("sys")
    @Expose
    @Valid
    private Sys sys;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;
    @SerializedName("rain")
    @Expose
    @Valid
    private Rain rain;
    @SerializedName("snow")
    @Expose
    @Valid
    private Snow snow;
    public final static Parcelable.Creator<List> CREATOR = new Creator<List>() {


        @SuppressWarnings({
            "unchecked"
        })
        public List createFromParcel(Parcel in) {
            List instance = new List();
            instance.dt = ((int) in.readValue((int.class.getClassLoader())));
            instance.main = ((Main) in.readValue((Main.class.getClassLoader())));
            in.readList(instance.weather, (com.example.lab1.Weather.class.getClassLoader()));
            instance.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
            instance.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
            instance.sys = ((Sys) in.readValue((Sys.class.getClassLoader())));
            instance.dtTxt = ((String) in.readValue((String.class.getClassLoader())));
            instance.rain = ((Rain) in.readValue((Rain.class.getClassLoader())));
            instance.snow = ((Snow) in.readValue((Snow.class.getClassLoader())));
            return instance;
        }

        public List[] newArray(int size) {
            return (new List[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The dt
     */
    public int getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    public void setDt(int dt) {
        this.dt = dt;
    }

    /**
     * 
     * @return
     *     The main
     */
    public Main getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * 
     * @return
     *     The sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * 
     * @param sys
     *     The sys
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * 
     * @return
     *     The dtTxt
     */
    public String getDtTxt() {
        return dtTxt;
    }

    /**
     * 
     * @param dtTxt
     *     The dt_txt
     */
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    /**
     * 
     * @return
     *     The rain
     */
    public Rain getRain() {
        return rain;
    }

    /**
     * 
     * @param rain
     *     The rain
     */
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    /**
     * 
     * @return
     *     The snow
     */
    public Snow getSnow() {
        return snow;
    }

    /**
     * 
     * @param snow
     *     The snow
     */
    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(dt);
        dest.writeValue(main);
        dest.writeList(weather);
        dest.writeValue(clouds);
        dest.writeValue(wind);
        dest.writeValue(sys);
        dest.writeValue(dtTxt);
        dest.writeValue(rain);
        dest.writeValue(snow);
    }

    public int describeContents() {
        return  0;
    }

}
