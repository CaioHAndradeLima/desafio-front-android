package com.test.core.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.test.core.extensiono.getRexexToGetFragmentInFragmentManager

fun FragmentManager.getFragment(viewPager: ViewPager, position: Int = viewPager.currentItem): Fragment? {
    return findFragmentByTag(viewPager.getRexexToGetFragmentInFragmentManager(position))
}
