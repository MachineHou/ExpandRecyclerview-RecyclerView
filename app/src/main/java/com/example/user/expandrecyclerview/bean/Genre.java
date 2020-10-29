package com.example.user.expandrecyclerview.bean;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 28-06-2018.
 */

public class Genre extends ExpandableGroup<FormsList.FormsBean.FormPreFillBean.FieldBean> {

    public Genre(String formName, List<FormsList.FormsBean.FormPreFillBean.FieldBean> items) {
        super(formName, items);
    }
}

