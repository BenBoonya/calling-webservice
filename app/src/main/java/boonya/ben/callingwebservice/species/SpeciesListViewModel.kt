package boonya.ben.callingwebservice.species

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import boonya.ben.callingwebservice.model.Species
import javax.inject.Inject

/**
 * Created by oozou on 7/12/2017 AD.
 */
class SpeciesListViewModel : ViewModel() {

    @Inject
    lateinit var repository: SpeciesRepository

    var isLoading = MutableLiveData<Boolean>()

    var apiError = MutableLiveData<Throwable>()

    var speciesResponse = MutableLiveData<List<Species>>()

    fun getSpecies() {
        isLoading.value = true
        repository.getSpecies(
                {
                    speciesResponse.value = it
                    isLoading.value = false
                },

                {
                    apiError.value = it
                    isLoading.value = false
                })
    }


    /**
     * Adapter Callback
     */

    fun getSpeciesAt(position: Int): Species? {
        if (position < getSpeciesSize()) {
            return speciesResponse.value?.get(position)
        } else {
            return null
        }
    }

    fun getSpeciesSize(): Int {
        speciesResponse.value?.let {
            return it.size
        }
        return 0
    }

}