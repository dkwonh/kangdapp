package kangwon.cs.kangdapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WH on 2016-11-09.
 */

public class ProfessorAdapter extends BaseAdapter {
    private Context mContext = null;
    private ArrayList<ProData> mListData = new ArrayList<>();
    public ProfessorAdapter(Context context){
        super();
        this.mContext = context;
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
            convertView = inflater.inflate(R.layout.professor_item, null);


            holder.bigImg = (ImageView) convertView.findViewById(R.id.imageView);
            holder.bigname = (TextView) convertView.findViewById(R.id.pro_name);
            holder.bigexp = (TextView)convertView.findViewById(R.id.pro_mail);
            holder.bigarr = (TextView) convertView.findViewById(R.id.pro_number);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ProData mData = mListData.get(position);
        holder.bigImg.setImageBitmap(mData.img);
        holder.bigname.setText(mData.name);
        holder.bigexp.setText(mData.email);
        holder.bigarr.setText(mData.number);
        //Log.d("TAG",mData.text+mData.date);

        return convertView;
    }

    private class ViewHolder{
         ImageView bigImg;
         TextView bigname;
         TextView bigexp;
         TextView bigarr;
    }

    public void addItem(Bitmap img, String name, String email, String number){
        ProData addInfo;
        addInfo = new ProData(img,name,email,number);
        mListData.add(addInfo);

        notifyDataSetChanged();
    }
}
