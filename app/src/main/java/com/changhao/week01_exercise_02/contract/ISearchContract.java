package com.changhao.week01_exercise_02.contract;

import com.changhao.week01_exercise_02.entity.SearchBean;
import com.changhao.week01_exercise_02.net.IRequestCallback;

import java.util.HashMap;

public interface ISearchContract {

    abstract class SearchPresenter {
        public abstract void getSearch(HashMap<String, String> params);
    }

    interface ISearchModel {
        void getSearch(HashMap<String, String> params, IRequestCallback iRequestCallback);
    }

    interface ISearchView {
        void onSuccess(SearchBean searchBean);

        void onFailed(String msg);
    }

}
