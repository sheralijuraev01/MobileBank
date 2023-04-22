package uz.sher.bank.ui.auth.signIn

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.api.ApiClient
import uz.sher.bank.databinding.FragmentSignInBinding
import uz.sher.bank.datasource.RemoteDataSource
import uz.sher.bank.repository.SignInRepository
import uz.sher.bank.sharedpreference.UserLogin
import uz.sher.bank.utils.network.NetworkHelper
import uz.sher.bank.utils.network.NetworkStatus
import uz.sher.bank.viewModel.auth.signin.SignInViewModel
import uz.sher.bank.viewModel.auth.signin.SignInViewModelFactory


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SignInViewModel
    private lateinit var preferenceLogin: SharedPreferences
    private var isShown = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(
            this, SignInViewModelFactory(
                SignInRepository(
                    NetworkHelper(binding.root.context),
                    RemoteDataSource(ApiClient.apiService)
                )
            )
        )[SignInViewModel::class.java]

        binding.signInBtn.setOnClickListener {
            isShown = false
            viewModel.setEmail(binding.emailSignIn.text.toString())
            viewModel.setPassword(binding.passwordSignIn.text.toString())
            if (viewModel.areFieldsEmpty()) {
                viewModel.getAllPosts().observe(viewLifecycleOwner) {
                    when (it.status) {
                        NetworkStatus.LOADING -> {
                            binding.signInProgress.visibility = View.VISIBLE
                            binding.signInBtn.isEnabled = false
                            binding.errorTextSignIn.visibility = View.INVISIBLE
                        }
                        NetworkStatus.SUCCESS -> {
                            if (it.data?.success!!) {

                                if (findNavController().currentDestination?.id == R.id.signInFragment) {
                                    preferenceLogin = binding.root.context.getSharedPreferences(
                                        "login_save",
                                        Context.MODE_PRIVATE
                                    )

                                    UserLogin(preferenceLogin).saveAuthToken(it.data.objectX.toString())
                                    findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
                                }

                            } else {
                                if (!isShown) {
                                    showDialog(it.data.message.toString())
                                    isShown = true
                                }
                                binding.signInProgress.visibility = View.INVISIBLE
                                binding.signInBtn.isEnabled = true
                                binding.errorTextSignIn.visibility = View.VISIBLE

                            }
                        }
                        NetworkStatus.ERROR -> {
                            binding.signInProgress.visibility = View.INVISIBLE
                            binding.signInBtn.isEnabled = true
                            if (!isShown) {
                                showDialog(it.message.toString())
                                isShown = true
                            }
                        }
                    }
                }

            } else {
                if (!isShown) {
                    showDialog("Email or password cannot be empty")
                    isShown = true
                }
            }
        }

        binding.signInCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
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


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}