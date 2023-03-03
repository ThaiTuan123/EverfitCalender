package com.example.everfittest.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
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
    private val onClick: (CalendarDateModel, Int) -> Unit,
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

            if (sameDay) {
                tvCalendarDay.setTextColor(R.color.violet)
                tvCalendarDate.setTextColor(R.color.violet)
            } else {
                tvCalendarDay.setTextColor(R.color.black)
                tvCalendarDate.setTextColor(R.color.black)
            }
            llLayoutAssignment.removeAllViews()
            item.assignmentData?.assignments?.forEach { data ->
                if (data.id.isNullOrEmpty()) return@forEach

                val view = ItemAssignmentBinding.inflate(LayoutInflater.from(context)).apply {
                    txtMissed.visibility = if (data.status == 0) View.GONE else View.VISIBLE
                    imgCircle.visibility = if (data.status == 0) View.GONE else View.VISIBLE
                    txtTitle.text = data.title
                    txtExercisesCount.text =
                        context?.getString(R.string.title_exercises, data.exercisesCount)
                    root.onClickListenerDelay {
                        item.assignmentData!!.assignments.find { it.id == data.id }?.isSelect =
                            !data.isSelect
                        context?.getColor(R.color.blue_cornflower)
                            ?.let { it1 ->
                                cardView.setCardBackgroundColor(it1)
                            }
                        txtExercisesCount.text = context?.getString(R.string.txt_complete)
                        txtExercisesCount.setTextColor(Color.WHITE)
                        txtTitle.setTextColor(Color.WHITE)
                        imgCircle.visibility = View.GONE
                        txtMissed.visibility = View.GONE
                        imgCheck.visibility = View.VISIBLE
                    }
                }
                llLayoutAssignment.addView(view.root)
            }
            //handle select
            root.isSelected = item.isSelected
        }
    }
}
