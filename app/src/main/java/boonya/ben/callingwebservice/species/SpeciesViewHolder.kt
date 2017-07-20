package boonya.ben.callingwebservice.species

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import boonya.ben.callingwebservice.R

/**
 * Created by oozou on 7/12/2017 AD.
 */
class SpeciesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name by lazy { view.findViewById(R.id.name) as TextView }
    val classification by lazy { view.findViewById(R.id.classification) as TextView }
    val language by lazy { view.findViewById(R.id.language) as TextView }
    val lifeSpan by lazy { view.findViewById(R.id.lifeSpan) as TextView }
}