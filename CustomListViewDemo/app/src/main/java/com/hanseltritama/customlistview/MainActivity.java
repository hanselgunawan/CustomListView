package com.hanseltritama.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private class CustomAdapter extends ArrayAdapter<String> {

        Context mContext;
        String[] objects;

        public CustomAdapter(Context context, String[] objects) {

            super(context, 0, objects);
            this.mContext = context;
            this.objects = objects;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null) {

                convertView = getLayoutInflater().inflate(R.layout.list_item_layout, parent, false);
            }

            Button button = convertView.findViewById(R.id.button);

            button.setText(objects[position]);

            return convertView;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] peopleName = {"Hansel", "Bagus", "Tritama"};
        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new CustomAdapter(this, peopleName);
        listView.setAdapter(adapter);


    }
}
