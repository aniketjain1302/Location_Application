package com.example.mymapsapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    private long time;
    private String address;
    List<Double> list = new ArrayList<>();
    List<Double> list1 = new ArrayList<>();
    ArrayList<Double> list2 = new ArrayList<>();


    public RecyclerAdapter(Context context, List<Double> list, List<Double> list1, ArrayList<Double> list2) {
        this.context = context;
        this.time = time;
        this.address = address;
        this.list = list;
        this.list1 = list1;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.lat.setText(String.valueOf(list.get(position)));
        holder.lon.setText(String.valueOf(list2.get(position)));
        //Glide.with(context).load(BASE_URL+"trial/vihangSchool/"+postsList.get(position).getImage()).into(holder.rowImg);
        holder.time.setText(DateFormat.getTimeInstance().format(list1.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lat, lon, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lat = itemView.findViewById(R.id.lat);
            lon = itemView.findViewById(R.id.lon);
            time = itemView.findViewById(R.id.Time);
        }
    }
}