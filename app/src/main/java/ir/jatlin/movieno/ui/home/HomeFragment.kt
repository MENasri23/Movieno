package ir.jatlin.movieno.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ir.jatlin.core.shared.result.isSuccess
import ir.jatlin.movieno.R
import ir.jatlin.movieno.databinding.FragmentHomeBinding
import ir.jatlin.movieno.ui.util.launchAndRepeatWithViewLifecycle
import ir.jatlin.movieno.ui.util.viewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel by viewModels<HomeViewModel>()
    private val binding by viewBinding(FragmentHomeBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root

        launchAndRepeatWithViewLifecycle {
            collectPopulars()
        }
    }

    private fun CoroutineScope.collectPopulars() = launch {
        viewModel.popularMovies.collect {

        }
    }
}