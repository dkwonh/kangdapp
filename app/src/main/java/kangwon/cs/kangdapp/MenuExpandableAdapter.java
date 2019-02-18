package kangwon.cs.kangdapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by WH on 2016-10-30.
 */
public class MenuExpandableAdapter extends BaseExpandableListAdapter {
    private List<String> groupList = null;
    private HashMap<String,List<String>> childList = null;
    private LayoutInflater inflater = null;
    private ViewHolder viewHolder = null;
    public MenuExpandableAdapter(Context c, List<String> groupList,
                             HashMap<String,List<String>> childList){
        super();
        this.inflater = LayoutInflater.from(c);
        this.groupList = groupList;
        this.childList = childList;
    }
    @Override
    public String getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    // 그룹 사이즈를 반환한다.
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    // 그룹 ID를 반환한다.
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // 그룹뷰 각각의 ROW
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.menu_list, parent, false);
            viewHolder.tv_groupName = (TextView) v.findViewById(R.id.menu_name);
            viewHolder.iv_image = (ImageView)v.findViewById(R.id.menu_list_img);
            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)v.getTag();
        }

        // 그룹을 펼칠때와 닫을때 아이콘을 변경해 준다.
        if(isExpanded){

            viewHolder.iv_image.setImageResource(R.drawable.ic_action_collapse);
        }else{
            viewHolder.iv_image.setImageResource(R.drawable.ic_action_expand);

        }

        viewHolder.tv_groupName.setText(getGroup(groupPosition));

        return v;
    }

    // 차일드뷰를 반환한다.
    @Override
    public String getChild(int groupPosition, int childPosition) {
        return this.childList.get(this.groupList.get(groupPosition)).get(childPosition);
    }

    // 차일드뷰 사이즈를 반환한다.
    @Override
    public int getChildrenCount(int groupPosition) {
        try {
            return this.childList.get(this.groupList.get(groupPosition)).size();
        }catch (Exception e){
            e.getStackTrace();
            return 0;
        }
    }

    // 차일드뷰 ID를 반환한다.
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // 차일드뷰 각각의 ROW
    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){
            viewHolder = new ViewHolder();
            v = inflater.inflate(R.layout.menu_list, null);
            viewHolder.tv_childName = (TextView) v.findViewById(R.id.menu_name);
            v.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)v.getTag();
        }


        viewHolder.tv_childName.setText(getChild(groupPosition, childPosition));
        if(viewHolder.tv_childName.getText().equals(""))
            viewHolder.tv_childName.setText("식단 정보가 없습니다");

        return v;
    }

    @Override
    public boolean hasStableIds() { return true; }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }

    class ViewHolder {
        public TextView tv_groupName;
        public TextView tv_childName;
        public ImageView iv_image;
    }

}
