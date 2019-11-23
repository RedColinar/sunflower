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

package com.google.samples.apps.sunflower.risk.viewmodel

import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.risk.data.Answer
import com.google.samples.apps.sunflower.risk.data.AnswerSelect

class RiskQuestionViewModel : ViewModel() {

    /** 1 男 2 女 */
    val sex = ObservableInt(0)
    /** 单身 1 已婚无孩 2 已婚有孩 3 单亲妈妈/爸爸 4 */
    val family = ObservableInt(0)

    val parentBirthYear = ObservableField<String>("1986")
    val parentBirthMonth = ObservableField<String>("1")
    val parentBirthDay = ObservableField<String>("1")

    val singleAvatar = ObservableField<String>("https://web.insnail.com/images/demandEvaluate/DEV4Question28.png")
    val oneParentAvatar = ObservableField<String>("https://web.insnail.com/images/demandEvaluate/DEV4Question9.png")

    private val a = AnswerSelect("", "")
    private val answer = Answer(a, 1, "12", "男女有别，保障不同")

    val scrollFragmentEvent = MutableLiveData(0)

    init {
        sex.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                sender as ObservableInt
                if (sender.get() == 1) {
                    singleAvatar.set("https://web.insnail.com/images/demandEvaluate/DEV4Question28.png")
                    oneParentAvatar.set("https://web.insnail.com/images/demandEvaluate/DEV4Question9.png")
                } else if (sender.get() == 2) {
                    singleAvatar.set("https://web.insnail.com/images/demandEvaluate/DEV4Question29.png")
                    oneParentAvatar.set("https://web.insnail.com/images/demandEvaluate/DEV4Question10.png")
                }
            }
        })
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.iv_sex_male -> {
                sex.set(1)
                scrollToFragment(1)
            }
            R.id.iv_sex_female -> {
                sex.set(2)
                scrollToFragment(1)
            }
            R.id.iv_family_1 -> {
                family.set(1)
                scrollToFragment(2)
            }
            R.id.iv_family_2 -> {
                family.set(2)
                scrollToFragment(2)
            }
            R.id.iv_family_3 -> {
                family.set(4)
                scrollToFragment(2)
            }
            R.id.iv_family_4 -> {
                family.set(3)
                scrollToFragment(2)
            }
            R.id.tv_birthday_confirm -> {
                scrollToFragment(3)
            }
            R.id.tv_income_confirm -> {
                // no-op
            }
        }
    }

    private fun scrollToFragment(index: Int) {
        scrollFragmentEvent.postValue(index)
    }
}