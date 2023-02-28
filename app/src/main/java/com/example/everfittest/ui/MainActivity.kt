package com.example.everfittest.ui

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.everfittest.base.BaseActivity
import com.example.everfittest.data.model.CalendarDateModel
import com.example.everfittest.databinding.ActivityMainBinding
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private val adapterCalender = CalendarAdapter(::onclick)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()

    override fun inflateViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun initView() {
        setUpAdapter()
        cal.add(Calendar.MONTH, -1)
        setUpCalendar()
    }

    /**
     * Setting up adapter for recyclerview
     */
    private fun setUpAdapter() {
        viewBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter = adapterCalender
        }
    }

    override fun initData() {
        // TODO
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    private fun onclick(cal: CalendarDateModel) {
        //TODO set up
        showToast("view")
    }

    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        adapterCalender.setItems(calendarList)
    }
}