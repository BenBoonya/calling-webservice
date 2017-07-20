package boonya.ben.callingwebservice.di

import com.ben.boonya.architecturecomponentdemo.common.api.Swapi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by oozou on 7/20/2017 AD.
 */
@Module
class ApiModule(val baseUrl: String) {
    @Provides @Singleton
    fun provideApiService(): Swapi {
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(Swapi::class.java)
    }
}