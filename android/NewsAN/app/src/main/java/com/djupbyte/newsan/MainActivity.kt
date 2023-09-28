package com.djupbyte.newsan

//import com.designsystem.uicomponent.NiaTopAppBar
import MasterPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.anNews.ui.theme.PRTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class MainActivity : ComponentActivity() {
//    private val viewModel by viewModels<MainActivityViewModel>(
//
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {

            val viewModel =
                viewModel<MainActivityViewModel>(

//                    factory = object : ViewModelProvider.Factory {
//                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                        return MainActivityViewModel(str = "Hello") as T
//                    }
//                    }
                )

            val darkViewModel by viewModel.darkThemeSF.collectAsState()
            PRTheme(
                darkTheme = darkViewModel
                //viewModel.darkTheme
            ) {

                MasterPage()
            }
        }
    }
}




@HiltViewModel
class MainActivityViewModel @Inject constructor(

) : ViewModel() {

    /// stateFlow
    private val _darkTheme = MutableStateFlow(false)
    val darkThemeSF = _darkTheme.asStateFlow()

    ///compose state
    var darkTheme by mutableStateOf(false)
        private set

    fun changeThemeByComposeState() {
        ///compose state
        darkTheme = !darkTheme
    }

    fun changeThemeByStateFlow() {
        /// stateFlow
        _darkTheme.value = !_darkTheme.value
    }
}






@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PRTheme {
        val navController = rememberNavController()
        MasterPage()
    }
}