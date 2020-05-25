package com.wiwat.template.view.base

open class ViewModelStates

object Loading : ViewModelStates()

data class Failed(val error: Throwable) : ViewModelStates()

data class EmptyLoaded(val error: Throwable) : ViewModelStates()

data class DataLoaded(
    val list: Any
) : ViewModelStates() {
    companion object {
        fun from(
            list: Any
        ): DataLoaded {
            return DataLoaded(list)
        }
    }
}