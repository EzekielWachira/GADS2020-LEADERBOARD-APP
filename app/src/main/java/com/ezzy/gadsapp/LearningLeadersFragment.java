package com.ezzy.gadsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ezzy.gadsapp.models.Learner;
import com.ezzy.gadsapp.network.RetrofitClientInstance;
import com.ezzy.gadsapp.services.GetGadsService;
import com.ezzy.gadsapp.utils.BaseAdapter;
import com.ezzy.gadsapp.utils.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
//    private BaseAdapter adapter;
    private Context context;
    private GetGadsService service;

    public LearningLeadersFragment() { }

//    public static LearningLeadersFragment newInstance(String param1, String param2) {
//        LearningLeadersFragment fragment = new LearningLeadersFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
//        recyclerView = view.findViewById(R.id.learning_leaders_recyclerView);
//
//        service = RetrofitClientInstance.retrofitInstance()
//                .create(GetGadsService.class);
//        Call<List<Learner>> listCall = service.getLearnerLeaders();
//        listCall.enqueue(new Callback<List<Learner>>() {
//            @Override
//            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
//                generateLeanerList(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Learner>> call, Throwable t) {
//                makeToast("An error occurred while retrieving the data");
//            }
//        });
        return view;
    }

    private void generateLeanerList(List<Learner> learnerList){
        adapter = new RecyclerViewAdapter(learnerList, context);
//        adapter = new BaseAdapter(context, Learner.class, learnerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
    }

    private void makeToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}