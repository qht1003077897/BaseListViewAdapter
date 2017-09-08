package com.qht.baselistviewadapter.ListviewBaseAdapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by QHT on 2017-09-08.
 */
public class CommonViewHolder {

    private SparseArray<View> mViews;
    private View              mConvertview;
    private CommonViewHolder(Context context, int layoutId, View convertview, ViewGroup parent){
        mViews=new SparseArray<View>();
        mConvertview= LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertview.setTag(this);
    }
     /**
      * 拿到一个viewholder对象
      * */

    public static CommonViewHolder get(Context context, int layoutId, View convertview, ViewGroup parent){
        CommonViewHolder vh;
    if(convertview==null){
        vh=new CommonViewHolder(context,layoutId,convertview,parent);
    }else{
        vh=(CommonViewHolder) convertview.getTag();
    }
    return vh;
    }

    public <T extends View> T getView(int viewId){
        View view=  mViews.get(viewId);
        if(view==null){
            view=mConvertview.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }
    public View getConvertView()
    {
        return mConvertview;
    }
}
