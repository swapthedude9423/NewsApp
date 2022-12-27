package com.lastmile.wanicity.data.repository

import com.lastmile.wanicity.data.api.ApiHelper
import org.koin.dsl.module

val repoModule = module {
    single { MainRepository(get()) }
}