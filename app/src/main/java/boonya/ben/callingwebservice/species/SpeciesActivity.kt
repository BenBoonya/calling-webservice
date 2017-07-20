package boonya.ben.callingwebservice.species

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import boonya.ben.callingwebservice.R
import boonya.ben.callingwebservice.di.ComponentInjector
import boonya.ben.callingwebservice.model.Species
import kotlinx.android.synthetic.main.activity_species.*

class SpeciesActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val registry = LifecycleRegistry(this)
    private lateinit var viewModel: SpeciesListViewModel
    private lateinit var adapter: SpeciesListAdapter

    override fun getLifecycle(): LifecycleRegistry = registry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_species)
        setSupportActionBar(toolbar)
        title = "STARWAR SPECIES"
        viewModel = createViewModel()
        adapter = SpeciesListAdapter(viewModel)
        rvSpecies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@SpeciesActivity)
            adapter = this@SpeciesActivity.adapter
        }
        attachObserver()
        viewModel.getSpecies()
    }

    private fun attachObserver() {
        viewModel.isLoading.observe(this, Observer<Boolean> {
            it?.let { showLoadingDialog(it) }
        })
        viewModel.apiError.observe(this, Observer<Throwable> {
            it?.let { Snackbar.make(rvSpecies, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
        })
        viewModel.speciesResponse.observe(this, Observer<List<Species>> {
            it?.let { adapter.notifyDataSetChanged() }
        })

    }

    private fun createViewModel(): SpeciesListViewModel =
            ViewModelProviders.of(this).get(SpeciesListViewModel::class.java).also {
                ComponentInjector.component.inject(it)
            }

    private fun showLoadingDialog(show: Boolean) {
        if (show) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
    }
}
