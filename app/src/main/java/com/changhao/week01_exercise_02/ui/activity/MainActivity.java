package com.changhao.week01_exercise_02.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.changhao.week01_exercise_02.R;
import com.changhao.week01_exercise_02.ui.base.BaseActivity;
import com.changhao.week01_exercise_02.ui.fragment.CircleFragment;
import com.changhao.week01_exercise_02.ui.fragment.HomeFragment;
import com.changhao.week01_exercise_02.ui.fragment.MineFragment;
import com.changhao.week01_exercise_02.ui.fragment.OrderFragment;
import com.changhao.week01_exercise_02.ui.fragment.ShoppingCartFragment;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_circle:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_shopping_cart:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_order:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_mine:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_circle);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_shopping_cart);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_order);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.navigation_mine);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i) {
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new CircleFragment();
                    case 2:
                        return new ShoppingCartFragment();
                    case 3:
                        return new OrderFragment();
                    case 4:
                        return new MineFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        ImmersionBar.with(this)
                .init();


    }

    @Override
    protected int getViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }
}
