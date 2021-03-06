package com.linyuzai.util.view;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2016/6/19 0019.
 */
public class XViewHolder {
    public static final String TAG = "XViewHolder";

    public static <T extends View> T get(View view, int id) {
        SparseArray<View> holder = (SparseArray<View>) view.getTag();
        if (holder == null) {
            holder = new SparseArray<>();
            view.setTag(holder);
        }
        View childView = holder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            holder.put(id, childView);
        }
        return (T) childView;
    }
}
