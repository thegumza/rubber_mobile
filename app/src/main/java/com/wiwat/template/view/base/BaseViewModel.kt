package com.wiwat.template.view.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wiwat.template.domain.BaseRepository
import kotlinx.coroutines.launch

class BaseViewModel(private val baseRepository: BaseRepository) : CoroutinesViewModel() {
    private val _states = MutableLiveData<ViewModelStates>()
    val states: LiveData<ViewModelStates>
        get() = _states

    fun getSample() {
        mainScope.launch {
            _states.value = Loading
            _states.value = DataLoaded(baseRepository.getSample())
        }
    }
}
