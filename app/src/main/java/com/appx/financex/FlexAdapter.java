package com.appx.financex;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import com.appx.elementcraft.ListItem;
import com.appx.elementcraft.TintedIconView;
import com.appx.financex.databinding.LayoutSettingsItemBinding;
import com.appx.financex.ui.settings.LinkedAccounts;
import com.appx.financex.ui.settings.PrivacySettings;
import com.appx.financex.ui.settings.StorageData;

public class FlexAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private static final int SETTINGS_LIST = 1;
    private static final int DEFAULT = -1;
    private List<Object> list;
    private Context context;

    public FlexAdapter(Context context,List<Object> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType)
        {
            case SETTINGS_LIST:
                LayoutSettingsItemBinding binding = LayoutSettingsItemBinding.inflate(inflater,parent,false);
                return new SettingListViewHolder(binding);
            default:return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        switch (holder.getItemViewType())
        {
            case SETTINGS_LIST:
                ((SettingListViewHolder)holder).bind((Data.SettingListData) list.get(position));
                break;
            default:
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = list.get(position);

        if(obj instanceof Data.SettingListData)
            return SETTINGS_LIST;
        return DEFAULT;
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setRecyclerAdapter(RecyclerView recView)
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recView.setLayoutManager(layoutManager);
        recView.setAdapter(this);
    }

    private static class SettingListViewHolder extends RecyclerView.ViewHolder
    {
        private ListItem listItem;
        private TintedIconView tintedIcon;
        private LayoutSettingsItemBinding binding;

        SettingListViewHolder(@NonNull LayoutSettingsItemBinding binding)
        {
            super(binding.getRoot());
            this.binding =binding;
            listItem = binding.listItem;
            tintedIcon = binding.tintedIcon;

            binding.getRoot().setOnClickListener(v -> {
                int pos = getAdapterPosition();
                switch(pos)
                {
                    case 0: replaceFragment(new LinkedAccounts());break;
                    case 1: replaceFragment(new StorageData()); break;
                    case 2: replaceFragment(new PrivacySettings());break;
                    default: break;
                }
            });
        }

        void bind(Data.SettingListData data)
        {
            listItem.configure(data.getHeader(),data.getSubHeader());
            tintedIcon.setIcon(data.getIcon(),data.getTheme());
        }

        private void replaceFragment(Fragment fragment)
        {
            FragmentManager fragmentManager = ((AppCompatActivity)binding.getRoot().getContext()).getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(binding.getRoot().getId(),fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}