package com.example.viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link myLeaves#newInstance} factory method to
 * create an instance of this fragment.
 */
public class myLeaves extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<LeaveModel> events;

    public myLeaves() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment myLeaves.
     */
    // TODO: Rename and change types and number of parameters
    public static myLeaves newInstance(String param1, String param2) {
        myLeaves fragment = new myLeaves();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_leaves, container, false);
        // Inflate the layout for this fragment
        recyclerView= view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        events= new ArrayList<>();
        events.add(new LeaveModel("Earned Leave", "Pending (CO)", "20 - 01 - 2022", "23 - 01 - 2022", "03"));
        events.add(new LeaveModel("Medical Leave", "Rejected", "12 - 03 - 2022", "14 - 03 - 2022", "02"));
        events.add(new LeaveModel("Ex-Pakistan Leave", "Approved", "19 - 03 - 2022", "20 - 03 - 2022", "01"));
        events.add(new LeaveModel("Medical Leave", "Cancelled", "24 - 05 - 2022", "30 - 05 - 2022", "06"));
        Recycler adapter = new Recycler(getContext(), events);
        recyclerView.setAdapter(adapter);
        return view;
    }
}