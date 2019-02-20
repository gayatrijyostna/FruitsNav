package com.marolix.fruitsnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Orders extends Fragment {

    Button review;
    Button reorder;


    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.orders, container, false);


        review = view.findViewById( R.id.Review );
        reorder = view.findViewById( R.id.Reorder);

        review.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Review.class);
                startActivity( intent );

            }
        } );

        reorder.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity() , Reorder.class );
                startActivity( intent );
            }
        } );

        return view;
    }

}
