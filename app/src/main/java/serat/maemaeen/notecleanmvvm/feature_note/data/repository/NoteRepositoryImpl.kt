package serat.maemaeen.notecleanmvvm.feature_note.data.repository

import kotlinx.coroutines.flow.Flow
import serat.maemaeen.notecleanmvvm.feature_note.data.data_source.NoteDao
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
       return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
       return noteDao.getNoteById(id)
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note)
    }

    override suspend fun addNote(note: Note) {
        return noteDao.addNote(note)
    }
}