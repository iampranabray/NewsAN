import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.anNews.ui.theme.PRTheme


@Composable
fun SettingsDialog(
    onDismiss: () -> Unit,
    //viewModel: MainActivityViewModel = hiltViewModel()
) {


    val configuration = LocalConfiguration.current
    AlertDialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier.widthIn(max = configuration.screenWidthDp.dp - 80.dp),
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        },
        text = {

            Divider()
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                SettingsPanel(
                    onChangeThemeBrand =  {}
                    //viewModel::
                )
            }


        },
        confirmButton = {
            Text(text = "Ok",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding()
                    .clickable { onDismiss() }

            )


        }
    )
}

@Composable
private fun SettingsPanel(
    onChangeThemeBrand: ()->Unit
) {
    var selectedOption by rememberSaveable {
        mutableStateOf<ThemeBrand>(ThemeBrand.DEFAULT)
    }
    var darkThemeConfig by rememberSaveable {
        mutableStateOf<DarkThemeConfig>(DarkThemeConfig.LIGHT)
    }

    Text(
        text = "Theme", modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        )
    )
    Column(
        Modifier.selectableGroup()
    ) {

        RadioButtonOption(
            text = "Default",
            isSelected = ThemeBrand.DEFAULT == selectedOption,
            onOptionSelected = { selectedOption = ThemeBrand.DEFAULT })

        RadioButtonOption(
            text = "Android",
            isSelected = ThemeBrand.ANDROID == selectedOption,
            onOptionSelected = {
                selectedOption = ThemeBrand.ANDROID
                //viewModel.changeTheme()
            })


    }
    Text(
        "Use Dynamic Color",
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        )
    )
    Column(
        Modifier

            .selectableGroup()
    ) {
        RadioButtonOption(
            text = "Yes",
            isSelected = ThemeBrand.ANDROID == selectedOption,
            onOptionSelected = {
                selectedOption = ThemeBrand.ANDROID
                //viewModel.changeTheme()
            })
        RadioButtonOption(
            text = "No",
            isSelected = ThemeBrand.ANDROID == selectedOption,
            onOptionSelected = {
                selectedOption = ThemeBrand.ANDROID
                //viewModel.changeTheme()
            })
    }
    Text(
        "Dark Mode Preference",
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
        )
    )
    Column(
        Modifier.selectableGroup()
    ) {
        RadioButtonOption(
            text = "System Default",
            isSelected = DarkThemeConfig.FOLLOW_SYSTEM == darkThemeConfig,
            onOptionSelected = {
                darkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM
                //viewModel.changeTheme()
            })
        RadioButtonOption(
            text = "Light",
            isSelected = DarkThemeConfig.LIGHT == darkThemeConfig,
            onOptionSelected = {
                darkThemeConfig = DarkThemeConfig.LIGHT
                //viewModel.changeTheme()
            })
        RadioButtonOption(
            text = "Dark",
            isSelected = DarkThemeConfig.DARK == darkThemeConfig,
            onOptionSelected = {
                darkThemeConfig = DarkThemeConfig.DARK

                //viewModel.changeThemeByStateFlow()
            })
    }

}


enum class DarkThemeConfig {
    FOLLOW_SYSTEM, LIGHT, DARK
}

enum class ThemeBrand {
    DEFAULT,
    ANDROID
}

@Preview
@Composable
private fun PreviewSettingsDialogLoading() {
    PRTheme {
        SettingsDialog(
            onDismiss = {},

            )
    }

}