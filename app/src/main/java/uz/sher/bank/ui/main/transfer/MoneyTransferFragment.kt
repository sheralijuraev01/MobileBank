package uz.sher.bank.ui.main.transfer

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import uz.sher.bank.R
import uz.sher.bank.adapters.CardCarouselAdapter
import uz.sher.bank.adapters.TransferCardAdapter
import uz.sher.bank.databinding.FragmentMoneyTransferBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.Card


class MoneyTransferFragment : Fragment() {

    private var _binding: FragmentMoneyTransferBinding? = null
    private val binding get() = _binding!!
    private var transferCardAdapter: TransferCardAdapter? = null
    private var demoData: MutableList<Card> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoneyTransferBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        moneyCardViewpager()
        binding.moneyTransferButton.setOnClickListener {
            findNavController().navigate(R.id.action_moneyTransferFragment_to_confirmationTransferFragment)
        }

        binding.moneyCardViewPager.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        binding.moneyCardViewPager.setPageTransformer(compositePageTransformer)
        demoData.clear()
        transferCardAdapter = TransferCardAdapter(Data.getCardList())
        binding.moneyCardViewPager.adapter = transferCardAdapter

    }

    private fun moneyCardViewpager(){
        binding.moneyCardViewPager.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        binding.moneyCardViewPager.setPageTransformer(compositePageTransformer)
        demoData.clear()
        transferCardAdapter = TransferCardAdapter(Data.getCardList())
        binding.moneyCardViewPager.adapter = transferCardAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}