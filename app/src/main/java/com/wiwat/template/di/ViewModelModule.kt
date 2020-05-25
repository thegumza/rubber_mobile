package com.wiwat.template.di


import com.wiwat.template.view.base.BaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    //Base ViewModel
    viewModel { BaseViewModel(get()) }

}