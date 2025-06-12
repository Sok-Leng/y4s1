package com.example.crudstudentapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crudstudentapp.R;
import com.example.crudstudentapp.models.Province;

import java.util.List;

public class CustomProvinceAdapter extends BaseAdapter {
    private final Context context;
    private  final List<Province>provinceList;

    public CustomProvinceAdapter(Context context, List<Province> provinceList) {
        this.context = context;
        this.provinceList = provinceList;
    }

    @Override
    public int getCount() {
        return provinceList.size();
    }

    @Override
    public Province getItem(int position) {
        return provinceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return provinceList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        if(view == null){
         view = LayoutInflater.from(context).inflate(R.layout.province_card_spinner_layout, null, false);
         Province province = provinceList.get(position);
            TextView title = view.findViewById(R.id.title);
            if(province.getName() != null){
                title.setText(province.getName().toString());
            }
        }
        return view;
    }
}
