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
import androidx.lifecycle.ViewModelProviders
import com.google.samples.apps.sunflower.databinding.FragmentRiskQuestion1Binding
import com.google.samples.apps.sunflower.risk.viewmodel.RiskQuestionViewModel

/**
 * Created by panqiang at 2019-11-14
 */
class RiskQuestionFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProviders.of(parentFragment!!).get(RiskQuestionViewModel::class.java)
        val binding = FragmentRiskQuestion1Binding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }
}