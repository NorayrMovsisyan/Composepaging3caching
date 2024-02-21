package com.example.composepaging3caching.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.composepaging3caching.BuildConfig
import com.example.composepaging3caching.data.local.BeerDatabase
import com.example.composepaging3caching.data.local.BeerEntity
import com.example.composepaging3caching.data.remot.BeerApi
import com.example.composepaging3caching.data.remot.BeerRemoteMediator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


val AppModule = module {
    single { provideBeerDatabase(androidContext()) }
    single { provideBeerApi() }
    single { provideBeerPager(get(), get()) }
}

fun provideBeerDatabase(context: Context): BeerDatabase {
    return Room.databaseBuilder(
        context,
        BeerDatabase::class.java,
        "beers.db"
    ).build()
}

fun provideBeerApi(): BeerApi {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create()
}

@OptIn(ExperimentalPagingApi::class)
fun provideBeerPager(beerDb: BeerDatabase, beerApi: BeerApi): Pager<Int, BeerEntity> {
    return Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = BeerRemoteMediator(
            beerDb = beerDb,
            beerApi = beerApi
        ),
        pagingSourceFactory = {
            beerDb.dao.pagingSource()
        }
    )
}