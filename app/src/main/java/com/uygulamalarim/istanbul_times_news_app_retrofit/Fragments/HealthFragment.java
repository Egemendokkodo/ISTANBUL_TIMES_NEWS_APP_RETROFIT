package com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uygulamalarim.istanbul_times_news_app_retrofit.Adapters.RecyclerViewAdapter;
import com.uygulamalarim.istanbul_times_news_app_retrofit.ApiClasses.ApiUtilities;
import com.uygulamalarim.istanbul_times_news_app_retrofit.ApiClasses.ModelClass;
import com.uygulamalarim.istanbul_times_news_app_retrofit.ApiClasses.mainNews;
import com.uygulamalarim.istanbul_times_news_app_retrofit.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {
    String api = "a7bc57a275cc4f8780a86964a219af0e";
    ArrayList<ModelClass> modelClassArrayList;
    RecyclerViewAdapter adapter;
    String country = "us";
    private RecyclerView recyclerviewhealth;
    private String category = "health";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.health, null);

        recyclerviewhealth = v.findViewById(R.id.recyclerviewhealth);
        modelClassArrayList = new ArrayList<>();
        recyclerviewhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerViewAdapter(getContext(), modelClassArrayList);
        recyclerviewhealth.setAdapter(adapter);
        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category, 25, api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()) {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });

    }
}