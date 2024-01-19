package com.appx.financex.ui.master_bank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.appx.financex.databinding.FragmentMasterBankBinding;

public class MasterBankFragment extends Fragment {
    private FragmentMasterBankBinding binding;
    private final Context context = requireContext();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMasterBankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}