package com.changhao.week01_exercise_02.presenter;

import com.changhao.week01_exercise_02.contract.ISearchContract;
import com.changhao.week01_exercise_02.entity.SearchBean;
import com.changhao.week01_exercise_02.model.SearchModel;
import com.changhao.week01_exercise_02.net.IRequestCallback;
import com.google.gson.Gson;

import java.util.HashMap;

public class SearchPresenter extends ISearchContract.SearchPresenter {
    private SearchModel searchModel;
    private ISearchContract.ISearchView iSearchView;

    public SearchPresenter(ISearchContract.ISearchView iSearchView) {
        searchModel = new SearchModel();
        this.iSearchView = iSearchView;
    }

    @Override
    public void getSearch(HashMap<String, String> params) {
        searchModel.getSearch(params, new IRequestCallback() {
            @Override
            public void onSuccess(String result) {
                SearchBean searchBean = new Gson().fromJson(result, SearchBean.class);
                if (iSearchView != null) {
                    iSearchView.onSuccess(searchBean);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (iSearchView != null) {
                    iSearchView.onFailed(msg);
                }
            }
        });
    }
}
