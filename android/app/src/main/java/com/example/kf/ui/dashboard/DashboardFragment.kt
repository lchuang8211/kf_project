package com.example.kf.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kf.databinding.FragmentDashboardBinding
import com.example.kf.ui.activitys.NativeActivity
import io.flutter.embedding.android.FlutterActivity

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.btnGotoNativeActivity.setOnClickListener {
            Intent(requireContext(), NativeActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnGotoFlutterActivity.setOnClickListener {
            startActivity(FlutterActivity.createDefaultIntent(requireContext()))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
