package boonya.ben.callingwebservice.species

import boonya.ben.callingwebservice.model.Species
import boonya.ben.callingwebservice.model.SpeciesList
import com.ben.boonya.architecturecomponentdemo.common.api.Swapi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by oozou on 7/12/2017 AD.
 */

class SpeciesRepositoryImpl(val apiService: Swapi) : SpeciesRepository {

    override fun getSpecies(successHandler: (List<Species>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        apiService.getSpecies().enqueue(object : Callback<SpeciesList> {
            override fun onResponse(call: Call<SpeciesList>?, response: Response<SpeciesList>?) {
                response?.body()?.let {
                    successHandler(it.speciesList)
                }
            }

            override fun onFailure(call: Call<SpeciesList>?, t: Throwable?) {
                failureHandler(t)
            }
        })
    }
}
