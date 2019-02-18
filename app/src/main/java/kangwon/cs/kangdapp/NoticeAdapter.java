package kangwon.cs.kangdapp;

import android.content.Context;

import android.support.v7.widget.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WH on 2016-09-09.
 */
public class NoticeAdapter extends BaseAdapter {
    private Context mContext = null;
    private ArrayList<ListData> mListData = new ArrayList<>();

    public NoticeAdapter(Context mCotext){
        super();
        this.mContext = mCotext;
    }

    @Override
    public int getCount(){
        return mListData.size();
    }
    @Override
    public Object getItem(int position){
        return mListData.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    public void clear(){
        mListData.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.test_item, null);

        holder.mTitle = (TextView) convertView.findViewById(R.id.item_title);
        holder.mDate = (TextView) convertView.findViewById(R.id.date);

        convertView.setTag(holder);
    }else{
        holder = (ViewHolder) convertView.getTag();
    }

    ListData mData = mListData.get(position);

    holder.mTitle.setText(mData.text);
    holder.mDate.setText(mData.date);
        //Log.d("TAG",mData.text+mData.date);

    return convertView;
}

    public class ViewHolder{
        public TextView mTitle;
        public TextView mDate;
    }

    public void addItem(String mTitle, String mDate){
        ListData addInfo = null;
        addInfo = new ListData(mTitle,mDate);
        mListData.add(addInfo);

        notifyDataSetChanged();
    }

}
