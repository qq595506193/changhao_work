package com.changhao.week01_exercise_02.contract;

import com.changhao.week01_exercise_02.entity.ParticularsBean;
import com.changhao.week01_exercise_02.net.IRequestCallback;

import java.util.HashMap;

public interface IParticularsContract {

    abstract class ParticularsPresenter {
        public abstract void getParticulars(HashMap<String,String> params);
    }

    interface IParticularsModel {
        void getParticulars(HashMap<String,String> params, IRequestCallback iRequestCallback);
    }

    interface IParticularsView {
        void onSuccess(ParticularsBean particularsBean);

        void onFailed(String msg);
    }

}
