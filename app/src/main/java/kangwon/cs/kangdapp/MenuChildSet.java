package kangwon.cs.kangdapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-10-31.
 */
public class MenuChildSet {
    HashMap<String,List<String>> menu1;
    List<String> groupList;
    List<String> morningList, lunchList, deenerList, fixList;
    HashMap<String,List<String>> morning, lunch, deener, fix;
    public MenuChildSet(HashMap<String,List<String>> child, List<String> group, HashMap<String,List<String>> mornin, HashMap<String,List<String>> lunc, HashMap<String,List<String>> deene, HashMap<String,List<String>> fx) {
        this.menu1 = child;
        this.groupList = group;
        this.morning = mornin;
        this.lunch = lunc;
        this.deener = deene;
        this.fix = fx;

        morningList = new ArrayList<>();
        lunchList = new ArrayList<>();
        deenerList = new ArrayList<>();
        fixList = new ArrayList<>();
    }

    synchronized public void setChild() {
        morning.put("백반", menu1.get(groupList.get(0)));
        morning.put("탕정식", menu1.get(groupList.get(1)));


        lunch.put("교직원 - 중식", menu1.get(groupList.get(2)));
        lunch.put("백반", menu1.get(groupList.get(3)));
        lunch.put("특식", menu1.get(groupList.get(4)));

        deener.put("교직원 - 석식", menu1.get(groupList.get(5)));
        deener.put("백반", menu1.get(groupList.get(6)));
        deener.put("특식", menu1.get(groupList.get(7)));


        fix.put("양식 코너", menu1.get(groupList.get(8)));
        fix.put("중식 코너", menu1.get(groupList.get(9)));

    }
    }
