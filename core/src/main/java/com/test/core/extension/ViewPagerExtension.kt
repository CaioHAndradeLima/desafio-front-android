package com.test.core.extensiono

import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

fun ViewPager.getRexexToGetFragmentInFragmentManager(position: Int = currentItem): String {
    return "android:switcher:$id:${(adapter as FragmentPagerAdapter).getItemId(position)}"
}
