package pl.kaszmir.templatemvvm.core.base

sealed class UIState {
    object Idle : UIState()
    object Pending : UIState()
}