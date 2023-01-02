package serat.maemaeen.notecleanmvvm.feature_note.domain.use_case

import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.domain.repository.NoteRepository

class GetNote(private val repository:NoteRepository) {
    suspend operator fun invoke(id:Int): Note?{
        return repository.getNoteById(id)
    }
}