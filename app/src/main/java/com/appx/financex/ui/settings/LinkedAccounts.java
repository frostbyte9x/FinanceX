package com.appx.financex.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.appx.financex.databinding.FragmentLinkedAccountsBinding;

public class LinkedAccounts extends SettingsFragment
{
    private FragmentLinkedAccountsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {;
        binding = FragmentLinkedAccountsBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
