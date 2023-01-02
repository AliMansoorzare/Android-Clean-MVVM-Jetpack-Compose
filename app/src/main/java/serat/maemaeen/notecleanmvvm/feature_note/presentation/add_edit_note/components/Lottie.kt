package serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import serat.maemaeen.notecleanmvvm.R
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.gandiva.neumorphic.neu
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.AddEditNoteEvent
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.NotesEvent
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.NotesViewModel
import serat.maemaeen.notecleanmvvm.feature_note.presentation.util.Screen

@Composable
fun Delete() {


    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.deleteicon)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(3f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(composition = composition, progress = progress, modifier = Modifier.neu(defaultPressedNetAttrs()))

}

@Composable
fun Sort(viewModel: NotesViewModel) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.toggle)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(3f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.neu(defaultPressedNetAttrs())
            .height(70.dp)
            .width(70.dp).padding(5.dp)
            .clickable {
                viewModel.onEvent(
                    NotesEvent.ToggleOrderSection
                )
            })
}

@Composable
fun Add(navController: NavController) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.addnew)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(3f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.neu(defaultPressedNetAttrs())
            .height(80.dp)
            .width(80.dp)
            .padding(5.dp)
            .clickable {
                navController.navigate(Screen.AddEditNoteScreen.route)
            })
}

@Composable
fun AddEdit(viewModel: AddEditNoteViewModel) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.save)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(2f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.neu(defaultPressedNetAttrs())
            .height(80.dp)
            .width(80.dp)
            .padding(5.dp)
            .clickable {
                viewModel.onEvent(AddEditNoteEvent.SaveNote)
            })
}

@Composable
fun DeletingItem() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.deleteitem)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(3f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.neu(defaultPressedNetAttrs())
            .height(110.dp)
            .width(110.dp)
            .padding(5.dp)
    )
}

@Composable
fun DarkModeAndLightMode(onThemeToggle:() -> Unit){
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.darkmodeandlightmodebutton)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember {
        mutableStateOf(1f)
    }
    val progress by animateLottieCompositionAsState(
        isPlaying = isPlaying,
        speed = speed,
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = progress,
        modifier = Modifier.neu(defaultPressedNetAttrs())
            .height(70.dp)
            .width(70.dp)
            .padding(5.dp).clickable { onThemeToggle() }
    )
}

