package com.wiwat.template.view.search

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentRegisterBinding
import com.wiwat.template.databinding.FragmentSearchBinding
import com.wiwat.template.searchItem
import com.wiwat.template.view.base.BindingFragment


class SearchFragment : BindingFragment<FragmentSearchBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_search
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.withModels {
            for (i in 0 until 10){
                searchItem { id(i).title("วิวัฒน์ ฟองการ").memberNo("12356789").onClick { _ -> findNavController().navigate(R.id.action_searchFragment_to_profileFragment) } }
            }
        }
    }


}
