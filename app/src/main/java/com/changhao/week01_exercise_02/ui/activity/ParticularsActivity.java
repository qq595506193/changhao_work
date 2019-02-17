package com.changhao.week01_exercise_02.ui.activity;

import android.net.Uri;
import android.widget.TextView;

import com.changhao.week01_exercise_02.R;
import com.changhao.week01_exercise_02.contract.IParticularsContract;
import com.changhao.week01_exercise_02.entity.ParticularsBean;
import com.changhao.week01_exercise_02.ui.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticularsActivity extends BaseActivity implements IParticularsContract.IParticularsView {

    @BindView(R.id.fresco_view)
    SimpleDraweeView fresco_view;
    @BindView(R.id.tv_name)
    TextView tv_name;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int getViewId() {
        return R.layout.activity_particulars;
    }

    @Override
    public void onSuccess(ParticularsBean particularsBean) {
        String picture = particularsBean.getResult().getPicture();
        String[] split = picture.split(",");
        Uri uri = Uri.parse(split[0]);
        fresco_view.setImageURI(uri);
        tv_name.setText(particularsBean.getResult().getCategoryName());
    }

    @Override
    public void onFailed(String msg) {

    }
}
