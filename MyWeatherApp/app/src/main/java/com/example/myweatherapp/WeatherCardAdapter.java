package com.example.myweatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class WeatherCardAdapter extends RecyclerView.Adapter<WeatherCardAdapter.WeatherCardViewHolder> {

    private List<ForecastDay> forecastDays;
    HashMap<Integer, String> icons;

    public WeatherCardAdapter(List<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
        icons = new HashMap<>();
        icons.put(1401, "rain");
        icons.put(201, "thunderstorm");
        icons.put(2501, "clear");
        icons.put(2202, "partly_cloudy");
    }

    @NonNull
    @Override
    public WeatherCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_card, parent, false);
        return new WeatherCardViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherCardViewHolder holder, int position) {
        ForecastDay day = forecastDays.get(position);
        holder.tvDate.setText(day.getForecastDate());
        holder.tvWeather.setText(day.getWeather());
        holder.tvMinTemp.setText(day.getMinTemp());
        holder.tvMaxTemp.setText(day.getMaxTemp());
        String weatherIconName = icons.get(day.getWeatherIcon());
        if (weatherIconName != null) {
            // Загрузка ресурса иконки погоды
            int iconResource = holder.context.getResources().getIdentifier(weatherIconName, "drawable", holder.context.getPackageName());
            holder.weatherIcon.setImageResource(iconResource);
        }
    }

    @Override
    public int getItemCount() {
        return forecastDays.size();
    }

    public static class WeatherCardViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate, tvWeather, tvMinTemp, tvMaxTemp;
        ImageView weatherIcon;
        Context context;

        public WeatherCardViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            tvDate = itemView.findViewById(R.id.tvDate);
            tvWeather = itemView.findViewById(R.id.tvWeather);
            tvMinTemp = itemView.findViewById(R.id.tvMinTemp);
            tvMaxTemp = itemView.findViewById(R.id.tvMaxTemp);
            weatherIcon = itemView.findViewById(R.id.weatherIcon);
        }
    }
}
