package com.khayrul.contactlist.ui.home.viewModel

import androidx.lifecycle.*
import com.khayrul.contactlist.data.model.BaseItem
import com.khayrul.contactlist.data.model.Title
import com.khayrul.contactlist.data.repository.ContactRepository
import com.khayrul.contactlist.data.repository.ContactRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(val contactRepositoryImpl: ContactRepository): HomeViewModel, ViewModel() {
    private val _contacts: MutableLiveData<List<BaseItem>> = MutableLiveData()
    override val contacts: LiveData<List<BaseItem>> = _contacts

    override val emptyScreen: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _refreshFinished = MutableSharedFlow<Unit>()
    override val refreshFinished: SharedFlow<Unit> = _refreshFinished
    init {
        getContacts()
    }

    private fun getContacts() {
        viewModelScope.launch {
            val response = contactRepositoryImpl.getContacts()
            val tempList: MutableList<BaseItem> = mutableListOf()
            val len = response.size
            for(i in 1..len) {
                if(i % 2 == 0) {
                    val title = Title("Hello ${response[i-1].name}")
                    tempList.add(title)
                }
                tempList.add(response[i-1])
            }
            _contacts.value = tempList
            emptyScreen.value = _contacts.value.isNullOrEmpty()
            _refreshFinished.emit(Unit)
        }
    }

    override fun onDeleteClicked(id: Int) {
        viewModelScope.launch {
            contactRepositoryImpl.deleteContact(id)
            refresh()
        }
    }

    override fun refresh() {
        getContacts()
    }
}