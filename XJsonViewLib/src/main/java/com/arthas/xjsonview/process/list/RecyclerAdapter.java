package com.arthas.xjsonview.process.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.XViewComponent;
import com.arthas.xjsonview.XViewEngine;
import com.arthas.xjsonview.bean.XViewBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghejie on 15/8/8.
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<AdapterHelper> implements
        View.OnClickListener {

    protected final Context context;
    private final XViewBody recyclerX;


    protected List<T> data;
    private OnItemClickListener mOnItemClickListener = null;
    protected LayoutInflater layoutInflater;

//    /**
//     * Create a QuickAdapter.
//     *
//     * @param context     The context.
//     * @param body The layout resource id of each item.
//     */
//    public RecyclerAdapter(Context context, XViewBody body)
//    {
//        this(context, body, null);
//    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param context The context.
     * @param data    A new list is created out of this one to avoid mutable list
     */
    public RecyclerAdapter(Context context, XViewBody recyclerX, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : data;
        this.context = context;
        this.recyclerX = recyclerX;
        layoutInflater = LayoutInflater.from(context);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void clear() {
        this.data = null;
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        if (this.data == null) {
            setData(data);
        } else {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    public void removeData(int position) {
        if (data != null) {
            this.data.remove(position);
        }

    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public T getItem(int position) {
        if (position >= data.size()) {
            return null;
        }
        return data.get(position);
    }

    public T getItem(AdapterHelper adapterHelper) {
        return data.get(adapterHelper.getDataPosition());
    }

    int i=0;
    @Override
    public AdapterHelper onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        XViewBody child = (XViewBody) data.get(i);

        i++;

//        XViewComponent component = recyclerX.getYiewStore().findComponent(recyclerX.itemLayout);

//        View view = component.createComponentView(viewGroup.getContext(),viewGroup, null);

        View view = XViewEngine.createView(context, viewGroup, child);
        view.setOnClickListener(this);
        AdapterHelper vh = getAdapterHelper(view);
        return vh;
    }

    @NonNull
    public AdapterHelper getAdapterHelper(View view) {
        return new AdapterHelper(view);
    }

    @Override
    public void onBindViewHolder(AdapterHelper helper, int position) {
        helper.itemView.setTag(position);
//        XViewComponent component = body.getYiewStore().findComponent(body.itemLayout);
//        component.render();
        XViewBody item = (XViewBody) getItem(position);

        XViewComponent component = recyclerX.getYiewStore().findComponent(recyclerX.itemLayout);
        component.render(item);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper   A fully initialized helper.
     * @param item     The item that needs to be displayed.
     * @param position
     */
    protected abstract void convert(AdapterHelper helper, T item, int position);

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}