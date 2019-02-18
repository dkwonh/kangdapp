package kangwon.cs.kangdapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.GridView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by KHJ on 2016-10-30.
 */
public class SchoolCalendarFragment extends Fragment {
    private GridAdapter gridAdapter;
    private ArrayList<String> dayList;
    private GridView gridView;
    private Calendar mCal;
    public String string;
    private final String TAG = "TAG";
    int position;
    protected CalendarParser calendarParser;
    protected WebView webview;

    public static SchoolCalendarFragment newInstance(int i) {
        SchoolCalendarFragment S = new SchoolCalendarFragment();
        Bundle args = new Bundle();
        args.putInt("position",i);
        S.setArguments(args);
        return S;
    }

    public int getShownIndex() {
        return getArguments().getInt("position", 0);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.school_calendar_num, container, false);
        position = getShownIndex();
        webview = (WebView)v.findViewById(R.id.webView11);
        calendarParser = new CalendarParser(webview, position + 1);

        //tvDate = (TextView)findViewById(R.id.tv_date);
        gridView = (GridView)v.findViewById(R.id.gridview);

        long now = System.currentTimeMillis();
        final Date date = new Date(now);

        final SimpleDateFormat curYearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);
        final SimpleDateFormat curMonthFormat = new SimpleDateFormat("MM", Locale.KOREA);
        final SimpleDateFormat curDayFormat = new SimpleDateFormat("dd", Locale.KOREA);

        dayList = new ArrayList<String>();
        mCal = Calendar.getInstance();

        mCal.set(Integer.parseInt(curYearFormat.format(date)), position + 1, 1);
        int dayNum = mCal.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < dayNum; i++) {
            dayList.add("");
        }

        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position <= 5 + mCal.get(Calendar.DAY_OF_WEEK))
                    gridView.setSelection(gridView.getSelectedItemPosition() + 1);
            }
        });*/
        setCalendarDate(mCal.get(Calendar.MONTH) + 1);

        gridAdapter = new GridAdapter(v.getContext(), dayList, position);
        gridView.setAdapter(gridAdapter);
        calendarParser.jsoupAsyncTask.execute();

        return v;
    }

    private void setCalendarDate(int month) {
        mCal.set(Calendar.MONTH, month - 1);

        for (int i = 0; i < mCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            dayList.add("" + (i + 1));
        }
    }
}
