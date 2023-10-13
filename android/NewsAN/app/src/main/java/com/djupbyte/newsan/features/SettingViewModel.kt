package com.djupbyte.newsan.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djupbyte.newsan.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(
    private val userDataRepository: UserDataRepository
) : ViewModel() {
    val settingsUiState: StateFlow<SettingUiState> =
        userDataRepository.userData
            .map { userData ->
                SettingUiState.Success(
                    settings = UserEditableSettings(
                        brand = userData.themeBrand,
//                        useDynamicColor = userData.useDynamicColor,
                        darkThemeConfig = userData.darkThemeConfig
                    )
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = SettingUiState.Loading
            )
    fun updateThemeBrand(themeBrand: ThemeBrand){
        viewModelScope.launch {
            userDataRepository.setThemeBrand(themeBrand)
        }
    }
    fun updateDarkThemeConfig(darkThemeConfig: DarkThemeConfig){
        viewModelScope.launch {
            userDataRepository.setDarkThemeConfig(darkThemeConfig)
        }

    }
//    fun updateDynamicColorPreference(useDynamicColor: Boolean){
//        viewModelScope.launch{
//            userDataRepository.setDynamicColorPreference(useDynamicColor)
//        }
//    }

}

data class UserEditableSettings(
    val brand: ThemeBrand,
//    val useDynamicColor: Boolean,
    val darkThemeConfig: DarkThemeConfig

)

sealed interface SettingUiState {
    object Loading : SettingUiState
    data class Success(val settings: UserEditableSettings) : SettingUiState
}