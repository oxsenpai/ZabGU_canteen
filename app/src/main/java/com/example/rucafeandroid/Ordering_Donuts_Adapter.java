/**
 * This is an adapter class to be used to instantiate an adapter for the RecyclerView
 * Extends RecyclerView.Adapter<Ordering_Donuts_Adapter.DonutsHolder
 * @author Udayan Rai, Garvit Gupta
 */

package com.example.rucafeandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ordering_Donuts_Adapter extends RecyclerView.Adapter<Ordering_Donuts_Adapter.DonutsHolder> {
    private ArrayList<String> items;
    private Context context;

    public static final String Yeast_Price = "50р";
    public static final String Cake_Price = "60р";
    public static final String Hole_Price = "40р";


    /**
     * Constructor for the Adapter
     * @param context context of the application
     * @param items list of all donuts
     */
    public Ordering_Donuts_Adapter(Context context, ArrayList<String> items){
        this.context=context;
        this.items=items;
    }

    /**
     * This method will inflate the row layout for the items in the RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public DonutsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.donuts_row_view, parent, false);
        return new DonutsHolder(view);
    }

    /**
     * Assign data values for each row according to their "position" (index) when the item becomes
     * visible on the screen.
     * @param holder the instance of ItemsHolder
     * @param position the index of the item in the list of items
     */
    @Override
    public void onBindViewHolder(@NonNull DonutsHolder holder, int position) {
        holder.donut_flavor.setText(items.get(position));
        if(items.get(position).contains("Пирожок")) holder.donut_price.setText(Yeast_Price);
        if(items.get(position).contains("Булочка")) holder.donut_price.setText(Cake_Price);
        if(items.get(position).contains("Самса")) holder.donut_price.setText(Hole_Price);
    }

    /**
     * Get the number of items in the ArrayList.
     * @return the number of items in the list.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * DonutsHolder Class gets the views from the row layout file
     */
    public class DonutsHolder extends RecyclerView.ViewHolder {
        private TextView donut_flavor, donut_price;
        private ConstraintLayout parentLayout;

        /**
         * Constructor for the DonutsHolder Class
         * @param itemView
         */
        public DonutsHolder(@NonNull View itemView){
            super(itemView);
            donut_flavor= itemView.findViewById(R.id.donut_flavor);
            donut_price= itemView.findViewById(R.id.donut_price);

            parentLayout= itemView.findViewById(R.id.rowLayout);
            parentLayout.setOnClickListener(new View.OnClickListener() {

                /**
                 * Method that creates an intent and takes user to the Selected_Donuts_actvity
                 * @param view
                 */
                @Override
                public void onClick(View view) {
                    String flavorString= (String)donut_flavor.getText();
                    Intent intent= new Intent(itemView.getContext(), Selected_Donuts_Activity.class);
                    if(flavorString.contains("Пирожок")) intent.putExtra("TYPE","Пирожок");
                    if(flavorString.contains("Булочка")) intent.putExtra("TYPE","Булочка");
                    if(flavorString.contains("Самса")) intent.putExtra("TYPE","Самса");

                    if(flavorString.contains("с картофелем")) intent.putExtra("FLAVOR","с картофелем");
                    if(flavorString.contains("с капустой")) intent.putExtra("FLAVOR","с капустой");
                    if(flavorString.contains("с рисом")) intent.putExtra("FLAVOR","с рисом");

                    if(flavorString.contains("с курицей")) intent.putExtra("FLAVOR","с курицей");
                    if(flavorString.contains("с говядиной")) intent.putExtra("FLAVOR","с говядиной");
                    if(flavorString.contains("со свининой")) intent.putExtra("FLAVOR","с свининой");

                    if(flavorString.contains("с повидлом")) intent.putExtra("FLAVOR","с повидлом");
                    if(flavorString.contains("с сахаром")) intent.putExtra("FLAVOR","с сахаром");
                    if(flavorString.contains("с корицей")) intent.putExtra("FLAVOR","с корицей");
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
