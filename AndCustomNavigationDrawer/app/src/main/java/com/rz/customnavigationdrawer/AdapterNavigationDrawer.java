package com.rz.customnavigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterNavigationDrawer extends ArrayAdapter<ModelNavDrawerData> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<ModelNavDrawerData> modelListItems;

    public AdapterNavigationDrawer(Context argContext, int argLayoutResourceId, ArrayList<ModelNavDrawerData> argModelListItems) {
        super(argContext, argLayoutResourceId, argModelListItems);
        this.context = argContext;
        this.layoutResourceId = argLayoutResourceId;
        this.modelListItems = argModelListItems;
    }

    @Override
    public View getView(int argPosition, View argConvertView, ViewGroup argParentGroup) {
        View rootRowView = argConvertView;
        RowViewHolder rowViewHolder;
        if (rootRowView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootRowView = inflater.inflate(layoutResourceId, argParentGroup, false);
            rowViewHolder = new RowViewHolder(rootRowView);
            rootRowView.setTag(rowViewHolder);
        } else {
            rowViewHolder = (RowViewHolder) rootRowView.getTag();
        }
        ModelNavDrawerData modelItem = this.modelListItems.get(argPosition);
        rowViewHolder.sysTextViewTitle.setText(modelItem.getNavTitle());
        return rootRowView;
    }

    static class RowViewHolder {
        private TextView sysTextViewTitle;

        public RowViewHolder(View argRootView) {
            sysTextViewTitle = (TextView) argRootView.findViewById(R.id.sysTextViewTitle);
        }
    }
}
