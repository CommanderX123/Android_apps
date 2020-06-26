
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
public class OpenWeatherResponse implements Parcelable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private int message;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    @Valid
    private java.util.List<com.example.lab1.List> list = new ArrayList<com.example.lab1.List>();
    @SerializedName("city")
    @Expose
    @Valid
    private City city;
    public final static Parcelable.Creator<OpenWeatherResponse> CREATOR = new Creator<OpenWeatherResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OpenWeatherResponse createFromParcel(Parcel in) {
            OpenWeatherResponse instance = new OpenWeatherResponse();
            instance.cod = ((String) in.readValue((String.class.getClassLoader())));
            instance.message = ((int) in.readValue((int.class.getClassLoader())));
            instance.cnt = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.list, (com.example.lab1.List.class.getClassLoader()));
            instance.city = ((City) in.readValue((City.class.getClassLoader())));
            return instance;
        }

        public OpenWeatherResponse[] newArray(int size) {
            return (new OpenWeatherResponse[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * 
     * @param cod
     *     The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * 
     * @return
     *     The message
     */
    public int getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(int message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The cnt
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * 
     * @param cnt
     *     The cnt
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<com.example.lab1.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<com.example.lab1.List> list) {
        this.list = list;
    }

    /**
     * 
     * @return
     *     The city
     */
    public City getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }

    public int describeContents() {
        return  0;
    }

}
