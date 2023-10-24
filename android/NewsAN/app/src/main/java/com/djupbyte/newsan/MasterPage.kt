//import androidx.compose.material3.Scaffold
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.djupbyte.newsan.BottomItems
import com.djupbyte.newsan.R
import com.djupbyte.newsan.features.SettingsDialog
import com.example.anNews.NavigationGraph


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
@OptIn(

    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
@ExperimentalMaterial3Api
fun MasterPage(
    darkTheme: Boolean,

    modifier: Modifier = Modifier
) {

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
                        showSettingsDialog = false
                    }
                )
            }
            Scaffold(
                modifier = Modifier.semantics {
                    testTagsAsResourceId = true
                },

                contentColor = MaterialTheme.colorScheme.onBackground,

//                topBar = {
//                    ANTopAppBar(
//                        text = "NewsAN",
//                        onActionClick = { showSettingsDialog = true },
//                        onNavigationIconClick = {},
//                    )
//
//
////                    TopAppBar(
////                    colors = TopAppBarDefaults.topAppBarColors(
////                        containerColor = MaterialTheme.colorScheme.primaryContainer,
////                        titleContentColor = MaterialTheme.colorScheme.primary,
////                    ),
////                    title = {
////                        Text("Small Top App Bar")
////                    }
////                )
//
//                },
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
                },

                ) { padding ->
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


                       var  id = if(darkTheme){
                            R.drawable.blobdark
                        }else{
                            R.drawable.blob
                        }

                        Box {
                            Image(
                                painter = painterResource(id = id ), contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .blur(
                                        radiusX = 10.dp,
                                        radiusY = 10.dp,
                                        edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(8.dp))
                                    )
                                    .offset(
                                        y = -60.dp,x=80.dp)

                            )



                            NavigationGraph(navController , onActionClick ={
                                showSettingsDialog = true
                            })

                        }



                    }


                }


            }

        }
    }


}


//            ModalNavigationDrawer(
//                drawerContent = {
//                    ModalDrawerSheet {
//                        Text("Settings", modifier = Modifier.padding(16.dp),fontWeight =  FontWeight.Bold)
//                        Divider()
//                        NavigationDrawerItem(
//                            icon = {Icon(
//                                NiaIcons.Info,
//                                contentDescription = "Theme",
//                                tint = MaterialTheme.colorScheme.primary
//                            )},
//                            label = { Text(text = "Theme") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//                        NavigationDrawerItem(
//                            icon = {Icon(
//                                NiaIcons.Star,
//                                contentDescription = "Saved Favorites",
//                                tint = MaterialTheme.colorScheme.primary
//                            )},
//                            label = { Text(text = "Saved Favorites") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//                        Text("Help and Support", modifier = Modifier.padding(16.dp), fontWeight =  FontWeight.Bold)
//                        NavigationDrawerItem(
//                            icon = {Icon(
//                                NiaIcons.Info,
//                                contentDescription = "Terms & Condition",
//                                tint = MaterialTheme.colorScheme.primary
//                            )},
//                            label = { Text(text = "Terms & Conditions") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//                        NavigationDrawerItem(
//                            icon = {Icon(
//                                NiaIcons.Feedback,
//                                contentDescription = "Give App Feedback",
//                                tint = MaterialTheme.colorScheme.primary
//                            )},
//                            label = { Text(text = "Give App Feedback") },
//                            selected = false,
//                            onClick = { /*TODO*/ }
//                        )
//
//                    }
//                }
//            ) {
//
//            }