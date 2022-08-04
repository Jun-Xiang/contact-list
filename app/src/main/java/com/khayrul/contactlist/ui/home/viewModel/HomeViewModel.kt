package com.khayrul.contactlist.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khayrul.contactlist.data.model.BaseItem
import com.khayrul.contactlist.data.model.Title
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

interface HomeViewModel {
    val contacts: LiveData<List<BaseItem>>
    val emptyScreen: MutableLiveData<Boolean>
    val refreshFinished: SharedFlow<Unit>
    fun onDeleteClicked(id: Int)
    fun refresh()
}