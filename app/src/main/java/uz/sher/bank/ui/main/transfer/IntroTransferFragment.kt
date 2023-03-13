package uz.sher.bank.ui.main.transfer

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.sher.bank.R
import uz.sher.bank.adapters.RecipientAdapter
import uz.sher.bank.databinding.FragmentIntroTransferBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.Recipient


class IntroTransferFragment : Fragment() {

    private var _binding: FragmentIntroTransferBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<Recipient> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIntroTransferBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showInputMethod()

        initList()

        binding.introTransferNextBtn.setOnClickListener{
            findNavController().navigate(R.id.action_introTransferFragment_to_receiverTransferFragment)
        }
        val layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.introRecipientRV.layoutManager = layoutManager
        binding.introRecipientRV.adapter = RecipientAdapter(list)
    }

    private fun showInputMethod() {
        binding.introCardNumber.requestFocus()
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.showSoftInput(binding.introCardNumber, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun initList() {
        list.clear()
        list = Data.getCardRecipientList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}