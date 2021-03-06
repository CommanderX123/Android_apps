
package com.example.lab1;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Rain implements Parcelable
{

    @SerializedName("3h")
    @Expose
    private double _3h;
    public final static Parcelable.Creator<Rain> CREATOR = new Creator<Rain>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Rain createFromParcel(Parcel in) {
            Rain instance = new Rain();
            instance._3h = ((double) in.readValue((double.class.getClassLoader())));
            return instance;
        }

        public Rain[] newArray(int size) {
            return (new Rain[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The _3h
     */
    public double get3h() {
        return _3h;
    }

    /**
     * 
     * @param _3h
     *     The 3h
     */
    public void set3h(double _3h) {
        this._3h = _3h;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_3h);
    }

    public int describeContents() {
        return  0;
    }

}
