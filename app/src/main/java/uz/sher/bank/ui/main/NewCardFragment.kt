package uz.sher.bank.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}