package com.example.admin.notedevelop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 04.12.2016.
 */
public class CustomAdapter extends ArrayAdapter<ToDoDocument> {

    private ArrayList<ToDoDocument> list;
    public CustomAdapter(Context context, ArrayList<ToDoDocument>list) {
        super(context, R.layout.item_adapter_custom, list);
        this.list = list;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_adapter_custom , parent,false);
        TextView txtName=(TextView)convertView.findViewById(R.id.item_name_custom);

        ToDoDocument toDoDocument = list.get(position);
        txtName.setText(toDoDocument.getName());
        return convertView;
    }
}
