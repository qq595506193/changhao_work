package com.changhao.week01_exercise_02.presenter;

import com.changhao.week01_exercise_02.contract.IParticularsContract;
import com.changhao.week01_exercise_02.entity.ParticularsBean;
import com.changhao.week01_exercise_02.model.ParticularsModel;
import com.changhao.week01_exercise_02.net.IRequestCallback;
import com.google.gson.Gson;

import java.util.HashMap;

public class ParticularsPresenter extends IParticularsContract.ParticularsPresenter {
    private ParticularsModel particularsModel;
    private IParticularsContract.IParticularsView iParticularsView;

    public ParticularsPresenter(IParticularsContract.IParticularsView iParticularsView) {
        particularsModel = new ParticularsModel();
        this.iParticularsView = iParticularsView;
    }

    @Override
    public void getParticulars(HashMap<String, String> params) {
        particularsModel.getParticulars(params, new IRequestCallback() {
            @Override
            public void onSuccess(String result) {
                ParticularsBean particularsBean = new Gson().fromJson(result, ParticularsBean.class);
                if (iParticularsView != null) {
                    iParticularsView.onSuccess(particularsBean);
                }
            }

            @Override
            public void onFailed(String msg) {
                if (iParticularsView != null) {
                    iParticularsView.onFailed(msg);
                }
            }
        });
    }
}
