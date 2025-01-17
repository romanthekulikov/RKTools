package com.roman_kulikov.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.coroutines.CoroutineContext

/**
 * This is a base ViewModel view for JetPack compose.
 * Extend your ViewModel from BaseViewModel with Screen State that extends from [BaseState].
 */
abstract class BaseViewModel<S: BaseState> : ViewModel, CoroutineScope {
    constructor() : super()
    constructor(viewModelScope: CoroutineScope) : super(viewModelScope)
    constructor(vararg closeables: AutoCloseable) : super(*closeables)
    constructor(viewModelScope: CoroutineScope, vararg closeables: AutoCloseable) : super(viewModelScope, *closeables)

    override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob()

    protected abstract val _state: MutableStateFlow<S>

    val state: StateFlow<S> by lazy { _state.asStateFlow() }
}