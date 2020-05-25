package com.wiwat.template.view.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.zxing.integration.android.IntentIntegrator
import com.wiwat.template.R
import com.wiwat.template.databinding.FragmentHomeBinding
import com.wiwat.template.menuItem
import com.wiwat.template.view.base.BindingFragment


class HomeFragment : BindingFragment<FragmentHomeBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textUsername.text = "สวัสดี ทดสอบ"
        binding.recyclerView.withModels {
            menuItem {
                id(0).icon(
                    ContextCompat.getDrawable(
                        context as Activity,
                        R.drawable.ic_search
                    )
                ).name("ค้นหาสินค้า")
            }
            menuItem {
                id(1).icon(ContextCompat.getDrawable(context as Activity, R.drawable.ic_add))
                    .name("เพิ่มสินค้า").onClick { _ -> findNavController().navigate(R.id.action_homeFragment_to_registerFragment)}
            }
        }
        binding.cardBottom.setOnClickListener {
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
                Toast.makeText(
                    context as Activity,
                    "Scanned: " + result.contents,
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }


}
