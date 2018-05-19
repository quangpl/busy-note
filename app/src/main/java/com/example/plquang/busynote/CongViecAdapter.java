package com.example.plquang.busynote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;

    public CongViecAdapter(MainActivity context, int layout, List<CongViec> congViecList) {
        this.context = context;
        this.layout = layout;
        this.congViecList = congViecList;
    }

    private int layout;
    private List<CongViec> congViecList;



    @Override
    public int getCount() {
        return congViecList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHolder
    {
        TextView txtTen;
        ImageView imgEdit;
        ImageView imgDelete;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.txtTen=(TextView) convertView.findViewById(R.id.textviewTen);
            holder.imgEdit=(ImageView) convertView.findViewById(R.id.imageviewEdit);
            holder.imgDelete=(ImageView) convertView.findViewById(R.id.imageviewDelete);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
        final CongViec congViec=congViecList.get(position);
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoaCV(congViec.getTenCV(), congViec.getiDCV());
            }
        });
        holder.txtTen.setText(congViec.getTenCV());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  context.DialogSuaCongViec(congViec.getTenCV(),congViec.getiDCV());
                                              }
                                          }
        );
        return convertView;
    }
}
