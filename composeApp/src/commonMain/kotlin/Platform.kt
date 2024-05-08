import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

interface Platform {
    val name: String

    @OptIn(ExperimentalResourceApi::class)
    val logo: DrawableResource
}

expect fun getPlatform(): Platform
