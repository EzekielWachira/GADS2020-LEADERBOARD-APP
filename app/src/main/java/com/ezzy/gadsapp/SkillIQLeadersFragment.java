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

import com.ezzy.gadsapp.models.Skill;
import com.ezzy.gadsapp.network.RetrofitClientInstance;
import com.ezzy.gadsapp.services.GetGadsService;
import com.ezzy.gadsapp.utils.BaseAdapter;
import com.ezzy.gadsapp.utils.SkillsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends Fragment {

    private RecyclerView recyclerView;
    private SkillsAdapter adapter;
//    private BaseAdapter adapter;
    private Context mContext;
    private GetGadsService service;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public SkillIQLeadersFragment() {}

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

        View view = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);
//        recyclerView = view.findViewById(R.id.skill_iq_recyclerView);
//
//        service = RetrofitClientInstance.retrofitInstance()
//                .create(GetGadsService.class);
//        Call<List<Skill>> listCall = service.getSkillLeaders();
//        listCall.enqueue(new Callback<List<Skill>>() {
//            @Override
//            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
//                generateSkillList(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Skill>> call, Throwable t) {
//                makeToast("Error occurred retrieving the data");
//            }
//        });
        return view;
    }

    private void generateSkillList(List<Skill> skillList){
        adapter = new SkillsAdapter(skillList, mContext);
//        adapter = new BaseAdapter(mContext, skillList, Skill.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);
    }

    private void makeToast(String message){
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}