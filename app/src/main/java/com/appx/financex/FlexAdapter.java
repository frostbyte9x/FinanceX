package com.appx.financex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import com.appx.elementcraft.ListItem;
import com.appx.elementcraft.TintedIconView;

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
        View view;

        switch (viewType)
        {
            case SETTINGS_LIST:
                view = inflater.inflate(R.layout.layout_settings_item,parent,false);
                return new SettingListViewHolder(view);
            default:return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        switch (holder.getItemViewType())
        {
            case SETTINGS_LIST:
                ((SettingListViewHolder)holder).bind((ItemData.SettingListData) list.get(position));
                break;
            default:
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = list.get(position);

        if(obj instanceof ItemData.SettingListData)
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
        SettingListViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }

        void bind(ItemData.SettingListData data)
        {
            listItem.configure(data.getHeader(),data.getSubHeader());
            tintedIcon.setIcon(data.getIcon(),data.getTheme());
        }
    }
}
