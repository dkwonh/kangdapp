package kangwon.cs.kangdapp;

/**
 * Created by WH on 2016-09-09.
 */
public class ListData {
    public String text;
    public String date;//8
    public String URL;

    public ListData(String text, String date, String URL){
        this.text = text;
        this.date = date;
        this.URL = URL;
    }

    public ListData(String text, String date){
        this.text = text;
        this.date = date;
    }

}
