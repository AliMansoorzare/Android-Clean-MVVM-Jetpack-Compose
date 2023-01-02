package serat.maemaeen.notecleanmvvm.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
object AppColors {
    val Purple200 = Color(0xFF67626D)
    val Purple500 = Color(0x5DA7AF0E)
    val Purple700 = Color(0x960873BB)
    val teal_200 = Color(0x8B20B5B3)
    val teal_700 = Color(0x8AFF9100)
    val white = Color(0x9BDDE4E2)
    val red = Color(0x8CF1011A)
    val main = Color(0x8B5FFEFD)
    val text = Color(0x7F060001)
    val status = Color(0x981C6CEF)

    object Light {
        val Background = Color(0xFFDCDCDC)
        val LightShadow = Color(0xFFFFFFFF)
        val DarkShadow = Color(0xFFA8B5C7)
        val TextColor = Color.Black
    }

    object Dark {
        val Background = Color(0xFF202122)
        val LightShadow = Color(0x66494949)
        val DarkShadow = Color(0x66000000)
        val TextColor = Color.White
    }

    @Composable
    fun lightShadow() = if (MaterialTheme.colors.isLight) Light.LightShadow else Dark.LightShadow

    @Composable
    fun darkShadow() = if (MaterialTheme.colors.isLight) Light.DarkShadow else Dark.DarkShadow
}