package com.michaeljordanr.koombeatest.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michaeljordanr.koombeatest.common.Resource
import com.michaeljordanr.koombeatest.domain.usecase.GetUsersUseCase
import com.michaeljordanr.koombeatest.presentation.UsersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    private val _state = mutableStateOf(UsersState())
    val state: State<UsersState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUseCase().onEach { result->
            when (result) {
                is Resource.Success -> {
                    _state.value = UsersState(users = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = UsersState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = UsersState(error = "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}