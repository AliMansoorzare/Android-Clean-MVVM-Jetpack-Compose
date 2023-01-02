package serat.maemaeen.notecleanmvvm.feature_note.presentation

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gandiva.neumorphic.shape.CornerShape
import com.gandiva.neumorphic.shape.RoundedCorner
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.AddEditNoteScreen
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components.EmptyStateDialog
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.NotesScreen
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.NotesViewModel
import serat.maemaeen.notecleanmvvm.feature_note.presentation.util.Screen
import serat.maemaeen.notecleanmvvm.ui.theme.NeumorphismTheme
import serat.maemaeen.notecleanmvvm.ui.theme.NoteCleanMvvmTheme

var isDarkTheme by
mutableStateOf(false)

fun Context.showToast(string: String) {
    Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: NotesViewModel by viewModels()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContent {
            val navController = rememberNavController()
            NeumorphismTheme(isDarkTheme = isDarkTheme) {
                Surface(color = MaterialTheme.colors.background) {


                    NavHost(
                        navController = navController,
                        startDestination = Screen.NoteScreen.route
                    ) {
                        composable(route = Screen.NoteScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
//                                    nullable = true
                                },
                                navArgument(
                                    name = "noteColor"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },

                                )
                        ) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(navController = navController, noteColor = color)
                        }
                    }

                }
            }
//            Img()
            var dialogState by remember {
                mutableStateOf(false)
            }

           if(viewModel.state.value.notes.isEmpty() && !dialogState){

               EmptyStateDialog(dialogState = dialogState, onDismiss = {
                   dialogState = !it
               })
           }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteCleanMvvmTheme {


    }
}