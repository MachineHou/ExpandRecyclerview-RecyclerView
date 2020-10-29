package com.example.user.expandrecyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.expandrecyclerview.R;
import com.example.user.expandrecyclerview.bean.FormsList;
import com.example.user.expandrecyclerview.bean.Genre;
import com.example.user.expandrecyclerview.viewholder.FormSubViewHolder;
import com.example.user.expandrecyclerview.viewholder.GenreViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class GenreAdapter extends ExpandableRecyclerViewAdapter<GenreViewHolder, FormSubViewHolder> {
    private ClickListener mClickListener;
    private FormsList.FormsBean.FormPreFillBean.FieldBean fromlist;

    public GenreAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    //--------------------点击事件-------------------------------------------//
    public void setOnclick(ClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    //回调接口
    public interface ClickListener {
        void onItemClick(View view, int position, FormsList.FormsBean.FormPreFillBean.FieldBean fromlist);
    }

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_genre, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public FormSubViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sublist, parent, false);
        return new FormSubViewHolder(view);
    }

    /*二级内容*/
    @Override
    public void onBindChildViewHolder(FormSubViewHolder holder, final int flatPosition, ExpandableGroup group, int childIndex) {
        fromlist = ((Genre) group).getItems().get(childIndex);
        holder.setFormName(fromlist.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.onItemClick(v, flatPosition, fromlist);
                }
            }
        });

    }

    /*一级内容*/
    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        ImageView imageView = holder.itemView.findViewById(R.id.list_item_genre_arrow);
        if (((Genre) group).getItems().size() == 0) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
        }
        holder.setGenreTitle(group);

    }


}
