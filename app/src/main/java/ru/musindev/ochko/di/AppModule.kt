package ru.musindev.ochko.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.musindev.ochko.data.repository.DeckRepositoryImpl
import ru.musindev.ochko.domain.repository.DeckRepository
import ru.musindev.ochko.domain.usecase.CalculateHandValueUseCase
import ru.musindev.ochko.domain.usecase.CheckWinnerUseCase
import ru.musindev.ochko.domain.usecase.ShouldDealerDrawUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDeckRepository(): DeckRepository {
        return DeckRepositoryImpl()
    }

    @Provides
    fun provideCalculateHandValueUseCase(): CalculateHandValueUseCase {
        return CalculateHandValueUseCase()
    }

    @Provides
    fun provideShouldDealerDrawUseCase(): ShouldDealerDrawUseCase {
        return ShouldDealerDrawUseCase()
    }

    @Provides
    fun provideCheckWinnerUseCase(): CheckWinnerUseCase {
        return CheckWinnerUseCase()
    }
}
