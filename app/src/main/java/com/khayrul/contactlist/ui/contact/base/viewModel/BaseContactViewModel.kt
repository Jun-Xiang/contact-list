package com.khayrul.contactlist.ui.contact.base.viewModel

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.SharedFlow

interface BaseContactViewModel {
    val name: MutableLiveData<String>

    val phone: MutableLiveData<String>

    val finish: SharedFlow<Unit>

    val error: SharedFlow<String>

}