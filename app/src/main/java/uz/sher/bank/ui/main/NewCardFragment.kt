package uz.sher.bank.ui.main

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import uz.sher.bank.R
import uz.sher.bank.adapters.CardBackgroundAdapter
import uz.sher.bank.databinding.FragmentNewCardBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.CardBackground


class NewCardFragment : Fragment() {
    private var _binding: FragmentNewCardBinding? = null
    private val binding get() = _binding!!
    private var demoData: MutableList<CardBackground> = ArrayList()
    private lateinit var cardBackAdapter: CardBackgroundAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewCardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newCardViewpager()
        val bankTypeAdapter = ArrayAdapter(
            binding.root.context, R.layout.spinner_list_item,
            resources.getStringArray(R.array.bankType)
        )
        binding.bankTypeSpinner.setPopupBackgroundResource(R.drawable.spinner_list_background);
        binding.bankTypeSpinner.adapter = bankTypeAdapter


        val cardTypeAdapter = ArrayAdapter(
            binding.root.context, R.layout.spinner_list_item,
            resources.getStringArray(R.array.cardType)
        )
        binding.cardTypeSpinner.setPopupBackgroundResource(R.drawable.spinner_list_background);
        binding.cardTypeSpinner.adapter = cardTypeAdapter

    }

    private fun newCardViewpager() {
        binding.cardBackgroundCarousel.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((15 * Resources.getSystem().displayMetrics.density).toInt()))

        binding.cardBackgroundCarousel.setPageTransformer(compositePageTransformer)
        demoData.clear()
        cardBackAdapter = CardBackgroundAdapter(Data.getCardBackground())
        binding.cardBackgroundCarousel.adapter = cardBackAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}