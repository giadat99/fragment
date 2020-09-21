package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by Gia Dat on 9/14/2020
 */
public class CompanyAdaper extends RecyclerView.Adapter<CompanyAdaper.CompanyViewHolder> {

    Context context;
    List<Company> companies;

    public CompanyAdaper(Context context, List<Company> companies) {
        this.context = context;
        this.companies = companies;
    }

    public CompanyAdaper(List<Company> companies, onCompanyClick listener) {
        this.companies = companies;
        this.listener = listener;
    }

    public void setListener(onCompanyClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        final Company company = companies.get(position);
        holder.tx1.setText(company.getName());
        holder.tx2.setText(company.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onCompanyItemClick(company);
           }
        });
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder{
        TextView tx1 , tx2;

        public CompanyViewHolder(@NonNull View view) {
            super(view);
            tx1 = view.findViewById(R.id.textView5);
            tx2 = view.findViewById(R.id.textView6);
        }
    }

    interface onCompanyClick{
        void onCompanyItemClick(Company company);
    }
    onCompanyClick listener;
}
