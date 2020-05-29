package com.wiwat.template.view.add

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentAddPriceBinding
import com.wiwat.template.databinding.FragmentRegisterBinding
import com.wiwat.template.view.base.BindingFragment


class AddPriceFragment : BindingFragment<FragmentAddPriceBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_add_price
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardBottom.setOnClickListener {
            findNavController().navigate(R.id.action_addPriceFragment_to_homeFragment)
        }
        binding.editText.requestFocus()
        val imm =
            (context as Activity).getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.showSoftInput(binding.editText, InputMethodManager.SHOW_IMPLICIT)
    }


}
