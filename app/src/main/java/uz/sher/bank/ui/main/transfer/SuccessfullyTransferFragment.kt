package uz.sher.bank.ui.main.transfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentSuccessfullyTransferBinding


class SuccessfullyTransferFragment : Fragment() {
    private var _binding: FragmentSuccessfullyTransferBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSuccessfullyTransferBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chequeContainer.setOnClickListener {
            findNavController().navigate(R.id.action_successfullyTransferFragment_to_chequeFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}