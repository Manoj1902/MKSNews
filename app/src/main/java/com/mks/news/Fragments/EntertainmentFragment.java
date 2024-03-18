package com.mks.news.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mks.news.Adapters.Adapter;
import com.mks.news.Classes.MainNews;
import com.mks.news.Models.ModelClass;
import com.mks.news.R;
import com.mks.news.Utilities.ApiUtilities;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EntertainmentFragment extends Fragment {


    String api = "0ca1e0c88da543afa64a3e054ae7005e";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewEntertainment;
    private String category = "entertainment";
    SwipeRefreshLayout refreshLayoutEntertainment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_entertainment, container, false);

        recyclerViewEntertainment = v.findViewById(R.id.entertainmentFragmentRecyclerView
        );
        modelClassArrayList = new ArrayList<>();
        recyclerViewEntertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);
        recyclerViewEntertainment.setAdapter(adapter);
        refreshLayoutEntertainment = v.findViewById(R.id.refreshLayoutEntertainment);

        findNews();

        refreshLayoutEntertainment.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                findNews();
                refreshLayoutEntertainment.setRefreshing(false);
            }
        });

        return v;
    }

    private void findNews(){
        ApiUtilities.getApiInterface().getCatNews(country, category,100, api).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<MainNews> call, @NonNull Response<MainNews> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}