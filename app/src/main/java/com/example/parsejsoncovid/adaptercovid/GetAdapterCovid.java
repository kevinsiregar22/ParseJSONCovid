package com.example.parsejsoncovid.adaptercovid;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parsejsoncovid.R;
import com.example.parsejsoncovid.model.CovidData;

import java.util.List;

public class GetAdapterCovid extends RecyclerView.Adapter<GetAdapterCovid.CovidViewHolder> {

    //deklarasi  variable
    private List<CovidData> dataList;
    private Context context ;

    //constructor
    public GetAdapterCovid(Context context, List<CovidData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitemcovid, parent, false);
        CovidViewHolder cViewHolder = new CovidViewHolder(view);
        return cViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolder holder, int position) {
        CovidData covidData = dataList.get(position);
        holder.dateChecked.setText("Tanggal diperiksa : " + covidData.getDateChecked());
        holder.positive.setText("Positif        : " + covidData.getPositive() + " Orang");
        holder.negative.setText("Negatif       : " + covidData.getNegative() + " Orang");
        holder.death.setText("Meninggal  : " + covidData.getDeath() + " Orang");
        holder.pending.setText("Tertunda    : " + covidData.getPending() + " Orang");
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CovidViewHolder extends RecyclerView.ViewHolder{
        TextView positive, negative, death, pending, dateChecked;

        public CovidViewHolder(@NonNull View itemView) {
            super(itemView);
            dateChecked = (TextView) itemView.findViewById(R.id.tvDateChecked);
            positive = (TextView) itemView.findViewById(R.id.tvPositif);
            negative = (TextView) itemView.findViewById(R.id.tvNegatif);
            death = (TextView) itemView.findViewById(R.id.tvDeath);
            pending = (TextView) itemView.findViewById(R.id.tvPending);

        }
    }
}
