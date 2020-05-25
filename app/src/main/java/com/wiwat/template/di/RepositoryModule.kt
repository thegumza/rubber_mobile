package com.wiwat.template.di

import com.wiwat.template.domain.BaseRepository
import com.wiwat.template.domain.BaseRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    //Base Repository
    single<BaseRepository>(createdAtStart = true) { BaseRepositoryImpl(get()) }
}