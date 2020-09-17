package com.example.runningtrackerapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import com.example.runningtrackerapp.repositories.MainRepository
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
) {
}