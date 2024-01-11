package com.tanmay.starwarsprofiles.ui.profileDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tanmay.starwarsprofiles.R
import com.tanmay.starwarsprofiles.databinding.FragmentProfileDetailsBinding
import com.tanmay.starwarsprofiles.databinding.FragmentProfileListBinding
import com.tanmay.starwarsprofiles.utils.ValueFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileDetailsFragment : ValueFragment<FragmentProfileDetailsBinding>(R.layout.fragment_profile_details) {

    override fun attachBinding(view: View): FragmentProfileDetailsBinding {
        return FragmentProfileDetailsBinding.bind(view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

    }
}