package serat.maemaeen.notecleanmvvm.feature_note.presentation.add_edit_note.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.res.ResourcesCompat
import com.airbnb.lottie.compose.*
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.*
import serat.maemaeen.notecleanmvvm.R
import serat.maemaeen.notecleanmvvm.feature_note.presentation.notes.typography
import serat.maemaeen.notecleanmvvm.ui.theme.AppColors

val defaultWidgetPadding = 10.dp
val defaultElevation = 6.dp
val defaultCornerShape: CornerShape = RoundedCorner(12.dp)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DeleteDialog(
    onDismiss: () -> Unit, onConfirm: () -> Unit
) {

    androidx.compose.ui.window.Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = true)
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .neu(defaultPressedNetAttrs())
                .fillMaxWidth(0.95f)
                .border(1.dp, color = AppColors.teal_700, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Text(
                    text = "اطمینان از حذف؟",
                    style = typography.h6,
                    textAlign = TextAlign.Center, modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

//                        Image(
//                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                            contentDescription = "ali",
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f)
//                                .clip(
//                                    RoundedCornerShape(15.dp)
//                                )
//                                .clickable { })
                    Box(modifier = Modifier.align(Alignment.CenterVertically)) {
                        DeletingItem()
                    }


                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onDismiss() },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppColors.teal_700,
                            contentColor = AppColors.white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), shape = CircleShape
                    ) {
                        Text(
                            text = "لغو",
                            style = typography.h6,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(
                        onClick = { onConfirm() },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppColors.teal_700,
                            contentColor = AppColors.white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f), shape = CircleShape
                    ) {
                        Text(
                            text = "تایید",
                            style = typography.h6,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center, modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmptyStateDialog(
    dialogState:Boolean, onDismiss: (dialogState:Boolean) -> Unit
) {

    androidx.compose.ui.window.Dialog(
        onDismissRequest = { onDismiss(dialogState) },
        properties = DialogProperties(usePlatformDefaultWidth = true)
    ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
//                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                val composition by rememberLottieComposition(
                    LottieCompositionSpec
                        .RawRes(R.raw.emptystate)
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
                    modifier = Modifier.fillMaxSize().clickable { onDismiss(dialogState) }

                )




            }



    }
}
@Composable
fun defaultPressedNetAttrs() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Pressed(defaultCornerShape),
)
@Composable
fun defaultPressedNetAttrsSearchView() = NeuAttrs(
    lightShadowColor = AppColors.lightShadow(),
    darkShadowColor = AppColors.darkShadow(),
    shadowElevation = defaultElevation,
    lightSource = LightSource.LEFT_TOP,
    shape = Pressed(RoundedCorner(0.dp)),
)
//@Composable
//fun TitleWithThemeToggle(title: String, isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            modifier = Modifier
//                .weight(1f)
//                .padding(horizontal = defaultWidgetPadding),
//            text = title,
//            style = AppTextStyle.body1(), maxLines = 1
//        )
//        ImageButton(
//            modifier = Modifier.padding(defaultWidgetPadding),
//            drawableResId = if (isDarkTheme) DarkModeAndLightMode()
//            else DarkModeAndLightMode(),
//            contentDescription = "Toggle theme",
//            onClick = onThemeToggle
//        )

//    }
//}
//@Composable
//fun ImageButton(
//    modifier: Modifier,
//    @DrawableRes drawableResId: Int,
//    contentDescription: String = "",
//    onClick: () -> Unit
//) {
//    Card(
//        modifier = modifier
//            .size(48.dp)
//            .neu(
//                lightShadowColor = AppColors.lightShadow(),
//                darkShadowColor = AppColors.darkShadow(),
//                shadowElevation = defaultElevation,
//                lightSource = LightSource.LEFT_TOP,
//                shape = Flat(Oval),
//            ),
//        elevation = 0.dp,
//        shape = RoundedCornerShape(24.dp),
//    ) {
//        Image(
//            modifier = Modifier.clickable(true, onClick = onClick),
//            painter = painterResource(id = drawableResId),
//            contentDescription = contentDescription,
//            contentScale = ContentScale.Inside,
//            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
//        )
//    }
//}


//@Composable
//fun Img() {
//
//            Image(
//                painterResource(R.drawable.main),
//                contentDescription = "f",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//
//}
