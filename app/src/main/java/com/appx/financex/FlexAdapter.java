package com.appx.financex;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import com.appx.elementcraft.ListItem;
import com.appx.elementcraft.TintedIconView;
import com.appx.financex.databinding.LayoutSettingsItemBinding;

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
                ((SettingListViewHolder)holder).bind((Schema.SettingListData) list.get(position));
                break;
            default:
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = list.get(position);

        if(obj instanceof Schema.SettingListData)
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
                    case 0: replaceFragment(R.id.action_linked_accounts);break;
                    case 1: replaceFragment(R.id.action_storage_and_data); break;
                    case 2: replaceFragment(R.id.action_privacy_settings);break;
                    default: break;
                }
            });
        }

        void bind(Schema.SettingListData data)
        {
            listItem.configure(data.getHeader(),data.getSubHeader());
            tintedIcon.setIcon(data.getIcon(),data.getTheme());
        }

        private void replaceFragment(int actionId)
        {
            Navigation.findNavController(binding.getRoot()).navigate(actionId);
        }
    }
}