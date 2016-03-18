package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView text1;
    public TextView text2;
    private OnItemClickListener listener;

    //private static final String TAG = "MyLogs";

    public CitiesViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.text1 = (TextView) itemView.findViewById(R.id.city_name);
        this.text2 = (TextView) itemView.findViewById(R.id.city_stateCountry);
        this.listener = listener;
    }

    public void bind(City city){
        text1.setText(city.name);
        text2.setText(city.stateCountry);
    }

    public void onClick(View view) {
        listener.onClick(getAdapterPosition());
    }
}