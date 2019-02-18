package kangwon.cs.kangdapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WH on 2016-10-29.
 */
public class BigListAdapter extends BaseAdapter {
    private Context mContext = null;
    private ArrayList<BigListData> mListData = new ArrayList<>();

    public BigListAdapter(Context mCotext){
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
            convertView = inflater.inflate(R.layout.big_item, null);

            holder.bigImg = (ImageView) convertView.findViewById(R.id.big_item_img);
            holder.bigname = (TextView) convertView.findViewById(R.id.big_item_name);
            holder.bigexp = (TextView)convertView.findViewById(R.id.big_item_explain);
            holder.bigarr = (ImageView)convertView.findViewById(R.id.big_item_arrow);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        BigListData mData = mListData.get(position);

        holder.bigImg.setImageResource(mData.img);
        holder.bigname.setText(mData.name);
        holder.bigexp.setText(mData.exp);
        holder.bigarr.setImageResource(mData.arr);
        //Log.d("TAG",mData.text+mData.date);

        return convertView;
    }

    public class ViewHolder{
        public ImageView bigImg;
        public TextView bigname;
        public TextView bigexp;
        public ImageView bigarr;
    }

    public void addItem(int img, String name, String exp, int arr){
        BigListData addInfo = null;
        addInfo = new BigListData(img,name,exp,arr);
        mListData.add(addInfo);

        notifyDataSetChanged();
    }

}
