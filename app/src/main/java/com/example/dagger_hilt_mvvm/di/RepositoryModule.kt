package com.example.dagger_hilt_mvvm.di

import com.example.dagger_hilt_mvvm.database.BlogDao
import com.example.dagger_hilt_mvvm.database.CacheMapper
import com.example.dagger_hilt_mvvm.network.BlogApi
import com.example.dagger_hilt_mvvm.network.BlogMapper
import com.example.dagger_hilt_mvvm.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        blogApi: BlogApi,
        cacheMapper: CacheMapper,
        blogMapper: BlogMapper
    ): MainRepository {
        return MainRepository(blogDao, blogApi, cacheMapper, blogMapper)
    }
}