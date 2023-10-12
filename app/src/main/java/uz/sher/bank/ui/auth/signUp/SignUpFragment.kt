package uz.sher.bank.ui.auth.signUp

import android.app.AlertDialog
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.sher.bank.R
import uz.sher.bank.data.network.model.SignUpPost
import uz.sher.bank.databinding.FragmentSignUpBinding
import uz.sher.bank.utils.constant.MainConstants.EMAIL
import uz.sher.bank.utils.constant.MainConstants.TOKEN
import uz.sher.bank.utils.network.NetworkStatus


@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private var validateState: String = ""
    private val registerViewModel: RegisterViewModel by viewModels()
    private var email: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSpannableText()


        binding.signUpBtn.setOnClickListener {

            val name = binding.nameSignUp.text.toString().trim()
            val surname = binding.surnameSignUp.text.toString().trim()
            email = binding.emailSignUp.text.toString().trim()
            val password = binding.passwordSignUp.text.toString().trim()
            val confirmPassword = binding.confPasswordSignUp.text.toString().trim()

            val stateItems =
                validateSignUpItems(name, surname, email, password, confirmPassword)

            if (stateItems) {
                val createObj = SignUpPost(name, surname, email, password)
                registerViewModel.createUser(signUpPost = createObj)
                createObserve()
            } else showDialog(validateState)


        }


    }


    private fun initSpannableText() {
        val text =
            "Roʻyxatdan oʻtish orqali siz Xizmat koʻrsatish shartlari va Maxfiylik siyosatini qabul qilasiz"
        val spanableString = SpannableStringBuilder(text)
        val clickableSpan1: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(
                    binding.root.context,
                    "Xizmat koʻrsatish shartlari",
                    Toast.LENGTH_LONG
                )
                    .show()
            }

        }
        val clickableSpan2: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                Toast.makeText(binding.root.context, "Maxfiylik siyosatini", Toast.LENGTH_LONG)
                    .show()
            }

        }

        spanableString.setSpan(clickableSpan1, 28, 56, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanableString.setSpan(clickableSpan2, 60, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.termstextSignUp.setText(spanableString, TextView.BufferType.SPANNABLE)
        binding.termstextSignUp.movementMethod = LinkMovementMethod.getInstance()
    }


    private fun createObserve() {
        registerViewModel.createResource.observe(requireActivity()) { response ->
            when (response.status) {
                NetworkStatus.LOADING -> {
                    createProgressBar()
                }
                NetworkStatus.SUCCESS -> {
                    createUnProgressBar()
                    Toast.makeText(
                        binding.root.context,
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    val bundle = Bundle()
                    bundle.putString(TOKEN, response.data?.objectX.toString())
                    bundle.putString(EMAIL, email)
                    findNavController().navigate(R.id.action_signUpFragment_to_verifyCodeFragment)
                }
                NetworkStatus.ERROR -> {
                    responseError(response.message.toString())

                }
            }

        }
    }

    private fun createProgressBar() {
        binding.signUpProgress.visibility = View.VISIBLE
    }

    private fun createUnProgressBar() {
        binding.signUpProgress.visibility = View.INVISIBLE
    }


    private fun responseError(message: String) {
        createUnProgressBar()
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


    private fun validateSignUpItems(
        name: String,
        surname: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        var result = true

        if (name.isNotEmpty() && surname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            if (name.length < 2) {
                validateState = "Ism juda qisqa"
                return false
            } else if (surname.length < 2) {
                validateState = "Familiya juda qisqa"
                return false
            } else if (!(email.contains("@gmail.com") || email.contains("@mail.ru"))) {
                validateState = "Email formati no'tog'ri"
                return false
            } else if (password.length < 5) {
                validateState = "Parol kamida 6 ta belgidan iborat bo'lishi kerak"
                return false
            } else if (password != confirmPassword) {
                validateState = "Parollar mos kelmadi"
                return false
            } else if (!binding.checkboxSignUp.isChecked) {
                validateState = "Shartlarga rozilik bildiring!"
                return false
            }

        } else {
            result = false
            validateState = "Maydonlarni to'liq to'ldiring!"

        }

        return result

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}