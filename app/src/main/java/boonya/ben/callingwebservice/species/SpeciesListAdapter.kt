package boonya.ben.callingwebservice.species

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import boonya.ben.callingwebservice.R

/**
 * Created by oozou on 7/12/2017 AD.
 */
class SpeciesListAdapter(var speciesListViewModel: SpeciesListViewModel) : RecyclerView.Adapter<SpeciesViewHolder>() {

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        speciesListViewModel.getSpeciesAt(position)?.let {
            holder.apply {
                name.text = it.name
                classification.text = it.classification
                language.text = it.language
                lifeSpan.text = it.lifeSpan
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        return SpeciesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.species_item, parent, false))
    }

    override fun getItemCount(): Int {
        return speciesListViewModel.getSpeciesSize()
    }

}