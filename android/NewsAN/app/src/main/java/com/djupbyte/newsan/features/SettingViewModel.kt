import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
):ViewModel(){

}

data class UserEditableSettings(
    val brand: ThemeBrand,
    val useDynamicColor: Color,
    val darkThemeConfig: DarkThemeConfig

)

sealed interface SettingUiState{

    object Loading: SettingUiState
    data class Sucess(val settings: UserEditableSettings): SettingUiState
}