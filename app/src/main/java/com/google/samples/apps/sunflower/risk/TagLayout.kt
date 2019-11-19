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

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.samples.apps.sunflower.R
import kotlin.math.max

class TagLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private val tagRect: MutableList<Rect> = ArrayList()
    private val inflater = LayoutInflater.from(context)
    val tags: MutableList<Item> = ArrayList()

    fun addTags(t: List<Item>) {
        removeAllViews()
        tags.clear()
        tagRect.clear()
        tags.addAll(t)
        for (tag in tags) {
            addView(getTextView(tag.content, tag.value))
            tagRect.add(Rect())
        }
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val measureMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        var widthUsed = 0
        var heightUsed = 0
        var lineMaxHeight = 0

        for (index in 0 until childCount) {
            val child = getChildAt(index)
            measureChildWithMargins(
                child,
                widthMeasureSpec,
                0,
                heightMeasureSpec,
                0
            )

            if (measureMode != MeasureSpec.UNSPECIFIED && (widthUsed + child.measuredWidth) > measureWidth) {
                widthUsed = 0
                heightUsed += lineMaxHeight
                lineMaxHeight = 0

                measureChildWithMargins(
                    child,
                    widthMeasureSpec,
                    widthUsed,
                    heightMeasureSpec,
                    heightUsed
                )
            }

            val mw = child.measuredWidth
            val mh = child.measuredHeight
            val lp = child.layoutParams as MarginLayoutParams

            tagRect[index].set(
                widthUsed + lp.marginStart,
                heightUsed + lp.topMargin,
                widthUsed + lp.marginStart + mw,
                heightUsed + lp.topMargin + mh
            )

            widthUsed += mw + lp.marginStart + lp.marginEnd
            lineMaxHeight = max(lineMaxHeight, mh + lp.topMargin + lp.bottomMargin)
        }

        setMeasuredDimension(measureWidth, heightUsed + lineMaxHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (index in 0 until childCount) {
            val child = getChildAt(index)
            val rect = tagRect[index]
            child.layout(rect.left, rect.top, rect.right, rect.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    private fun getTextView(content: String, value: String): TextView {
        val t = inflater.inflate(R.layout.layout_risk_tag_layout, this, false) as TextView
        t.text = content
        t.tag = value
        return t
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        for (rect in tagRect) {
            if (rect.contains(event.x.toInt(), event.y.toInt())) {

            }
        }
        return super.onTouchEvent(event)
    }

    data class Item(val content: String, val value: String)
}

fun dp2px(dp: Int): Float {
    return 0.5f + dp * Resources.getSystem().displayMetrics.density
}