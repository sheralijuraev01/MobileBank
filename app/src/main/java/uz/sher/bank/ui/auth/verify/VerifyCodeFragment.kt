package uz.sher.bank.ui.auth.verify

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.sher.bank.databinding.FragmentVerifyCodeBinding
import uz.sher.bank.utils.constant.MainConstants.EMAIL
import uz.sher.bank.utils.constant.MainConstants.TOKEN


class VerifyCodeFragment : Fragment() {

    private var _binding: FragmentVerifyCodeBinding? = null
    private val binding get() = _binding!!


    private var token: String = ""
    private var email: String = ""
    private lateinit var countDownTimer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        token = arguments?.getString(TOKEN).toString()
        email = arguments?.getString(EMAIL).toString()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVerifyCodeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUIItems()
        countDownTimer.start()
        textWatcher()


        binding.verifyBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun initUIItems() {
        binding.verifyExtraTitle.text = "$email elektron pochtaga kelgan kodni kiriting"
        countDownTimer(60000)
    }


    private fun countDownTimer(startTime: Long) {
        binding.verifyResetSend.text = ""
        binding.verifyEnterCodeEdit.isEnabled = true
        binding.verifyBtn.isEnabled = false
        countDownTimer = object : CountDownTimer(startTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.verifyTime.text = "00:${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.verifyTime.text = "00:00"
                binding.verifyResetSend.text = "Qayta yuborish"
                binding.verifyEnterCodeEdit.isEnabled = false
            }
        }
    }

    private fun textWatcher() {
        binding.verifyEnterCodeEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length == 6) {
                    binding.verifyEnterCodeEdit.isEnabled = false
                    binding.verifyBtn.isEnabled = true
                }
            }

        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}