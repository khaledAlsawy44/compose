package com.example.androiddevchallenge.ui.screens.puppies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PuppiesViewModel(

) : ViewModel() {


    private val _uiState = MutableLiveData<PuppiesState>(PuppiesState.Loading)
    val uiState: LiveData<PuppiesState> = _uiState

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    init {
        viewModelScope.launch {
            delay(500)
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