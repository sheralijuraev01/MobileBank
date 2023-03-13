package uz.sher.bank.ui.main.transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentReceiverTransferBinding

class ReceiverTransferFragment : Fragment() {

    private var _binding:FragmentReceiverTransferBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentReceiverTransferBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.receiverTransferNextBtn.setOnClickListener{
            findNavController().navigate(R.id.action_receiverTransferFragment_to_moneyTransferFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}