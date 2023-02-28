package com.example.everfittest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.everfittest.base.BaseAdapter
import com.example.everfittest.data.model.CalendarDateModel
import com.example.everfittest.databinding.RowCalendarDateBinding
import com.example.everfittest.utils.exts.onClickListenerDelay

class CalendarAdapter(private val onClick: (CalendarDateModel) -> Unit) :
    BaseAdapter<RowCalendarDateBinding, CalendarDateModel>() {
    override fun getLayoutBinding(parent: ViewGroup, viewType: Int): RowCalendarDateBinding {
        return RowCalendarDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bind(binding: RowCalendarDateBinding, item: CalendarDateModel, position: Int) {
        with(binding) {
            tvCalendarDay.text = item.calendarDay
            tvCalendarDate.text = item.calendarDate

            cardView.onClickListenerDelay { onClick.invoke(item) }
        }
    }
}
