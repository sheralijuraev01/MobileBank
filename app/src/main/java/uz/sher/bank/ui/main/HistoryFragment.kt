package uz.sher.bank.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.sher.bank.adapters.HistoryAdapter
import uz.sher.bank.databinding.FragmentHistoryBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.History


class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<History> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = Data.getHistoryData()

        binding.historyRV.adapter = HistoryAdapter(list)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}