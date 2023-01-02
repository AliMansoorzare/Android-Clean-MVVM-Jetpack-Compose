package serat.maemaeen.notecleanmvvm.feature_note.domain.model

import android.content.Context
import android.widget.Toast
import androidx.room.Entity
import androidx.room.PrimaryKey
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.Purple200
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.Purple500
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.main
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.red
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.status
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors.text


@Entity(tableName = "note")
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(
            main,
            status,
            red,AppColors.teal_200,AppColors.teal_700,Purple500
        )
    }
}

class InvalidNoteException(message: String) : Exception(message)
