package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class IndexViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView day;
    public TextView prev;
    public TextView temp;
    public TextView rainPercent;
    private OnItemClickListener listener;

    public IndexViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.day = (TextView) itemView.findViewById(R.id.dayCard_day);
        this.prev = (TextView) itemView.findViewById(R.id.dayCard_prevision);
        this.temp = (TextView) itemView.findViewById(R.id.dayCard_temp);
        this.rainPercent = (TextView) itemView.findViewById(R.id.dayCard_rainPercent);
        this.listener = listener;
    }

    public void bind(Daycard daycard){
        day.setText(daycard.day);
        prev.setText(daycard.prev);
        prev.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, daycard.img);
        temp.setText(daycard.temp);
        rainPercent.setText(daycard.rainPercent);
    }

    public void onClick(View view) {
        listener.onClick(getAdapterPosition());
    }
}