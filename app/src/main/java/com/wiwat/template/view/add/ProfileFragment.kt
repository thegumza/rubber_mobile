package com.wiwat.template.view.add

import android.os.Bundle
import android.view.View
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentProfileBinding
import com.wiwat.template.view.base.BindingFragment


class ProfileFragment : BindingFragment<FragmentProfileBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_profile
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
