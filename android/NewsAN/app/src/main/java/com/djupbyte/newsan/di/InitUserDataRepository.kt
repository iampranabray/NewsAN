package com.djupbyte.newsan.di

import com.djupbyte.newsan.features.DarkThemeConfig
import com.djupbyte.newsan.features.ThemeBrand
import com.djupbyte.newsan.repository.UserData
import com.djupbyte.newsan.repository.UserDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InitUserDataRepository() : UserDataRepository {

    private val _setDarkTheme = MutableStateFlow<UserData>(UserData(
        darkThemeConfig = DarkThemeConfig.FOLLOW_SYSTEM,
        themeBrand = ThemeBrand.ANDROID,
               // currentDestination =
    //     bookmarkedNewsResources= ,
//     viewedNewsResources = ,
//     followedTopics=,
//     themeBrand=,
//     useDynamicColor=,
//     shouldHideOnboarding=,
    ))
    private var setDarkTheme: StateFlow<UserData> = _setDarkTheme

    override var userData: StateFlow<UserData> = setDarkTheme
    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        _setDarkTheme.value = _setDarkTheme.value.copy(themeBrand=themeBrand)
    }
    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        _setDarkTheme.value = _setDarkTheme.value.copy(darkThemeConfig=darkThemeConfig)
    }

//    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
//        // dataSource.setDynamicColorPreference(useDynamicColor)
//    }

}