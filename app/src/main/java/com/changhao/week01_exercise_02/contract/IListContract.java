package com.changhao.week01_exercise_02.contract;

import com.changhao.week01_exercise_02.entity.ListBean;
import com.changhao.week01_exercise_02.net.IRequestCallback;

import java.util.HashMap;
import java.util.List;

public interface IListContract {
    abstract class ListPresenter {
        public abstract void getList(HashMap<String, String> params);
    }

    interface IListModel {
        void getList(HashMap<String, String> params, IRequestCallback iRequestCallback);
    }

    interface IListView {
        void onSuccess(List<ListBean.ResultBean.RxxpBean> rxxpBeans);

        void onFailed(String msg);
    }
}
