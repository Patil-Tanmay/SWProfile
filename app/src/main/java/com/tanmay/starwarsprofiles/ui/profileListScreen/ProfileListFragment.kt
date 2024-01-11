package com.tanmay.starwarsprofiles.ui.profileListScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tanmay.starwarsprofiles.R
import com.tanmay.starwarsprofiles.databinding.FragmentProfileListBinding
import com.tanmay.starwarsprofiles.utils.ValueFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileListFragment : ValueFragment<FragmentProfileListBinding>(R.layout.fragment_profile_list) {

    override fun attachBinding(view: View): FragmentProfileListBinding {
        return FragmentProfileListBinding.bind(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

    }
}