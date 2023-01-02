package serat.maemaeen.notecleanmvvm.feature_note.data.data_source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes():Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note:Note)

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id:Int):Note?

    @Delete
    suspend fun deleteNote(note:Note)

}