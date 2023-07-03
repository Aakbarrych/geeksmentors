package kg.geeks.geeksmentor.presentation.presentation.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import kg.geeks.geeksmentor.R
import kg.geeks.geeksmentor.databinding.FragmentOnBoardBinding
import kg.geeks.geeksmentor.presentation.presentation.onboard.adapter.OnBoardAdapter

class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        viewPager = binding.viewpager
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = OnBoardAdapter(viewPager,
            onClick = { navigateToHomeFragment() },
            onLoginClickListener = { navigateToLoginFragment() },
            onRegisterClickListener = { navigateToRegisterFragment() })
        binding.viewpager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewpager)
    }

    private fun navigateToHomeFragment() {
        findNavController().navigateUp()
    }

    private fun navigateToLoginFragment() {
        findNavController().navigate(R.id.signInFragment)
    }

    private fun navigateToRegisterFragment() {
        findNavController().navigate(R.id.logInFragment)
    }
}