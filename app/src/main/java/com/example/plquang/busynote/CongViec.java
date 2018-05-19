package com.example.plquang.busynote;



public class CongViec {
    private int iDCV;
    private  String TenCV;
    public int getiDCV() {
        return iDCV;
    }

    public void setiDCV(int iDCV) {
        this.iDCV = iDCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String tenCV) {
        TenCV = tenCV;
    }


    public CongViec(int iDCV, String tenCV) {
        this.iDCV = iDCV;
        TenCV = tenCV; // cmt
    }


}
