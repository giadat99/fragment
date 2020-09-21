package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class CompanyListFragment extends Fragment {

    RecyclerView rc;
    List<Company> companies;
    CompanyAdaper companyAdaper;
    CompanyAdaper.onCompanyClick onCompanyClick;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CompanyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_list, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context!=null){
            companies = Company.getData();
            if(context instanceof CompanyAdaper.onCompanyClick){
                onCompanyClick = (CompanyAdaper.onCompanyClick) context;
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc = view.findViewById(R.id.recyclerview);
        companies = Company.getData();
        companyAdaper = new CompanyAdaper(companies,onCompanyClick);
        rc.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        rc.setAdapter(companyAdaper);

//        companyAdaper.setListener(new CompanyAdaper.onCompanyClick() {
//            @Override
//            public void onCompanyItemClick(Company company) {
//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.container,DetailFragment.newInstance(company))
//                        .addToBackStack("")
//                        .commit();
//            }
//        });
    }
}