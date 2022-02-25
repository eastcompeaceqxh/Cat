package com.xinghai.kotlin.catio.di

import com.xinghai.kotlin.catio.api.CatApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideInstance() : CatApiService {
        return CatApiService.create()
    }
}