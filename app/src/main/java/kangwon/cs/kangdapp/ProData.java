package kangwon.cs.kangdapp;

import android.graphics.Bitmap;

/**
 * Created by WH on 2016-11-09.
 */

class ProData{
    Bitmap img;
    String name;
    String email;
    String number;
    ProData(Bitmap i, String n, String e, String nu){
        this.img = i;
        this.name = n;
        this.email = e;
        this.number = nu;
    }
}