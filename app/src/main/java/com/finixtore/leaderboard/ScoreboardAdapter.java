package com.finixtore.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreboardAdapter extends  RecyclerView.Adapter<ScoreboardAdapter.ScoreBoardViewHolder>{
    ArrayList<Person> scores= new ArrayList<>();

    @NonNull
    @Override
    public ScoreBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ScoreBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreBoardViewHolder holder, int position) {
        Person currentPerson= scores.get(position);
        holder.name.setText(currentPerson.getName());
        holder.score.setText(currentPerson.getPoints());




    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    class ScoreBoardViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView score;
        public ScoreBoardViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_names);
            score=itemView.findViewById(R.id.tv_points);

        }
    }
}
