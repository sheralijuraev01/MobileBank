package uz.sher.bank.ui.main.transfer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.sher.bank.R
import uz.sher.bank.adapters.RecipientAdapter
import uz.sher.bank.databinding.FragmentMainTransferBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.Recipient
import uz.sher.bank.ui.main.MainFragment


class TransferMainFragment : Fragment() {
    private var _binding: FragmentMainTransferBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<Recipient> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainTransferBinding.inflate(inflater, container, false)
        return _binding?.root
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        val layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.recipientRecyclerView.layoutManager = layoutManager
        binding.recipientRecyclerView.adapter = RecipientAdapter(list)


        binding.mainAllRecipients.setOnClickListener {
            findNavController().navigate(R.id.action_transferFragment_to_allRecipientsFragment)

        }

        binding.cardNumberBtn.setOnClickListener{
            findNavController().navigate(R.id.action_transferFragment_to_introTransferFragment)
        }







    }

    private fun initList() {
        list.clear()
        list = Data.getCardRecipientList()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpFragment(){
        findNavController().navigate(R.id.action_transferFragment_to_introTransferFragment)

    }


}

