package com.example.p1_ap2_alvaro_20190269.di

import android.content.Context
import androidx.room.Room
import com.example.p1_ap2_alvaro_20190269.data.PrestamoDao
import com.example.p1_ap2_alvaro_20190269.data.PrestamoRepository
import com.example.p1_ap2_alvaro_20190269.data.PrestamosDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun ProvidesPrestamosDb(@ApplicationContext context: Context): PrestamosDb{
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            "PrestamosDb"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidesPrestamoDAO(prestamosDb: PrestamosDb): PrestamoDao{
        return prestamosDb.prestamoDao
    }

    @Provides
    fun ProvidesPrestamoRepository(prestamoDao: PrestamoDao): PrestamoRepository{
        return PrestamoRepository(prestamoDao)
    }
}