package com.androidlessons.taskappandroid2.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlessons.taskappandroid2.R;
import com.androidlessons.taskappandroid2.interffaces.OnItemClickListener;
import com.androidlessons.taskappandroid2.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> list = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bind(list.get(position));
       holder.setColor(position);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textCreated;

        private UUID taskId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.tv_title);

            textCreated = itemView.findViewById(R.id.tv_created);



            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    onItemClickListener.onLongClick(taskId);
                    return true;
                }
            });
        }



        public void bind(Task task) {
            textTitle.setText(task.getTitle());
            textCreated.setText(task.getCreatedAt());
            taskId = task.getId();

        }


        public void setColor(int position) {
            if (position % 2 == 0) itemView.setBackgroundResource(R.color.grey);
            else itemView.setBackgroundResource(R.color.purple);
        }
    }

    public void addItem(Task task) {
        list.add(0, task);
        notifyItemInserted(list.indexOf(task));
        notifyDataSetChanged();
    }

    public void deleteItem(UUID taskId) {
        int index = -1;
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).getId() == taskId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            list.remove(index);
        }
        notifyItemRemoved(index);
        notifyDataSetChanged();
    }

         

}
