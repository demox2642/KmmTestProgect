
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    @OptIn(ExperimentalResourceApi::class)
    override val logo = DrawableResource("resourses/drawable/apple.png")
}

actual fun getPlatform(): Platform = IOSPlatform()
