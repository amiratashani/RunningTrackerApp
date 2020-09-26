package com.example.runningtrackerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.db.Run
import com.example.runningtrackerapp.other.Utility
import kotlinx.android.synthetic.main.item_run.view.*
import java.text.SimpleDateFormat
import java.util.*

class RunAdapter() : ListAdapter<Run, RunAdapter.RunViewHolder>(RunDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        return RunViewHolder.from(parent)
    }

    override fun onBindViewHolder(viewHolder: RunViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    class RunViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(run: Run) {
            itemView.apply {
                Glide.with(this).load(run.img).into(ivRunImage)

                val calendar = Calendar.getInstance().apply {
                    timeInMillis = run.timestamp
                }
                val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
                tvDate.text = dateFormat.format(calendar.time)

                val avgSpeed = "${run.avgSpeedInKMH}km/h"
                tvAvgSpeed.text = avgSpeed

                val distanceInKm = "${run.distanceInMeters / 1000f}km"
                tvDistance.text = distanceInKm

                tvTime.text = Utility.getFormattedStopWatchTime(run.timeInMillis)

                val caloriesBurned = "${run.caloriesBurned}kcal"
                tvCalories.text = caloriesBurned
            }
        }

        companion object {
            fun from(parent: ViewGroup): RunViewHolder {
                return RunViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_run, parent, false)
                )
            }
        }
    }
}

class RunDiffCallback : DiffUtil.ItemCallback<Run>() {
    override fun areItemsTheSame(oldItem: Run, newItem: Run): Boolean {
        return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: Run, newItem: Run): Boolean {
        return oldItem == newItem
    }

}