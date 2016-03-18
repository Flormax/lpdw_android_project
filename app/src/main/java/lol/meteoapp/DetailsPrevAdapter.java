package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DetailsPrevAdapter extends RecyclerView.Adapter<DetailsPrevViewHolder> {

    private List<Daycard> list;

    public DetailsPrevAdapter(List<Daycard> list) {
        this.list = list;
    }

    public DetailsPrevViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detailsprev_daycard,viewGroup,false);
        return new DetailsPrevViewHolder(view);
    }

    public void onBindViewHolder(DetailsPrevViewHolder holder, int position) {
        Daycard daycard = list.get(position);
        holder.bind(daycard);
    }

    public int getItemCount() {
        return list.size();
    }
}