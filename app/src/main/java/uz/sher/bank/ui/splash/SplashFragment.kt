package uz.sher.bank.ui.splash

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        object : CountDownTimer(500, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                        findNavController().navigate(R.id.action_splashFragment_to_signInFragment)

            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}