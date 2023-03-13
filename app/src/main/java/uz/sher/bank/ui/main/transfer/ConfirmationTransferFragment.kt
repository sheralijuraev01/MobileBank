package uz.sher.bank.ui.main.transfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentConfirmationTransferBinding


class ConfirmationTransferFragment : Fragment() {
    private var _binding:FragmentConfirmationTransferBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentConfirmationTransferBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmButton.setOnClickListener{
           findNavController().navigate(R.id.action_confirmationTransferFragment_to_successfullyTransferFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}