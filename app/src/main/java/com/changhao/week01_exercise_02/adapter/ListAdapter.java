package com.changhao.week01_exercise_02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.changhao.week01_exercise_02.R;
import com.changhao.week01_exercise_02.entity.ListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends XRecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private List<ListBean.ResultBean.RxxpBean> rxxpBeans;

    public ListAdapter(Context context) {
        rxxpBeans = new ArrayList<>();
        this.context = context;
    }

    public void setRxxpBeans(List<ListBean.ResultBean.RxxpBean> rxxpBeans) {
        if (rxxpBeans != null) {
            this.rxxpBeans = rxxpBeans;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {
        final ListBean.ResultBean.RxxpBean rxxpBean = rxxpBeans.get(i);
        Glide.with(context).load(rxxpBean.getCommodityList().get(i).getMasterPic()).into(viewHolder.iv_view);
        viewHolder.tv_name.setText(rxxpBean.getCommodityList().get(i).getCommodityName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getId != null) {
                    getId.getId(rxxpBean.getId()+"");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rxxpBeans == null ? 0 : rxxpBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_view;
        private final TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_view = itemView.findViewById(R.id.iv_view);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }

    public IGetIdCallback getId;

    public void setGetId(IGetIdCallback getId) {
        this.getId = getId;
    }

    public static interface IGetIdCallback {
        void getId(String id);
    }
}
