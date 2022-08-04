package com.khayrul.contactlist.data.repository

import com.khayrul.contactlist.data.database.ContactDatabase
import com.khayrul.contactlist.data.model.Contact
import kotlinx.coroutines.delay

class ContactRepositoryImpl(val db: ContactDatabase): ContactRepository {
    override suspend fun getContacts(): List<Contact> {
        delay(3000)
        return db.dao.getContacts()
    }

    override suspend fun addContact(contact: Contact) {
        return db.dao.addContact(contact)
    }

    override suspend fun updateContact(id: Int, contact: Contact) {
        return db.dao.updateContact(contact.copy(id=id))
    }

    override suspend fun findContactById(id: Int) : Contact? {
        return db.dao.findContactById(id)
    }

    override suspend fun deleteContact(id: Int) {
        return db.dao.deleteContact(id)
    }

}
