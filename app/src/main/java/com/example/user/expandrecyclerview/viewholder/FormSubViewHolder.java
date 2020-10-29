package com.example.user.expandrecyclerview.viewholder;

import android.view.View;
import android.widget.TextView;

import com.example.user.expandrecyclerview.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by user on 28-06-2018.
 */

public class FormSubViewHolder extends ChildViewHolder {

    private TextView childTextView;


    public FormSubViewHolder(View itemView) {
        super(itemView);
        childTextView = (TextView) itemView.findViewById(R.id.list_item_artist_name);
    }

    public void setFormName(String name) {
        childTextView.setText(name);
    }
}
