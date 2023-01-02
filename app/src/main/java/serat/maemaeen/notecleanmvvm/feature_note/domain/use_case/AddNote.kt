package serat.maemaeen.notecleanmvvm.feature_note.domain.use_case

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.InvalidNoteException
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.domain.repository.NoteRepository
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.Add
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.DeleteDialog
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.DeletingItem

class AddNote(private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("عنوان نمی تواند خالی باشد.")


        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("محتوا نمی تواند خالی باشد.")
        }
        repository.addNote(note)
    }
}