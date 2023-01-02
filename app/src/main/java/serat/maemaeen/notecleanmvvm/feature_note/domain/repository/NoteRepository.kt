package serat.maemaeen.notecleanmvvm.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note

interface NoteRepository {

    fun getNotes():Flow<List<Note>>

    suspend fun getNoteById(id:Int):Note?

    suspend fun deleteNote(note:Note)

    suspend fun addNote(note:Note)
}