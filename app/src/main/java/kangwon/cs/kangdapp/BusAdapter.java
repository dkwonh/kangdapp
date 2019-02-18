package kangwon.cs.kangdapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WH on 2016-09-13.
 */
public class BusAdapter extends BaseAdapter{
    private Context mContext = null;
    private ArrayList<BusData> mListData = new ArrayList<>();

    public BusAdapter(Context mCotext){
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bus_item, null);

            holder.number = (TextView) convertView.findViewById(R.id.bus_number);
            holder.time = (TextView) convertView.findViewById(R.id.wait_time);
            holder.current = (TextView)convertView.findViewById(R.id.current);
            holder.remain = (TextView)convertView.findViewById(R.id.remain);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        BusData mData = mListData.get(position);

        holder.number.setText(mData.number);
        holder.time.setText(mData.waitTime);
        holder.current.setText(mData.currentPosition);
        holder.remain.setText(mData.remainPosition);
        //Log.d("TAG",mData.text+mData.date);

        return convertView;
    }

    public class ViewHolder{
        public TextView number;
        public TextView time;
        public TextView current;
        public TextView remain;
    }

    public void addItem(String num, String wait, String current, String remain){
        BusData addInfo = null;
        addInfo = new BusData(num,wait,current,remain);
        mListData.add(addInfo);

        notifyDataSetChanged();
    }

   public void addItem(String num, String first, String last, String vector, String temp){
        BusData addInfo = null;
        addInfo = new BusData(num,first,"","");
        mListData.add(addInfo);

        notifyDataSetChanged();
    }

}