package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DetailsPrevAdapter extends RecyclerView.Adapter<IndexViewHolder> {

    private List<Daycard> list;
    private OnItemClickListener ocl;

    public DetailsPrevAdapter(List<Daycard> list, OnItemClickListener ocl) {
        this.list = list;
        this.ocl = ocl;
    }

    public IndexViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detailsprev_daycard,viewGroup,false);
        return new IndexViewHolder(view, ocl);
    }

    public void onBindViewHolder(IndexViewHolder holder, int position) {
        Daycard daycard = list.get(position);
        holder.bind(daycard);
    }

    public int getItemCount() {
        return list.size();
    }

    public Daycard getDayCardAt(int position) {
        return list.get(position);
    }
}