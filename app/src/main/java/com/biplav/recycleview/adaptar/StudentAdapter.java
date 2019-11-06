package com.biplav.recycleview.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.biplav.recycleview.R;
import com.biplav.recycleview.models.Student;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context mcontext;
    List<Student> studentList = new ArrayList();

    public StudentAdapter(Context mcontext, List studentList) {
        this.mcontext = mcontext;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_layout, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student std = studentList.get(position);
        holder.civ.setImageResource(std.getImageId());
        holder.name.setText(std.getName());
        holder.age.setText(std.getAge());
        holder.gender.setText(std.getGender());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        CircleImageView civ;
        TextView name, age, gender;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            civ = itemView.findViewById(R.id.imgProfilec);
            name = itemView.findViewById(R.id.textViewnamec);
            age = itemView.findViewById(R.id.textViewAgec);
            gender = itemView.findViewById(R.id.textViewGenderc);
        }
    }
}
