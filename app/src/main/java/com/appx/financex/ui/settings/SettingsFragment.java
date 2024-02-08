package com.appx.financex.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.appx.financex.FlexAdapter;
import com.appx.financex.Schema;
import com.appx.financex.databinding.FragmentSettingsBinding;
import com.appx.libs.ImgLib;
import com.appx.libs.StringLib;

public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding binding;
    private RecyclerView recView;
    private List<Object> list;
    private FlexAdapter adapter;
    private final Context context = getContext();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recView = binding.recView;
        list = new ArrayList<>();
        populateData();
        adapter = new FlexAdapter(context,list);
        adapter.setRecyclerAdapter(recView);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void populateData()
    {
        list.add(new Schema.SettingListData("Linked Accounts", StringLib.getStringResource("linked-account-description"), ImgLib.getImageResource("cash"),"azure"));
        list.add(new Schema.SettingListData("Storage & Data",StringLib.getStringResource("storage-data-description"),ImgLib.getImageResource("cash"),"azure"));
        list.add(new Schema.SettingListData("Privacy Settings",StringLib.getStringResource("privacy-settings-description"),ImgLib.getImageResource("cash"),"azure"));
    }
}