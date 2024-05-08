import android.os.Build
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"

    @OptIn(ExperimentalResourceApi::class)
    override val logo = DrawableResource("resourses/drawable/android.png")
}

actual fun getPlatform(): Platform = AndroidPlatform()
