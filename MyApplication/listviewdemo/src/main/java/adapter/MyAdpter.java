package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iqiyi.zhenzhen.listviewdemo.R;

import java.util.ArrayList;

/**
 * Created by zhenzhen on 16/8/31.
 */
public class MyAdpter extends BaseAdapter {

    private Context mContext;
    private ArrayList mList;
    public MyAdpter(Context context, ArrayList list) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_layout, null);
            holder.textView = (TextView) convertView.findViewById(R.id.item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText("此时的位置信息为:" + mList.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView textView;
    }
}
