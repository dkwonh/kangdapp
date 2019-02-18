package kangwon.cs.kangdapp;

/**
 * Created by KHJ on 2016-11-16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.util.ArrayList;

public class LocationListAdapter extends BaseAdapter {

    LayoutInflater mLayoutInflater;
    ArrayList<String> mListItems;
    Context mContext;

    public LocationListAdapter(Context context, ArrayList<String> listItems) {
        this.mContext = context;
        this.mListItems = listItems;

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mListItems.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.list_location_item, null);
            holder.textView = (TextView) convertView.findViewById(R.id.txt_location);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(mListItems.get(position).toString());
        notifyDataSetChanged();
        return convertView;
    }

    public Filter getFilter() {
        return ((MapList)mContext).new LocationFilter();
    }
    public Filter getFilter_(){
        return ((Professor)mContext).new LocationFilter();
    }

    public static class ViewHolder {
        public TextView textView;
    }

}