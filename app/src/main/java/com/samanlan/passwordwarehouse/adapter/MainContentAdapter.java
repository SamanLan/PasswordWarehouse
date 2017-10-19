package com.samanlan.passwordwarehouse.adapter;

import android.support.annotation.LayoutRes;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.samanlan.passwordwarehouse.bean.PwdBean;

/**
 * <code>MainContentAdapter</code>{}
 *
 * @author :LanSaman
 * @date :2017/10/20
 * @description :
 */
public class MainContentAdapter extends BaseQuickAdapter<PwdBean,MainContentAdapter.MainContentHolder> {
    public MainContentAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(MainContentHolder helper, PwdBean item) {

    }

    class MainContentHolder extends BaseViewHolder{
        public MainContentHolder(View view) {
            super(view);
        }
    }
}
