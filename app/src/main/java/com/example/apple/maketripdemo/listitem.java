package com.example.apple.maketripdemo;
import com.google.gson.annotations.SerializedName;

public class listitem {




    private String room;
    private String adult;
    private String adultA;
    private String child;
    private String childA;
    @SerializedName("show_A")
    private String show_A;
    @SerializedName("show_ch")
    private String show_ch;


    public listitem(String room,String adult,String ageA,String child,String chidA,String show_A,String show_ch){
        this.room=room;
        this.adult=adult;
        this.adultA=ageA;
        this.child=child;
        this.childA=chidA;
        this.show_A=show_A;
        this.show_ch=show_ch;

    }

    public String getAdult() {
        return adult;
    }

    public String getAdultA() {
        return adultA;
    }

    public String getChidA() {
        return childA;
    }

    public String getChild() {
        return child;
    }

    public String getRoom() {
        return room;
    }

    public String getShow_A() {
        return show_A;
    }

    public void setShow_A(String show_A) {
        this.show_A = show_A;
    }

    public String getShow_ch() {
        return show_ch;
    }

    public void setShow_ch(String show_ch) {
        this.show_ch = show_ch;
    }
}

