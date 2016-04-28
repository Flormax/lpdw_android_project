package lol.meteoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ForecastViewHolder extends RecyclerView.ViewHolder {

    public TextView day;
    public TextView prev;
    public TextView temp_min;
    public TextView temp_max;

    public ForecastViewHolder(View itemView) {
        super(itemView);
        this.day = (TextView) itemView.findViewById(R.id.dayCard_day);
        this.prev = (TextView) itemView.findViewById(R.id.dayCard_prevision);
        this.temp_min = (TextView) itemView.findViewById(R.id.dayCard_temp_min);
        this.temp_max = (TextView) itemView.findViewById(R.id.dayCard_temp_max);
    }

    public void bind(Daycard daycard){
        day.setText(daycard.day);
        prev.setText(daycard.prev);
        prev.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, daycard.img);
        temp_min.setText(daycard.temp_min);
        temp_max.setText(daycard.temp_max);
    }
}