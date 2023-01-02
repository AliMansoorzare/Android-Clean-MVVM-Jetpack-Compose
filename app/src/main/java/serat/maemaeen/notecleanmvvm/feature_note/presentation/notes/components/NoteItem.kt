package serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.gandiva.neumorphic.neu
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.Delete
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.defaultPressedNetAttrs
import serat.maemaeen.notecleanmvvm.feature_note.presentation.util.setPersianNumbers

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Box(modifier = modifier) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                close()
            }
            clipPath(clipPath) {

                drawRoundRect(
                    color = Color(note.color),
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = Color(ColorUtils.blendARGB(note.color,0x000000, 0.2f)),
                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size( cutCornerSize.toPx()+100f, cutCornerSize.toPx()+100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }
        Column(
            modifier = Modifier
                .blur(radius = 20.dp)
                .fillMaxSize()
                .padding(16.dp)
                .padding(start = 32.dp, end = 20.dp, bottom = 20.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = note.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,

                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = note.content,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
        val pdate = PersianDate()
        val persianDateFormat = PersianDateFormat("Y,m,d")
        val date = persianDateFormat.format(pdate)
        val perDate = setPersianNumbers(date.toString())
        Text(modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 10.dp, bottom = 5.dp, start = 10.dp), text = perDate
        )


        Box(modifier = Modifier
            .clickable { onDeleteClick() }
            .align(Alignment.BottomStart)
            .padding(5.dp)
            .width(40.dp)
            .height(40.dp)) {
            Delete()
        }
//        IconButton(onClick = onDeleteClick, modifier = Modifier.align(Alignment.BottomStart)) {
//            Icon(imageVector = Icons.Default.Delete, contentDescription = "حذف یادداشت", tint = MaterialTheme.colors.onSurface)
//        }
    }
}