package pl.kaszmir.templatemvvm.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _message by lazy { LiveEvent<String>() }
    val message: LiveData<String> by lazy { _message }

    private val _uiState by lazy { MutableLiveData<UIState>(UIState.Idle) }
    val uiState: LiveData<UIState> by lazy { _uiState }

    private fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setUiState(state: UIState) {
        _uiState.value = state
    }

    protected fun handleFailure(throwable: Throwable) {
        throwable.message?.let { showMessage(it) }
    }

}