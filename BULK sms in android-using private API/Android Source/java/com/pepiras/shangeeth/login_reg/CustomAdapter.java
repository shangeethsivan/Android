package com.shangeeth.login_reg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAdapter extends SimpleAdapter
{        LayoutInflater inflater;
        Context context;
        ArrayList<HashMap<String, String>> arrayList;
        static ArrayList<String> selectedStrings = new ArrayList<String>();

        public CustomAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.context = context;
            this.arrayList = data;
            inflater.from(context);
        }

    public static ArrayList<String> getDetails(){
        return selectedStrings;
    }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            CheckBox chbk=(CheckBox)view.findViewById(R.id.checkBox);
            chbk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        selectedStrings.add(arrayList.get(position).get("name"));
                    }else{
                        selectedStrings.remove(arrayList.get(position).get("name"));
                    }
                }
            });
            return view;
        }

    }