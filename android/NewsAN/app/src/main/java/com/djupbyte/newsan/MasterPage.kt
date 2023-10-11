
//import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.rememberNavController
import com.djupbyte.newsan.BottomItems
import com.djupbyte.newsan.features.SettingsDialog
import com.example.anNews.NavigationGraph
import com.example.anNews.component.ANTopAppBar


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(

    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun MasterPage(

    modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    var selectedItem = rememberSaveable {
        mutableStateOf("Home")
    }
    var showSettingsDialog by rememberSaveable {
        mutableStateOf(false)
    }

//    var settingViewModel = viewModel<com.djupbyte.newsan.features.SettingViewModel>(
//        factory = object : ViewModelProvider.Factory {
//            override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                return com.djupbyte.newsan.features.SettingViewModel(userDataRepository = ) as T
//            }
//        }
//    );

    NiaBackground {
        PRGradientBackground(
            gradientColors = if (true) {
                LocalGradientColors.current
            } else {
                GradientColors()
            },
        ) {
            if (showSettingsDialog) {
                SettingsDialog(
                    onDismiss = {
                        //settingViewModel.settingsUiState
                        showSettingsDialog =  false
                    }
                )
            }
            Scaffold(
                modifier = Modifier.semantics {
                    testTagsAsResourceId = true
                },

                contentColor = MaterialTheme.colorScheme.onBackground,
                //topBar = { TopAppBar(title = { Text("$name") }) },
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                containerColor = Color.Transparent,

                bottomBar = {
                    BottomAppBar {
                        BottomItems().bottomItems.forEachIndexed { index, bottomNavItem ->
                            NavigationBarItem(
                                selected = selectedItem.value == bottomNavItem.name,
                                icon = {
                                    Icon(
                                        imageVector = bottomNavItem.icon,
                                        contentDescription = bottomNavItem.name
                                    )
                                },
                                onClick = {
                                    selectedItem.value = bottomNavItem.name
                                    navController.navigate(bottomNavItem.route) {

                                    }

                                },
                                label = {
                                    Text(text = bottomNavItem.name)
                                },
                                enabled = true
                            )
                        }

                    }
                }) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .consumeWindowInsets(padding)
                        .padding(padding)
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal,
                            ),
                        ),
                ) {

                    Column(
                        Modifier.fillMaxSize()
                    ) {
                        ANTopAppBar(
                            text = "News1",
                            onActionClick = { showSettingsDialog = true },
                            onNavigationIconClick = {},
                        )
                        NavigationGraph(navController)
                    }


                }


            }
        }
    }


}