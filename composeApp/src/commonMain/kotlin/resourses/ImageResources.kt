import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

expect class ImageResources {
    companion object {
        @Composable
        fun getPlatformImage(): Painter
    }
}
