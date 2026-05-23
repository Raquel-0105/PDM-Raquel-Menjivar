package com.example.myapplication.ViewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.mutableListOf
import kotlin.collections.toMutableList

class GeneralViewModel: ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: Task) {
        _tasks.value = _tasks.value.toMutableList().apply { add(task) }
    }
}