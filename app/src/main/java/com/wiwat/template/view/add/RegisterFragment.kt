package com.wiwat.template.view.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.zxing.integration.android.IntentIntegrator
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentHomeBinding
import com.wiwat.template.databinding.FragmentRegisterBinding
import com.wiwat.template.menuItem
import com.wiwat.template.view.base.BindingFragment


class RegisterFragment : BindingFragment<FragmentRegisterBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_register
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.animationView.setOnClickListener {
            val integrator = IntentIntegrator.forSupportFragment(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES)
            integrator.setPrompt("Scan a barcode")
            integrator.setCameraId(0) // Use a specific camera of the device
            integrator.setBeepEnabled(false)
            integrator.setBarcodeImageEnabled(true)
            integrator.initiateScan()
        }
    }

    // Get the results:
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(context as Activity, "ยกเลิกสแกน", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context as Activity, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


}
