import android.service.autofill.UserData
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
}