package com.khayrul.contactlist.ui.contact.add.viewModel

import androidx.lifecycle.viewModelScope
import com.khayrul.contactlist.data.model.Contact
import com.khayrul.contactlist.data.repository.ContactRepository
import com.khayrul.contactlist.ui.contact.base.viewModel.BaseContactViewModelImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModelImpl @Inject constructor(private val repository: ContactRepository): AddContactViewModel, BaseContactViewModelImpl() {

    override fun save() {
        viewModelScope.launch {
            if(name.value.isNullOrEmpty() || phone.value.isNullOrEmpty()) {
                viewModelScope.launch {
                    _error.emit("Please enter both name and phone properly")
                }
            } else {
                val contact = Contact(name = name.value!!, phone = phone.value!!)
                repository.addContact(contact)
                _finish.emit(Unit)
            }
        }
    }
}