package se.rodion.weatherforecast;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private final Context context;
    private final List<Forecast> forecast;

    public ForecastAdapter(Context context, List<Forecast> forecast) {
        this.context = context;
        this.forecast = forecast;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {

        try {
            holder.dayweekView.setText(forecast.get(position).getWeekDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            holder.timeView.setText(forecast.get(position).getTimeData());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            holder.dateView.setText(forecast.get(position).getDateData());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.tempView.setText(forecast.get(position).getMain().getAverageTemp());
        holder.cloudyView.setText(forecast.get(position).getWeather().get(0).getDescription());
        holder.windView.setText(forecast.get(position).getWind().getSpeedMS());

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMediumGreen));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorMediumDarkGreen));
        }
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public static final class ForecastViewHolder extends RecyclerView.ViewHolder {

        public final TextView dayweekView;
        public final TextView timeView;
        public final TextView dateView;
        public final TextView tempView;
        public final TextView cloudyView;
        public final TextView windView;

        public ForecastViewHolder(View view) {
            super(view);
            this.dayweekView = (TextView) view.findViewById(R.id.name_weekday);
            this.timeView = (TextView) view.findViewById(R.id.time_data);
            this.dateView = (TextView) view.findViewById(R.id.day_data);
            this.tempView = (TextView) view.findViewById(R.id.temp_data);
            this.cloudyView = (TextView) view.findViewById(R.id.cloudy_data);
            this.windView = (TextView) view.findViewById(R.id.wind_data);
        }
    }
}
