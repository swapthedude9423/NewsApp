package com.lastmile.wanicity.di.module

import com.lastmile.wanicity.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
  viewModel {
       MainViewModel(get(),get())
  }
}