package com.marolix.fruitsnav;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Recyclerview extends AppCompatActivity {

    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;

    private RecyclerView recyclerView;
    int[] images = {R.drawable.fruitsandvegetables,
            R.drawable.fruitsandvegetables,
            R.drawable.fruitsandvegetables,
            R.drawable.fruitsandvegetables,
            R.drawable.fruitsandvegetables};
    String[] name = {"pomogranate", "Tomato", "Potato", "Brinjal", "Sapota"};
    String[] price = {"30", "40", "50", "130", "50"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_view );

        bottom_cart_layout = findViewById(R.id.bottom_cart_layout);
        text_cart = findViewById(R.id.cart_text);

        recyclerView = findViewById( R.id.recycler );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );



        RecycleAdapter recycleAdapter = new RecycleAdapter( this, name, price, images, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {

                if (view.getId() == R.id.plus) {

                    total = total + Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9 " + total);

                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                }

                else if (view.getId() == R.id.minus) {

                    total = total - Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to databaseCart items " + total);

                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }

                }

            }
        } );
        recyclerView.setAdapter( recycleAdapter );

    }
}
