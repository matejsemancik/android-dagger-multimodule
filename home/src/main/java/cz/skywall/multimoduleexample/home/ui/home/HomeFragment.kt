package cz.skywall.multimoduleexample.home.ui.home

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.skywal.mutimoduleexmaple.dummy_service.DummyService
import cz.skywall.multimoduleexample.home.base.BaseFragment
import cz.skywall.multimoduleexample.home.data.repository.DummyRepository
import cz.skywall.multimoduleexample.home.data.repository.DummyRepository2
import cz.skywall.multimoduleexample.network.ApiService
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var dummyRepository: DummyRepository

    @Inject
    lateinit var dummyRepository2: DummyRepository2


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TextView(requireActivity()).apply { text = "Home Fragment" }
    }

    override fun inject() {
        homeComponent.plus(HomeFragmentModule()).inject(this)

        requireActivity().startService(Intent(requireActivity(), DummyService::class.java))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedPreferences.all
        dummyRepository.toString()
        dummyRepository2.toString()
    }
}
