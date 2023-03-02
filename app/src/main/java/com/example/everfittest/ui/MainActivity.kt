package com.example.everfittest.ui

import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.everfittest.base.BaseActivity
import com.example.everfittest.data.model.CalendarDateModel
import com.example.everfittest.databinding.ActivityMainBinding
import com.example.everfittest.utils.DateUtils
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private val viewModel: MainViewModel by viewModel()
    private val adapterCalender = CalendarAdapter(::onclick)

    override fun inflateViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun initView() {
        setUpAdapter()
        setUpCalendar()
        viewBinding.recyclerView.adapter = adapterCalender
        viewModel.assignmentsObs.observe(this) { assignmentData ->
            val calendarList = DateUtils.getRangeByWeek().mapIndexed { index, calendar ->
                CalendarDateModel(calendar,assignmentData.data[index])
            }
            adapterCalender.setItems(calendarList)
        }
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
        viewModel.fetchAssignments()
    }

    private fun onclick(cal: CalendarDateModel) {
        val id = cal.assignmentData.id
        showToast(id)
    }

    private fun setUpCalendar() {
    }
}