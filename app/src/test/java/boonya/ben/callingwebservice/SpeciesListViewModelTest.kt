package boonya.ben.callingwebservice

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import boonya.ben.callingwebservice.species.SpeciesListViewModel
import boonya.ben.callingwebservice.species.SpeciesRepositoryImpl
import boonya.ben.callingwebservice.model.Species
import boonya.ben.callingwebservice.model.SpeciesList
import boonya.ben.callingwebservice.species.SpeciesRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by oozou on 7/19/2017 AD.
 */
class SpeciesListViewModelTest {

    @Rule @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock lateinit var speciesRepo: SpeciesRepository

    lateinit var speciesListViewModel: SpeciesListViewModel

    val mockedSpecies = listOf(
            Species("Name1", "Classification1", "Lang1", "LifeSpan1"),
            Species("Name2", "Classification2", "Lang2", "LifeSpan2"),
            Species("Name3", "Classification3", "Lang3", "LifeSpan3"))

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        speciesListViewModel = SpeciesListViewModel().apply {
            repository = this@SpeciesListViewModelTest.speciesRepo
        }
    }

    fun mockSuccessHandler(speciesList: SpeciesList?) {}

    fun mockFailureHandler(throwable: Throwable?) {}

    @Test
    fun getSpecies() {
        val speciesResponse = MutableLiveData<List<Species>>()
        `when`(speciesRepo.getSpecies(this::mockSuccessHandler, this::mockFailureHandler)).then({
            speciesResponse.apply {
                value = mockedSpecies
            }
        })
        val observer = mock(Observer::class.java)

        speciesResponse.observeForever(observer as Observer<List<Species>>)

        speciesListViewModel.getSpecies()

        verify(speciesRepo).getSpecies(this::mockSuccessHandler, this::mockFailureHandler)
        verifyNoMoreInteractions(speciesRepo)
        verify(observer).onChanged(mockedSpecies)
        verifyNoMoreInteractions(observer)
    }


}