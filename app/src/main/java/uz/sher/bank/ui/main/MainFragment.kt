package uz.sher.bank.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import uz.sher.bank.R
import uz.sher.bank.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.bottom_nav_host)
        val navController = navHostFragment?.findNavController()
        binding.bottomNavigation.setupWithNavController(navController!!)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.transferFragment -> showBottomNav()
                R.id.paymeFragment -> showBottomNav()
                R.id.historyFragment -> showBottomNav()
                else -> hideBottomNav()
            }

        }


    }


     private fun hideBottomNav() {
        binding.bottomNavigation.visibility=View.GONE
        binding.viewMainBackground.visibility=View.GONE
    }

    private fun showBottomNav() {
        binding.bottomNavigation.visibility=View.VISIBLE
        binding.viewMainBackground.visibility=View.VISIBLE


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}