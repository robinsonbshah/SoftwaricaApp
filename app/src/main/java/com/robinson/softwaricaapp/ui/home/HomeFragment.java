package com.robinson.softwaricaapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.robinson.softwaricaapp.R;
import com.robinson.softwaricaapp.adapter.StudentListApt;
import com.robinson.softwaricaapp.model.Dataset;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    public RecyclerView recyclerView;
    View view;
    List<Dataset> studentList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.RcView);
        Dataset sd = new Dataset("Sita", "dhalko", "12", "female");

        studentList = sd.getSlist();
        if (studentList.isEmpty()) {
            studentList.add(sd);
            studentList.add(new Dataset("Ram", "dhalko", "12", "male"));
            sd.setSlist(studentList);
        }

        StudentListApt studentListApt = new StudentListApt(getActivity(), studentList);
        recyclerView.setAdapter(studentListApt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


}