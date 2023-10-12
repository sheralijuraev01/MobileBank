package uz.sher.bank.ui.auth.signIn

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.sher.bank.R
import uz.sher.bank.data.network.model.SignInPost
import uz.sher.bank.databinding.FragmentSignInBinding
import uz.sher.bank.utils.network.NetworkStatus



@AndroidEntryPoint
class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.signInBtn.setOnClickListener {
            val email = binding.emailSignIn.text.toString().trim()
            val password = binding.passwordSignIn.text.toString().trim()

            if (validateItem(email, password)) {
                val loginUser = SignInPost(email, password)
                loginViewModel.loginUser(loginUser)
                loginObserve()
            } else {
                showDialog("Email yoki parol bo'sh bo'lmasligi kerak")
            }

        }

        binding.signInCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.forgotPasswordSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
        }
    }


    private fun loginObserve() {
        loginViewModel.loginResource.observe(requireActivity()) { response ->
            when (response.status) {
                NetworkStatus.LOADING -> {
                    loginProgressBar()
                }
                NetworkStatus.SUCCESS -> {
                    loginUnProgressBar()
                    Toast.makeText(
                        binding.root.context,
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
                }
                NetworkStatus.ERROR -> {
                    responseError(response.message.toString())

                }
            }

        }
    }

    private fun loginProgressBar() {
        binding.signInProgress.visibility = View.VISIBLE
    }

    private fun loginUnProgressBar() {
        binding.signInProgress.visibility = View.INVISIBLE
    }


    private fun responseError(message: String) {
        loginUnProgressBar()
        showDialog(message)
    }

    private fun showDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(context)

        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ ->

            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }


    private fun validateItem(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}