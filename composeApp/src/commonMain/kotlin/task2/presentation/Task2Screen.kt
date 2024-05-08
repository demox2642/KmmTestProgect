package task2.presentation

import ImageResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import getPlatform
import kmmtestprogect.composeapp.generated.resources.Res
import kmmtestprogect.composeapp.generated.resources.play_bold_700
import kmmtestprogect.composeapp.generated.resources.task2
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import resourses.ColorResources

object Task2Screen : Tab {
    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(Res.string.task2)
            val icon = rememberVectorPainter(Icons.Default.Favorite)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        Scaffold(modifier = Modifier.padding(bottom = 50.dp)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier =
                        Modifier.weight(75f)
                            .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(painter = ImageResources.getPlatformImage(), "", modifier = Modifier.padding(top = 16.dp))
                }
                Row(
                    modifier =
                        Modifier.weight(25f)
                            .fillMaxWidth()
                            .background(ColorResources.getPlatformColor()),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = getPlatform().name, fontFamily = FontFamily(Font(Res.font.play_bold_700)))
                }
            }
        }
    }
}
