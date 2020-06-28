package com.wiwat.template.view.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentLoginBinding
import com.wiwat.template.view.base.BindingFragment
import com.wiwat.template.view.base.DataLoaded
import com.wiwat.template.view.base.Failed
import com.wiwat.template.view.base.Loading
import org.koin.androidx.viewmodel.ext.android.getViewModel


class LoginFragment : BindingFragment<FragmentLoginBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_login
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.model = getViewModel()
        binding.lifecycleOwner = this
        binding.model!!.states.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is Loading -> showLoading()
                is DataLoaded -> showData(state.list)
                is Failed -> showError(state.error)
            }
        })
        binding.cardLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    private fun showLoading() {

    }

    private fun showData(list: Any) {

    }

    private fun showError(error: Throwable) {

    }


}
