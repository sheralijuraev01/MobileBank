package uz.sher.bank.ui.main

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import uz.sher.bank.R
import uz.sher.bank.adapters.CardCarouselAdapter
import uz.sher.bank.databinding.FragmentHomeBinding
import uz.sher.bank.fake_data.Data
import uz.sher.bank.model.Card


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var cardAdapter: CardCarouselAdapter? = null
    private var demoData: MutableList<Card> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()

        binding.homeAddCard.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_newCardFragment)
        }

        binding.cardViewPager.apply {
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
        binding.cardViewPager.setPageTransformer(compositePageTransformer)

        cardAdapter = CardCarouselAdapter(demoData)
        binding.cardViewPager.adapter = cardAdapter
        setUpIndicators()
        setActiviteIndicators(0)

        binding.cardViewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setActiviteIndicators(position)
            }

        })


    }

    private fun initList() {
        demoData.clear()
        demoData= Data.getCardList()
    }

    private fun setUpIndicators() {
        val indicators = arrayOfNulls<ImageView>(cardAdapter?.itemCount!!)

        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(30, 30)
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(requireContext())
            indicators[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    R.drawable.no_selected_banner
                )
            )
            indicators[i]?.layoutParams = layoutParams
            binding.viewPagerIndicators.addView(indicators[i])
        }
    }

    private fun setActiviteIndicators(position: Int) {
        val childCount = binding.viewPagerIndicators.childCount

        for (i in 0 until childCount) {
            val indicator = binding.viewPagerIndicators.getChildAt(i) as ImageView
            if (position == i) {
                indicator.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.selected_banner
                    )
                )
            } else {
                indicator.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        R.drawable.no_selected_banner
                    )
                )
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}