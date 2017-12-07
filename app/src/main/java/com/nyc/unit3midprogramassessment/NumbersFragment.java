package com.nyc.unit3midprogramassessment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyc.unit3midprogramassessment.controller.ListAdapter;
import com.nyc.unit3midprogramassessment.model.Number;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {
    private TextView textView;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private ArrayList<Number> numbers;


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);
        Bundle bundle = getArguments();
        String string = bundle.getString("email");
        textView = view.findViewById(R.id.emails);
        textView.setText(string);
        listAdapter = new ListAdapter(getFragmentManager());
        numbers = new ArrayList<>();
        numbers.add(new Number(0));
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        numbers.add(new Number(4));
        numbers.add(new Number(5));
        numbers.add(new Number(6));
        numbers.add(new Number(7));
        numbers.add(new Number(8));
        numbers.add(new Number(9));
        numbers.add(new Number(10));
        listAdapter.setNumbers(numbers);
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

}
