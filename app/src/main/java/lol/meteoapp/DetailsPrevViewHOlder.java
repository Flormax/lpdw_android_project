package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DetailsPrevViewHolder extends RecyclerView.ViewHolder {

    public TextView day;
    public TextView prev;
    public TextView temp;
    public TextView rainPercent;

    public DetailsPrevViewHolder(View itemView) {
        super(itemView);
        this.day = (TextView) itemView.findViewById(R.id.dayCard_day);
        this.prev = (TextView) itemView.findViewById(R.id.dayCard_prevision);
        this.temp = (TextView) itemView.findViewById(R.id.dayCard_temp);
        this.rainPercent = (TextView) itemView.findViewById(R.id.dayCard_rainPercent);
    }

    public void bind(Daycard daycard){
        day.setText(daycard.day);
        prev.setText(daycard.prev);
        prev.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, daycard.img);
        temp.setText(daycard.temp);
        rainPercent.setText(daycard.rainPercent);
    }
}