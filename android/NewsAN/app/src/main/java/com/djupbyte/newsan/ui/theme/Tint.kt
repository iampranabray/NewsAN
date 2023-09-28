import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class TintTheme(
    val iconTint: Color? =null
)

val LocalTintTheme = staticCompositionLocalOf { TintTheme() }