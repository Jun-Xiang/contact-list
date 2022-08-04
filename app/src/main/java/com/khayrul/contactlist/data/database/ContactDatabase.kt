package com.khayrul.contactlist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khayrul.contactlist.data.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract val dao: ContactDao
    companion object {
        const val name = "contact_database"
    }
}