package uz.sher.bank.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentNewCardBinding


class NewCardFragment : Fragment() {
    private var _binding:FragmentNewCardBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentNewCardBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bankTypeAdapter=ArrayAdapter(binding.root.context, androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.bankType))
         binding.bankTypeSpinner.adapter=bankTypeAdapter
        val cardTypeAdapter=ArrayAdapter(binding.root.context, androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.cardType))
        binding.cardTypeSpinner.adapter=cardTypeAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}