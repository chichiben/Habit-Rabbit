package com.example.habitrabbit.ui.habits

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabitsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Habits Fragment"
    }
    val text: LiveData<String> = _text
}