package com.android.t440p.photo.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Login {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("pass")
    @Expose
    private String pass; // open password! ;)
    public Login(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}