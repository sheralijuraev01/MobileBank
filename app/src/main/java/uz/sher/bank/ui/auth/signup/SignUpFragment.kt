package uz.sher.bank.ui.auth.signup

import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import android.widget.Toast
import androidx.core.text.backgroundColor
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    private var _binding:FragmentSignUpBinding?=null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSignUpBinding.inflate(inflater,container,false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text="By signing up you accept the Term of service and Privacy Policy"
        val spanableString=SpannableStringBuilder(text)
        val clickableSpan1:ClickableSpan=object :ClickableSpan(){
            override fun onClick(widget: View) {
               Toast.makeText(binding.root.context,"Term of servive click",Toast.LENGTH_LONG).show()
            }

        }
        val clickableSpan2:ClickableSpan=object :ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(binding.root.context,"Term of servive click",Toast.LENGTH_LONG).show()
            }

        }

        spanableString.setSpan(clickableSpan1,28,45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanableString.setSpan(clickableSpan2,49,63, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.termstextSignUp.setText(spanableString, TextView.BufferType.SPANNABLE)
        binding.termstextSignUp.movementMethod = LinkMovementMethod.getInstance()

    }

}