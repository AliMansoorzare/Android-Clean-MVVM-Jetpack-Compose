package serat.maemaeen.notecleanmvvm.feature_note.presentation.notes

import androidx.room.FtsOptions
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.domain.use_case.GetNotes
import serat.maemaeen.notecleanmvvm.feature_note.domain.util.NoteOrder
import serat.maemaeen.notecleanmvvm.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
