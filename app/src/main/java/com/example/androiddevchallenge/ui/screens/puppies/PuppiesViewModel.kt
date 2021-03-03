package com.example.androiddevchallenge.ui.screens.puppies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PuppiesViewModel : ViewModel() {


    private val _uiState = MutableLiveData<PuppiesState>(PuppiesState.Loading)
    val uiState: LiveData<PuppiesState> = _uiState

    init {
        viewModelScope.launch {
            // delay 4 sec to display loading state
            delay(1)

            _uiState.value = PuppiesState.Default(
                puppiesData = dummyData
            )
        }
    }

    fun changeAgeSectionVisibility(ageType: AgeType) {
        val currentState = _uiState.value
        if (currentState is PuppiesState.Default) {
            val mutableMap = currentState.puppiesData.toMutableMap()
            val ageSection = mutableMap[ageType]
            val updatedSection = ageSection?.copy(isExpanded = !ageSection.isExpanded)
            updatedSection?.let {
                mutableMap[ageType] = it
                _uiState.value = currentState.copy(mutableMap)
            }
        }
    }
}