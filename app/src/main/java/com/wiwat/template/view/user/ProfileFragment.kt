package com.wiwat.template.view.user

import android.os.Bundle
import android.view.View
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentProfileBinding
import com.wiwat.template.transactionItem
import com.wiwat.template.view.base.BindingFragment


class ProfileFragment : BindingFragment<FragmentProfileBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_profile
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.withModels {
            transactionItem { id(0).date("2/4/2563").weight("26.8").percent("25.0").price("33").dryCut("6.6").total("218") }
            transactionItem { id(1).date("2/4/2563").weight("26.8").percent("25.0").price("33").dryCut("6.6").total("218") }
            transactionItem { id(2).date("2/4/2563").weight("26.8").percent("25.0").price("33").dryCut("6.6").total("218") }
        }
    }


}
