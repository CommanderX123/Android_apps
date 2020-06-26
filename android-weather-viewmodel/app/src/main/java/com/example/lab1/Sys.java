
package com.example.lab1;

import javax.annotation.Generated;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Sys implements Parcelable
{

    @SerializedName("pod")
    @Expose
    private String pod;
    public final static Parcelable.Creator<Sys> CREATOR = new Creator<Sys>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sys createFromParcel(Parcel in) {
            Sys instance = new Sys();
            instance.pod = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Sys[] newArray(int size) {
            return (new Sys[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The pod
     */
    public String getPod() {
        return pod;
    }

    /**
     * 
     * @param pod
     *     The pod
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pod);
    }

    public int describeContents() {
        return  0;
    }

}
