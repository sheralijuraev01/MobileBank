package uz.sher.bank.ui.main.transfer


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import uz.sher.bank.adapters.AllRecipientsAdapter

import uz.sher.bank.databinding.FragmentRecipientsAllBinding
import uz.sher.bank.model.Recipient


class AllRecipientsFragment : Fragment() {
    private var _binding: FragmentRecipientsAllBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<Recipient> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipientsAllBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewStyle()

        initList()
        binding.recyclerViewAllRecipients.adapter = AllRecipientsAdapter(list)

    }

    private fun searchViewStyle() {
        val textSearch: EditText =
            binding.searchRecipient.findViewById<androidx.appcompat.widget.SearchView>(androidx.appcompat.R.id.search_src_text) as EditText
        textSearch.setTextColor(Color.WHITE)
        textSearch.setHintTextColor(Color.WHITE)
    }

    private fun initList() {
        list.add(Recipient("Sherali Jo'rayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Akmal Qo'ziyev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Shaxzod Murtazaqulov", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Feruz Jo'rayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Javohir Pardayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Sarvar Sanayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Habibullo Hikmatov", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Usmon Boltayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Sherali Jo'rayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Akmal Qo'ziyev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Shaxzod Murtazaqulov", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Feruz Jo'rayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Javohir Pardayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Sarvar Sanayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Habibullo Hikmatov", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Usmon Boltayev", "sher.jorayev01@gmail.com", "123456"))
        list.add(Recipient("Add Recipient", "sher.jorayev01@gmail.com", "123456"))
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}