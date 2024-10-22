package com.depi.myapplication.ui.fragments.shopping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
<<<<<<< HEAD:app/src/main/java/com/depi/myapplication/ui/fragments/shopping/HomeFragment.kt
import com.depi.myapplication.R
import com.depi.myapplication.adapters.HomeViewpagerAdapter
import com.depi.myapplication.databinding.FragmentHomeBinding
import com.depi.myapplication.ui.fragments.categories.AccessoryFragment
import com.depi.myapplication.ui.fragments.categories.ChairFragment
import com.depi.myapplication.ui.fragments.categories.CupboardFragment
import com.depi.myapplication.ui.fragments.categories.FurnitureFragment
import com.depi.myapplication.ui.fragments.categories.MainCategoryFragment
import com.depi.myapplication.ui.fragments.categories.TableFragment

import com.google.android.material.snackbar.Snackbar
=======
import com.depi.myapplicatio.R
import com.depi.myapplicatio.adapters.HomeViewpagerAdapter
import com.depi.myapplicatio.databinding.FragmentHomeBinding
import com.depi.myapplicatio.fragments.categories.AccessoryFragment
import com.depi.myapplicatio.fragments.categories.ChairFragment
import com.depi.myapplicatio.fragments.categories.CupboardFragment
import com.depi.myapplicatio.fragments.categories.FurnitureFragment
import com.depi.myapplicatio.fragments.categories.MainCategoryFragment
import com.depi.myapplicatio.fragments.categories.TableFragment
>>>>>>> 5360dc4d80e6b5d2bd1132ff4fe6d8d36520168f:app/src/main/java/com/depi/myapplicatio/fragments/shopping/HomeFragment.kt
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoriesFragments = arrayListOf<Fragment>(
            MainCategoryFragment(),
            ChairFragment(),
            CupboardFragment(),
            TableFragment(),
            AccessoryFragment(),
            FurnitureFragment(),
        )

        binding.searchBar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        binding.viewpagerHome.isUserInputEnabled = false

        val viewPager2Adapter =
            HomeViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.viewpagerHome.adapter = viewPager2Adapter
        TabLayoutMediator(binding.tabLayout, binding.viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Chair"
                2 -> tab.text = "Cupboard"
                3 -> tab.text = "Table"
                4 -> tab.text = "Accessory"
                5 -> tab.text = "Furniture"
                else -> tab.text = "tab $position"
            }
        }.attach()
    }
}