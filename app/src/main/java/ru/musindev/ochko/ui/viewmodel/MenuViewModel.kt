package ru.musindev.ochko.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    // Здесь могут быть UseCase'ы для загрузки статистики и т.д.
) : ViewModel() {
    // Логика меню
}
