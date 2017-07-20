package boonya.ben.callingwebservice.model

import com.google.gson.annotations.SerializedName

/**
 * Created by oozou on 7/12/2017 AD.
 */
data class SpeciesList(@SerializedName("results") val speciesList: List<Species>, val next: String?)