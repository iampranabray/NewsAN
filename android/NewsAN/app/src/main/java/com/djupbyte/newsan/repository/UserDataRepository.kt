package com.djupbyte.newsan.repository
import com.djupbyte.newsan.features.DarkThemeConfig
import com.djupbyte.newsan.features.ThemeBrand
import kotlinx.coroutines.flow.Flow

interface UserDataRepository{
    val userData: Flow<UserData>
    /**
     * Sets the desired theme brand.
     */
    suspend fun setThemeBrand(themeBrand: ThemeBrand)

    /**
     * Sets the desired dark theme config.
     */
    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)
    //suspend fun setDynamicColorPreference(useDynamicColor: Boolean)
}

data class UserData(
//    val bookmarkedNewsResources: Set<String>,
//    val viewedNewsResources: Set<String>,
//    val followedTopics: Set<String>,
    val themeBrand: ThemeBrand,
    val darkThemeConfig: DarkThemeConfig,
//    val useDynamicColor: Boolean,
//    val shouldHideOnboarding: Boolean,
)