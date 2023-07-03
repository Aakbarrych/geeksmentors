package kg.geeks.geeksmentor.presentation.presentation.mentorprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kg.geeks.geeksmentor.R
import kg.geeks.geeksmentor.databinding.FragmentMentorProfileBinding
import kg.geeks.geeksmentor.presentation.data.repository.LoginRepositoryImpl
import kg.geeks.geeksmentor.presentation.data.viewmodel.LoginViewModel
import kg.geeks.geeksmentor.presentation.data.viewmodel.LoginViewModelFactory
import kg.geeks.geeksmentor.presentation.data.viewmodel.SharedViewModel

class MentorProfileFragment : Fragment() {

    private lateinit var binding: FragmentMentorProfileBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMentorProfileBinding.inflate(inflater, container, false)
        val repository = LoginRepositoryImpl()
        val loginViewModelFactory = LoginViewModelFactory(repository)
        viewModel = ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
                binding.mentorsProfileName.text = viewModel.firstName.value.toString()

                binding.mentorsProfileSecondName.text = viewModel.lastName.value.toString()*/

        sharedViewModel.firstName.observe(viewLifecycleOwner) { firstName ->
            binding.mentorsProfileName.text = firstName
        }

        sharedViewModel.lastName.observe(viewLifecycleOwner) { lastName ->
            binding.mentorsProfileSecondName.text = lastName
        }

        sharedViewModel.imageProfile.observe(viewLifecycleOwner) { imageProfile ->
            Glide.with(binding.mentorsProfilePhoto).load(imageProfile)
                .into(binding.mentorsProfilePhoto)
        }

        binding.btnBecomeMentor.setOnClickListener {
            findNavController().navigate(R.id.becomeMentorFragment)
        }

        binding.btnMyData.setOnClickListener {
            findNavController().navigate(R.id.dataFragment)
        }

        binding.btnLanguage.setOnClickListener {
            findNavController().navigate(R.id.languageFragment)
        }

        binding.btnExitMentorProfile.setOnClickListener {
            //показать кастомизированный алерт диалог с проверкой на желание выйти
            requireActivity().finish()
            kg.geeks.geeksmentor.presentation.SplashActivity().finish()
        }
    }
}