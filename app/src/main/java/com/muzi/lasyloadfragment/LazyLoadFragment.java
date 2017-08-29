package com.muzi.lasyloadfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by 李鹏 on 2017/08/13 0013.
 * Fragment预加载问题的解决方案：
 * 1.可以懒加载的Fragment
 * 2.切换到其他页面时停止加载数据（可选）
 * <p>
 * setContentView：添加布局文件
 * findViewById：实例化控件
 * finishCreateView：布局初始化完成，可以初始化工具类或context赋值
 * lazyLoad：开始请求网络数据
 * stopLoad()：取消网络请求
 * <p>
 * <p>
 * 适用tablayout+viewpage+fragment，场景：淘宝我的订单页
 * 任意fragment切换都会刷新数据
 * 跳转activity，返回也会刷新数据，如果不需要，注释onResume方法即可
 */

public abstract class LazyLoadFragment extends Fragment {
    /**
     * 视图是否已经初初始化
     */
    private boolean isInit = false;
    private boolean isLoad = false;
    private boolean isPause = false;
    private View view;

    public LazyLoadFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(setContentView(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isInit = true;
        finishCreateView(view);
        //初始化的时候去加载数据
        isCanLoadData();
    }

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }


    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    private void isCanLoadData() {
        if (!isInit) {
            return;
        }

        if (getUserVisibleHint()) {
            lazyLoad();
            isLoad = true;
        } else {
            if (isLoad) {
                stopLoad();
            }
        }
    }

    /**
     * 视图销毁的时候讲Fragment是否初始化的状态变为false
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        isPause = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isPause) {
            isPause = false;
            lazyLoad();
        }
    }

    /**
     * 设置Fragment要显示的布局
     *
     * @return 布局的layoutId
     */
    protected abstract int setContentView();

    /**
     * 找出对应的控件
     */
    protected <T extends View> T findViewById(int id) {

        return (T) getContentView().findViewById(id);
    }

    /**
     * 获取设置的布局
     */
    protected View getContentView() {
        return view;
    }

    /**
     * view初始化完成，在这初始化一些工具类
     *
     * @param view
     */
    protected abstract void finishCreateView(View view);

    /**
     * 当视图初始化并且对用户可见的时候去真正的加载数据
     */
    protected abstract void lazyLoad();

    /**
     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以覆写此方法
     */
    protected void stopLoad() {
    }

    protected void showToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }
}

