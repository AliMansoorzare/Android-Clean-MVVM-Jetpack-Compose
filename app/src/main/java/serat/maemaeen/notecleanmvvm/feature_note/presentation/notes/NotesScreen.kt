package serat.maemaeen.notecleanmvvm.feature_note.presentation.notes

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gandiva.neumorphic.neu
import dagger.hilt.android.lifecycle.HiltViewModel
import serat.maemaeen.notecleanmvvm.R
import serat.maemaeen.notecleanmvvm.feature_note.domain.model.Note
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.*
import serat.maemaeen.notecleanmvvm.feature_note.presentation.isDarkTheme
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.components.*
import serat.maemaeen.notecleanmvvm.feature_note.presentation.util.Screen
import serat.maemaeen.notecleanmvvm.ui.theme.AppTextStyle
import java.util.*
import kotlin.collections.ArrayList


val fonts = FontFamily(
    Font(R.font.naz)
)
val typography = Typography(
    h6 = TextStyle(fontStyle = FontStyle.Italic, fontSize = 25.sp, fontFamily = fonts)
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NotesScreen(
    navController: NavController, viewModel: NotesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    navController.navigate(Screen.AddEditNoteScreen.route)
//                },
//                backgroundColor = MaterialTheme.colors.primary
//            ) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "افزودن یادداشت")
//            }
//        },

        scaffoldState = scaffoldState,

        ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                IconButton(onClick = { viewModel.onEvent(NotesEvent.ToggleOrderSection) }) {
//                    Icon(imageVector = Icons.Default.Sort, contentDescription = "مرتب سازی")
//
//                }

                    Sort(viewModel)


//                   TopBar()
//                    Box(modifier = Modifier
//                        .width(200.dp)
//                        .padding(10.dp)) {
//                        SearchView(state = textState)
//                    }


                    Box(modifier = Modifier) {
                        DarkModeAndLightMode(onThemeToggle = { isDarkTheme = !isDarkTheme })
                    }


                }
                AnimatedVisibility(
                    visible = state.isOrderSectionVisible,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    OrderSection(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        noteOrder = state.noteOrder,
                        onOrderChange = {
                            viewModel.onEvent(NotesEvent.Order(it))
                        }
                    )

                }


                Spacer(modifier = Modifier.height(5.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {




                    items(state.notes) { note ->

                        NoteItem(note = note, modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Screen.AddEditNoteScreen.route + "?noteId=${note.id}&noteColor=${note.color}")
                            },

                            onDeleteClick = {

                                viewModel.onEvent(NotesEvent.DeleteNote(note))
                                viewModel.onDeleteClick()
//                                scope.launch {
//
//                                    val result = scaffoldState.snackbarHostState.showSnackbar(
//                                        message = "یادداشت در حال حذف شدن.", actionLabel = "برگرداندن"
//                                    )
//                                    if (result == SnackbarResult.ActionPerformed) {
//                                        viewModel.onEvent(NotesEvent.RestoreNote)
//                                    }
//                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }


                }

            }
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Add(navController)
            }

        }


    }


    if (viewModel.isDialogShown) {
        DeleteDialog(
            onDismiss = { viewModel.onEvent(NotesEvent.RestoreNote) },
            onConfirm = { viewModel.onDismissDialog() })
    }
}

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {

    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .neu(defaultPressedNetAttrsSearchView())
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("")
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = colorResource(id = R.color.black),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.main),
        contentColor = Color.White
    )
}



