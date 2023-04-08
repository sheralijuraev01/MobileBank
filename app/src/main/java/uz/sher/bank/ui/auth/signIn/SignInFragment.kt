package uz.sher.bank.ui.auth.signIn

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

  private var _binding:FragmentSignInBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding=FragmentSignInBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInCreateAccount.setOnClickListener{
        findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}