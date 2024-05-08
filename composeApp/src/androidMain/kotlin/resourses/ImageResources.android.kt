import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

actual class ImageResources {
    actual companion object {
        @OptIn(ExperimentalResourceApi::class)
        @Composable
        actual fun getPlatformImage() = painterResource(DrawableResource("drawable/android.png"))
    }
}
