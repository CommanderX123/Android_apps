
package com.example.lab1;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Main implements Parcelable
{

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("feels_like")
    @Expose
    private double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @SerializedName("pressure")
    @Expose
    private int pressure;
    @SerializedName("sea_level")
    @Expose
    private int seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private int grndLevel;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("temp_kf")
    @Expose
    private double tempKf;
    public final static Parcelable.Creator<Main> CREATOR = new Creator<Main>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Main createFromParcel(Parcel in) {
            Main instance = new Main();
            instance.temp = ((double) in.readValue((double.class.getClassLoader())));
            instance.feelsLike = ((double) in.readValue((double.class.getClassLoader())));
            instance.tempMin = ((double) in.readValue((double.class.getClassLoader())));
            instance.tempMax = ((double) in.readValue((double.class.getClassLoader())));
            instance.pressure = ((int) in.readValue((int.class.getClassLoader())));
            instance.seaLevel = ((int) in.readValue((int.class.getClassLoader())));
            instance.grndLevel = ((int) in.readValue((int.class.getClassLoader())));
            instance.humidity = ((int) in.readValue((int.class.getClassLoader())));
            instance.tempKf = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Main[] newArray(int size) {
            return (new Main[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The temp
     */
    public double getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * 
     * @return
     *     The feelsLike
     */
    public double getFeelsLike() {
        return feelsLike;
    }

    /**
     * 
     * @param feelsLike
     *     The feels_like
     */
    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    /**
     * 
     * @return
     *     The tempMin
     */
    public double getTempMin() {
        return tempMin;
    }

    /**
     * 
     * @param tempMin
     *     The temp_min
     */
    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * 
     * @return
     *     The tempMax
     */
    public double getTempMax() {
        return tempMax;
    }

    /**
     * 
     * @param tempMax
     *     The temp_max
     */
    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The seaLevel
     */
    public int getSeaLevel() {
        return seaLevel;
    }

    /**
     * 
     * @param seaLevel
     *     The sea_level
     */
    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    /**
     * 
     * @return
     *     The grndLevel
     */
    public int getGrndLevel() {
        return grndLevel;
    }

    /**
     * 
     * @param grndLevel
     *     The grnd_level
     */
    public void setGrndLevel(int grndLevel) {
        this.grndLevel = grndLevel;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The tempKf
     */
    public double getTempKf() {
        return tempKf;
    }

    /**
     * 
     * @param tempKf
     *     The temp_kf
     */
    public void setTempKf(int tempKf) {
        this.tempKf = tempKf;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(feelsLike);
        dest.writeValue(tempMin);
        dest.writeValue(tempMax);
        dest.writeValue(pressure);
        dest.writeValue(seaLevel);
        dest.writeValue(grndLevel);
        dest.writeValue(humidity);
        dest.writeValue(tempKf);
    }

    public int describeContents() {
        return  0;
    }

}
