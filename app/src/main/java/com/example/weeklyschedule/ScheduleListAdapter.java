//code is based on the tutorial from https://guides.codepath.com/android/using-the-recyclerview
//onclick code is based on example from https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example

package com.example.weeklyschedule;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleListAdapter extends
        RecyclerView.Adapter<ScheduleListAdapter.ViewHolder> {
    public interface  ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView schedule_name;

        ViewHolder(View view) {
            super(view);
            schedule_name = (TextView) view.findViewById(R.id.schedule_list_schedule_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    private List<Schedule> schedules;
    private ItemClickListener clickListener;

    public ScheduleListAdapter(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public ScheduleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View scheduleListView = inflater.inflate(R.layout.row_schedule_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(scheduleListView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ScheduleListAdapter.ViewHolder holder, int position) {
        Schedule schedule = schedules.get(position);

        TextView textView = holder.schedule_name;
        textView.setText(schedule.getName());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    Schedule getItem(int id) {
        return schedules.get(id);
    }

    void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
