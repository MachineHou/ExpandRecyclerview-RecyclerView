package com.example.user.expandrecyclerview.viewholder;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.expandrecyclerview.R;
import com.example.user.expandrecyclerview.bean.Genre;
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

/**
 * Created by user on 28-06-2018.
 */

public class GenreViewHolder extends GroupViewHolder {

    private TextView genreName;
    private ImageView arrow;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreName = (TextView) itemView.findViewById(R.id.list_item_genre_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_genre_arrow);
    }

    public void setGenreTitle(ExpandableGroup genre) {
        if (genre instanceof Genre) {
            genreName.setText(genre.getTitle());
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public void setOnGroupClickListener(OnGroupClickListener listener) {
        super.setOnGroupClickListener(listener);
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
