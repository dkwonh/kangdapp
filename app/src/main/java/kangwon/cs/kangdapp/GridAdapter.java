package kangwon.cs.kangdapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by KHJ on 2016-10-30.
 */
public class GridAdapter extends BaseAdapter {
    private final List<String> list;
    private Calendar mCal;
    private final LayoutInflater inflater;
    private int mon;
    private final String TAG = "TAG2";

    /**
     *
     * @param context
     * @param list
     */
    public GridAdapter(Context context, List<String> list, int month) {
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mon = month;
    }

    public GridAdapter(Context context, List<String> list) {
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_calendar_gridview, parent, false);
            holder = new ViewHolder();

            holder.tvItemGridView = (TextView)convertView.findViewById(R.id.tv_item_gridview);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tvItemGridView.setText("" + getItem(position));

        mCal = Calendar.getInstance();
        final SimpleDateFormat curMonFormat = new SimpleDateFormat("MM", Locale.KOREA);
        Integer today = mCal.get(Calendar.DAY_OF_MONTH);
        String sToday = String.valueOf(today);
        long now = System.currentTimeMillis();
        final Date date = new Date(now);
        //Log.d(TAG, curMonFormat.format(date) + "  "  + mon);
        if (sToday.equals(getItem(position)) && mon + 2 == Integer.parseInt(curMonFormat.format(date))) {
            holder.tvItemGridView.setTextColor(Color.parseColor("#000000"));
        } else if(position == 0 || position == 7 || position == 14 || position == 21 || position == 28 || position == 35 || position == 42) {
            holder.tvItemGridView.setTextColor(Color.parseColor("#FF0000"));
        } else if(position == 6 || position == 13 || position == 20 || position == 27 || position == 34 || position == 41 || position == 48) {
            holder.tvItemGridView.setTextColor(Color.parseColor("#0000FF"));
        }
        return convertView;
    }
    private class ViewHolder {
        TextView tvItemGridView;
    }
}

