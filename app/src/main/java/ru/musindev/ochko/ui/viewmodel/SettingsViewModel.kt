package ru.musindev.ochko.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    // UseCase'ы для настроек
) : ViewModel() {
    // Логика настроек
}
