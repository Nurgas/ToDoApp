package kg.nurga.todoapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder>{

    private List<Task> list;
    public TaskAdapter(List<Task> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_task, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Task task = list.get(i);
        myViewHolder.mTextTitle.setText(task.getTitle());
        myViewHolder.mTextDesc.setText(task.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextTitle;
        TextView mTextDesc;
        TextView mTextCreatedTime;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            mTextTitle = itemView.findViewById(R.id.textTitle);
            mTextDesc = itemView.findViewById(R.id.textDesc);
            mTextCreatedTime = itemView.findViewById(R.id.textCreatedTime);
        }
    }
}
