package com.example.everfittest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.everfittest.base.BaseViewModel
import com.example.everfittest.data.model.AssignmentResponse
import com.example.everfittest.data.repository.AssignmentRepository
import com.example.everfittest.utils.LogUtil
import kotlinx.coroutines.launch

class MainViewModel(private val repository: AssignmentRepository) : BaseViewModel() {

    private val _assignments = MutableLiveData<AssignmentResponse>()
    val assignmentsObs: LiveData<AssignmentResponse>
        get() = _assignments

    fun fetchAssignments() {
        viewModelScope.launch {
            try {
                val assignmentsList = repository.getAssignments()
                _assignments.value = assignmentsList
            } catch (e: Exception) {
                LogUtil.e(e.message.toString())
            }
        }
    }
}