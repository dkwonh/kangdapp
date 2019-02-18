package kangwon.cs.kangdapp;

/**
 * Created by WH on 2016-09-13.
 */
public class BusData {
    String number;
    String waitTime;
    String currentPosition;
    String remainPosition;
    public BusData(String n, String w, String c, String r){
        this.number = n;
        this.waitTime = w;
        this.currentPosition = c;
        this.remainPosition = r;
    }
}
