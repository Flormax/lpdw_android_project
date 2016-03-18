package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {

    private List<City> list;
    private OnItemClickListener ocl;

    public CitiesAdapter(List<City> list, OnItemClickListener ocl) {
        this.list = list;
        this.ocl = ocl;
    }

    public CitiesViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city,viewGroup,false);
        return new CitiesViewHolder(view, ocl);
    }

    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        City city = list.get(position);
        holder.bind(city);
    }

    public int getItemCount() {
        return list.size();
    }

    public City getCityAt(int position) {
        return list.get(position);
    }
}