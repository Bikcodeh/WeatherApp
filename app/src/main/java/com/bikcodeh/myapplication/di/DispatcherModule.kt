package com.bikcodeh.myapplication.di

import com.bikcodeh.myapplication.data.repository.DispatcherProviderImpl
import com.bikcodeh.myapplication.domain.repository.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()
}