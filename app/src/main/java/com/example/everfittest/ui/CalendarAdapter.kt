package com.example.everfittest.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.everfittest.R
import com.example.everfittest.base.BaseAdapter
import com.example.everfittest.data.model.CalendarDateModel
import com.example.everfittest.databinding.ItemAssignmentBinding
import com.example.everfittest.databinding.RowCalendarDateBinding
import com.example.everfittest.utils.DateUtils
import com.example.everfittest.utils.exts.onClickListenerDelay
import java.util.*

class CalendarAdapter(
    private val onClick: (CalendarDateModel) -> Unit,
    private var context: Context? = null
) :
    BaseAdapter<RowCalendarDateBinding, CalendarDateModel>() {
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        context = null
    }

    override fun getLayoutBinding(parent: ViewGroup, viewType: Int): RowCalendarDateBinding {
        return RowCalendarDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun bind(binding: RowCalendarDateBinding, item: CalendarDateModel, position: Int) {
        with(binding) {
            // Setting date
            tvCalendarDay.text = DateUtils.convertDateToEE(item.date.get(Calendar.DAY_OF_WEEK))
            tvCalendarDate.text = item.date.get(Calendar.DAY_OF_MONTH).toString()
            val sameDay = DateUtils.isSameDate(Calendar.getInstance(), item.date)
            item.assignmentData.assignments.forEach { data ->
                if (data.id.isNullOrEmpty()) return@forEach

                val view = ItemAssignmentBinding.inflate(LayoutInflater.from(context)).apply {
                    txtMissed.visibility = if (data.status == 0) View.GONE else View.VISIBLE
                    imgCircle.visibility = if (data.status == 0) View.GONE else View.VISIBLE
                    txtTitle.text = data.title
                    txtExercisesCount.text = context?.getString(R.string.title_exercises,data.exercisesCount)
                    if (item.isSelected){
                        context?.let { cardView.setCardBackgroundColor(it.getColor(R.color.red_bittersweet)) };
                    }
                }
                llLayoutAssignment.addView(view.root)
            }
            if (sameDay) {
                tvCalendarDay.setTextColor(R.color.violet)
                tvCalendarDate.setTextColor(R.color.violet)
            }
            //handle select
            root.isSelected = item.isSelected
            root.onClickListenerDelay { onClick.invoke(item) }
        }
    }
}
