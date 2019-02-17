package com.changhao.week01_exercise_02.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.changhao.week01_exercise_02.R;
import com.changhao.week01_exercise_02.adapter.ListAdapter;
import com.changhao.week01_exercise_02.contract.IListContract;
import com.changhao.week01_exercise_02.entity.ListBean;
import com.changhao.week01_exercise_02.presenter.ListPresenter;
import com.changhao.week01_exercise_02.ui.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment implements IListContract.IListView, ListAdapter.IGetIdCallback  {

    @BindView(R.id.xrv_view)
    XRecyclerView xrv_view;
    private ListAdapter listAdapter;
    private ListPresenter listPresenter;

    @Override
    protected void initData() {
        HashMap<String, String> params = new HashMap<>();
        listPresenter.getList(params);
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        listPresenter = new ListPresenter(this);
        listAdapter.setGetId(this);
        xrv_view.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        listAdapter = new ListAdapter(getActivity());
        xrv_view.setAdapter(listAdapter);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSuccess(List<ListBean.ResultBean.RxxpBean> rxxpBeans) {
        if (rxxpBeans != null) {
            listAdapter.setRxxpBeans(rxxpBeans);
        }
    }

    @Override
    public void onFailed(String msg) {

    }


    @Override
    public void getId(String id) {

    }
}
