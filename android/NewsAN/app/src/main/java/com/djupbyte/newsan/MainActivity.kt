package com.djupbyte.newsan

//import com.designsystem.uicomponent.NiaTopAppBar
import MasterPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.djupbyte.newsan.features.DarkThemeConfig
import com.djupbyte.newsan.features.SettingUiState
import com.djupbyte.newsan.features.SettingViewModel
import com.djupbyte.newsan.features.ThemeBrand
import com.example.anNews.ui.theme.PRTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<MainActivityViewModel>(
//
//    )

    private val settingViewModel: SettingViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var uiState : SettingUiState by mutableStateOf(SettingUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                settingViewModel.settingsUiState
                    .onEach {
                        uiState = it
                    }
                    .collect()

            }
        }
        //transparent
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val darkTheme = shouldUseDarkTheme(uiState)

            PRTheme(
                darkTheme = darkTheme,
                androidTheme= shouldUseAndroidTheme(uiState)
            ) {

                MasterPage()
            }
        }
    }
}

@Composable
private fun shouldUseDarkTheme(
    counterModel: SettingUiState
): Boolean = when (counterModel) {
    SettingUiState.Loading -> isSystemInDarkTheme()
    is SettingUiState.Success -> when(counterModel.settings.darkThemeConfig){
        DarkThemeConfig.FOLLOW_SYSTEM->isSystemInDarkTheme()
        DarkThemeConfig.LIGHT -> false
        DarkThemeConfig.DARK -> true
    }
}

@Composable
private fun shouldUseAndroidTheme(
    uiState: SettingUiState,
): Boolean = when (uiState) {
    SettingUiState.Loading -> false
    is SettingUiState.Success -> when (uiState.settings.brand) {
        ThemeBrand.DEFAULT -> false
        ThemeBrand.ANDROID -> true
    }
}


//@HiltViewModel
//class MainActivityViewModel @Inject constructor(
//
//) : ViewModel() {
//
//    /// stateFlow
//    private val _darkTheme = MutableStateFlow(false)
//    val darkThemeSF = _darkTheme.asStateFlow()
//
//    ///compose state
//    var darkTheme by mutableStateOf(false)
//        private set
//
//    fun changeThemeByComposeState() {
//        ///compose state
//        darkTheme = !darkTheme
//    }
//
//    fun changeThemeByStateFlow() {
//        /// stateFlow
//        _darkTheme.value = !_darkTheme.value
//    }
//}


//
//            val viewModel =
//                viewModel<MainActivityViewModel>(
//
////                    factory = object : ViewModelProvider.Factory {
////                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
////                        return MainActivityViewModel(str = "Hello") as T
////                    }
////                    }
//                )

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PRTheme {
        val navController = rememberNavController()
          //  MasterPage()
    }
}