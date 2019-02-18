package kangwon.cs.kangdapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;


/**
 * Created by WH on 2016-09-06.
 */
public class Notice2 extends Fragment {
    //private SchoolNotice schoolNotice = new SchoolNotice();
    protected static ProgressBar progressBar;
    protected ArrayAdapter<String> mAdapter;
    protected static NoticeParser noticeParser;
    protected NoticeAdapter noticeAdapter;
    protected ListData mData;
    int index = 1;
    ListView SNList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.snl2, container, false);
        Log.d("TAG","Notice2");
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar5);
        noticeAdapter = new NoticeAdapter(getActivity());
        noticeParser = new NoticeParser(1,noticeAdapter,"8");
        SNList = (ListView)v.findViewById(R.id.listView3);
        SNList.setAdapter(noticeAdapter);

        SNList.setOnScrollListener(new ScrollListener());

        SNList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                mData = noticeParser.newList.get(position);
                String selURL = mData.URL;
                String selTile = mData.text;

                Intent intent = new Intent(getActivity(),Webview.class);
                intent.putExtra("url",selURL);
                intent.putExtra("title",selTile);
                startActivity(intent);
            }
        });
        noticeParser.page="8";

        noticeParser.jsoupAsyncTask.execute();


        return v;
    }

    boolean lastitemVisibleFalg = false;
    public class ScrollListener implements AbsListView.OnScrollListener{
        @Override
        public void onScroll(AbsListView view, int firstItem, int itemCount, int totalCount){
            lastitemVisibleFalg = (totalCount>0)&&(firstItem + itemCount >=totalCount);
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState){
            if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastitemVisibleFalg){
                index++;
                //Log.d(TAG,String.valueOf(index));
                noticeParser.mList.clear();
                noticeParser.page = "8";
                noticeParser.luncher(index);
            }
        }
    }
}
