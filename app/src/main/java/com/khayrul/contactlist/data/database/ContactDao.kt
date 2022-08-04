package com.khayrul.contactlist.data.database

import androidx.room.*
import com.khayrul.contactlist.data.model.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    suspend fun getContacts(): List<Contact>

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun addContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("DELETE FROM contact WHERE id = :id")
    suspend fun deleteContact(id: Int)

    @Query("SELECT * FROM contact WHERE id=:id")
    suspend fun findContactById(id: Int): Contact?
}