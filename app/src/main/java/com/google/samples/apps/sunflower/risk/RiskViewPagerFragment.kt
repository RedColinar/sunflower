/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.risk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.samples.apps.sunflower.databinding.FragmentRiskViewPagerBinding
import com.google.samples.apps.sunflower.risk.viewmodel.RiskQuestionViewModel

/**
 * Created by panqiang at 2019-11-14
 */
class RiskViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRiskViewPagerBinding =
            FragmentRiskViewPagerBinding.inflate(inflater, container, false)
        val viewPager: ViewPager2 = binding.riskViewPager
        viewPager.adapter = RiskViewPagerAdapter(this)
        val viewModel = ViewModelProviders.of(this).get(RiskQuestionViewModel::class.java)
        viewModel.scrollFragmentEvent.observe(this, Observer {
            viewPager.setCurrentItem(it, true)
        })
        binding.lifecycleOwner = this
        return binding.root
    }

    class RiskViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> RiskQuestionFragment1()
                1 -> RiskQuestionFragment2()
                2 -> RiskQuestionFragment3()
                else -> RiskQuestionFragment1()
            }
        }
    }
}