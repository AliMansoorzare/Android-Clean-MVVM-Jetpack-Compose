package serat.maemaeen.notecleanmvvm.feature_note.presentation.util

import android.transition.Scene

sealed class Screen(val route:String){
    object NoteScreen:Screen("note_screen")
    object AddEditNoteScreen:Screen("add_edit_note_screen")
}
