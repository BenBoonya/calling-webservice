package boonya.ben.callingwebservice.species

import boonya.ben.callingwebservice.model.SpeciesList
import com.ben.boonya.architecturecomponentdemo.common.api.Apis
import com.ben.boonya.architecturecomponentdemo.common.api.Swapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by oozou on 7/12/2017 AD.
 */

class SpeciesRepositoryImpl(val apiService: Swapi) : SpeciesRepository {

    override fun getSpecies(successHandler: (SpeciesList?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        apiService.getSpecies().enqueue(object : Callback<SpeciesList> {
            override fun onResponse(call: Call<SpeciesList>?, response: Response<SpeciesList>?) {
                response?.body()?.let {
                    successHandler(it)
                }
            }

            override fun onFailure(call: Call<SpeciesList>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }
}
