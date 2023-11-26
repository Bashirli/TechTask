package com.bashirli.techtask.di

import com.bashirli.techtask.data.repository.ServiceRepository
import com.bashirli.techtask.data.repository.ServiceRepositoryImpl
import com.bashirli.techtask.data.service.Service
import com.bashirli.techtask.data.source.ServiceSource
import com.bashirli.techtask.data.source.ServiceSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {

    @Singleton
    @Provides
    fun injectService() = Service()

    @Singleton
    @Provides
    fun injectServiceSource(service: Service) = ServiceSourceImpl(service) as ServiceSource

    @Singleton
    @Provides
    fun injectServiceRepo(source: ServiceSource) =
        ServiceRepositoryImpl(source) as ServiceRepository

}