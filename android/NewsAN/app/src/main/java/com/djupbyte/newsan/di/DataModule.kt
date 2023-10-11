package com.djupbyte.newsan.di

import com.djupbyte.newsan.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
interface DataModule{
    @Binds
    fun bindsUserDataRepository(): UserDataRepository{
        return InitUserDataRepository()
    }
}

//userDataRepository: InitUserDataRepository