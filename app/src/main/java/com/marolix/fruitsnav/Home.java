package com.marolix.fruitsnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class Home extends Fragment {




    String[] fruitsArray = {"Fruits & Vegetables" , "Bread , Dairy & Eggs" , "Beverages" , "PersonalCare" ,"Fruits & Vegetables" , "Bread , Dairy & Eggs" , "Beverages" , "PersonalCare" };
    int[] images={R.drawable.fruitsandvegetables ,
            R.drawable.breadeggs,
            R.drawable.beverages,
            R.drawable.personalcare,
            R.drawable.fruitsandvegetables ,
            R.drawable.breadeggs,
            R.drawable.beverages,
            R.drawable.personalcare};




    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.home, container, false);





        GridView gridView = view.findViewById( R.id.fruits_list );
        HomeAdapter homeAdapter = new HomeAdapter(getContext(), fruitsArray, images);
        gridView.setAdapter(homeAdapter);

        gridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity( new Intent( getActivity(), Recyclerview.class ) );
            }
        } );

        return view;
    }
}
