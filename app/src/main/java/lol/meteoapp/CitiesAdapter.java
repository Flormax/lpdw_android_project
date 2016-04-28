package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {

    private List<MyCity> list;
    private OnItemClickListener ocl;

    public CitiesAdapter(List<MyCity> list, OnItemClickListener ocl) {
        this.list = list;
        this.ocl = ocl;
    }

    public CitiesViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city,viewGroup,false);
        return new CitiesViewHolder(view, ocl);
    }

    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        MyCity myCity = list.get(position);
        holder.bind(myCity);
    }

    public void insert(MyCity myCity) {
        list.add(0, myCity);
        notifyItemInserted(0);
    }

    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public MyCity get(int position) {
        return list.get(position);
    }

    public int getItemCount() {
        return list.size();
    }

    public MyCity getCityAt(int position) {
        return list.get(position);
    }
}