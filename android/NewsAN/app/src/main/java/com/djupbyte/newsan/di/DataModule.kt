package com.djupbyte.newsan.di

import com.djupbyte.newsan.repository.UserDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataModule{
    @Provides
    @Singleton
    fun bindsUserDataRepository(): UserDataRepository{
        return InitUserDataRepository()
    }
}

//userDataRepository: InitUserDataRepository