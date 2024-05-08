package resourses

import androidx.compose.ui.graphics.Color

expect class ColorResources {
    companion object {
        fun getPlatformColor(): Color
    }
}
