package boonya.ben.callingwebservice.model

import com.google.gson.annotations.SerializedName

/**
 * Created by oozou on 7/12/2017 AD.
 */
data class Species(val name : String, val classification : String, val language : String, @SerializedName("average_lifespan") val lifeSpan : String)