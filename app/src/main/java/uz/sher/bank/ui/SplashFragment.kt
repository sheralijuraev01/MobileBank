package uz.sher.bank.ui

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentSplashBinding
import uz.sher.bank.sharedpreference.UserLogin
import uz.sher.bank.viewModel.splash.SplashViewModel
import uz.sher.bank.viewModel.splash.SplashViewModelFactory


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var splashViewModel: SplashViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferencesUser =
            binding.root.context.getSharedPreferences("login_save", Context.MODE_PRIVATE)
        splashViewModel = ViewModelProvider(
            this,
            SplashViewModelFactory(UserLogin(sharedPreferencesUser))
        )[SplashViewModel::class.java]


        object : CountDownTimer(500, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                splashViewModel.isLoggedIn().observe(viewLifecycleOwner) {
                    if (it) findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                    else findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
                }
            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}