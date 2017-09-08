package com.qht.baselistviewadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qht.baselistviewadapter.ListviewBaseAdapter.CommonAdapter;
import com.qht.baselistviewadapter.ListviewBaseAdapter.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initview();
    }

    private void initview() {
        List<String> list=new ArrayList<String>();
        for (int i=0;i<50;i++) {
            list.add(""+i);
        }
        ListView listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(new CommonAdapter<String>(ListActivity.this,list,R.layout.activity_list_item) {
            @Override
            public void convert(CommonViewHolder vh, String item, final int position) {
                ((TextView)(vh.getView(R.id.tv))).setBackgroundColor(Color.RED);
                ((Button)(vh.getView(R.id.btn))).setText(item);
                vh.getView(R.id.btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "btn"+position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "listview"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
