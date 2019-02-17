package com.changhao.week01_exercise_02.presenter;

import com.changhao.week01_exercise_02.contract.IListContract;
import com.changhao.week01_exercise_02.entity.ListBean;
import com.changhao.week01_exercise_02.model.ListModel;
import com.changhao.week01_exercise_02.net.IRequestCallback;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class ListPresenter extends IListContract.ListPresenter {
    private ListModel listModel;
    private IListContract.IListView iListView;

    public ListPresenter(IListContract.IListView iListView) {
        listModel = new ListModel();
        this.iListView = iListView;
    }

    @Override
    public void getList(HashMap<String, String> params) {
        listModel.getList(params, new IRequestCallback() {
            @Override
            public void onSuccess(String result) {
                ListBean listBean = new Gson().fromJson(result, ListBean.class);
                List<ListBean.ResultBean.RxxpBean> rxxp = listBean.getResult().getRxxp();
                if (iListView != null) {
                    iListView.onSuccess(rxxp);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (iListView != null) {
                    iListView.onFailed(msg);
                }
            }
        });
    }
}
