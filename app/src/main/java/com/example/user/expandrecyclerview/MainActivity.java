package com.example.user.expandrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.example.user.expandrecyclerview.adapter.GenreAdapter;
import com.example.user.expandrecyclerview.bean.FormsList;
import com.example.user.expandrecyclerview.bean.Genre;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<FormsList.FormsBean> formsBeanList;
    private GenreAdapter adapter;
    private RecyclerView mrecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = (RecyclerView) findViewById(R.id.form_recycler_view);
        mrecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutManager);
        FormsList formsList = loadJsonFromAsset();
        formsBeanList = new ArrayList<>();

        for (int i = 0; i < formsList.getForms().size(); i++) {
            FormsList.FormsBean formsBean = new FormsList.FormsBean();
            formsBean.setFormName(formsList.getForms().get(i).getFormName());
            formsBean.setFormPreFill(formsList.getForms().get(i).getFormPreFill());
            formsBeanList.add(formsBean);
        }


        final List<Genre> genres = getGenres();
        adapter = new GenreAdapter(genres);
        mrecyclerView.setAdapter(adapter);
        adapter.setOnclick(new GenreAdapter.ClickListener() {
            @Override
            public void onItemClick(View view, int position, FormsList.FormsBean.FormPreFillBean.FieldBean fromlist) {
                ToastUtils.showLong(position + "-------" + fromlist.getName());
            }
        });
    }


    //To get the json file data
    public FormsList loadJsonFromAsset() {
        try {
            InputStream open = this.getResources().getAssets().open("forms.json");
            byte[] buffer = new byte[open.available()];
            int read = open.read(buffer);
            if (read != 0) {
                String json = new String(buffer, "utf-8");
                FormsList lists = new Gson().fromJson(json, new TypeToken<FormsList>() {
                }.getType());
                Log.e("aaatest", String.valueOf(lists));
                return new Gson().fromJson(json, new TypeToken<FormsList>() {
                }.getType());
            }
        } catch (Exception e) {
        }
        return new FormsList();
    }

    public List<Genre> getGenres() {
        List<Genre> genreList = new ArrayList<>();
        for (int index = 0; index < formsBeanList.size(); index++) {
            Genre genre = new Genre(formsBeanList.get(index).getFormName(), formsBeanList.get(index).getFormPreFill().getField());
            genreList.add(genre);
        }
        return genreList;
    }
}
