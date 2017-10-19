package com.samanlan.passwordwarehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.mypopsy.widget.FloatingSearchView;
import com.samanlan.passwordwarehouse.adapter.MainContentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.content_recyclerview)
    RecyclerView contentRecyclerview;
    @BindView(R.id.menu_item_add)
    FloatingActionButton menuItemAdd;
    @BindView(R.id.menu_item_add_paste)
    FloatingActionButton menuItemAddPaste;
    @BindView(R.id.menu_item_add_img)
    FloatingActionButton menuItemAddImg;

    MainContentAdapter contentAdapter;
    @BindView(R.id.menu)
    FloatingActionMenu menu;
    @BindView(R.id.search)
    FloatingSearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        contentRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        contentAdapter = new MainContentAdapter(R.layout.item_main_content);
        contentAdapter.openLoadAnimation();
        contentAdapter.isFirstOnly(false);
        contentAdapter.setOnLoadMoreListener(this, contentRecyclerview);
        contentAdapter.setLoadMoreView(new SimpleLoadMoreView());
        contentAdapter.setEmptyView(R.layout.item_empty);
//        contentAdapter.addData(Collections.<PwdBean>emptyList());
        contentRecyclerview.setAdapter(contentAdapter);
        search.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSearchAction(CharSequence charSequence) {

            }
        });
        search.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    @OnClick({R.id.menu_item_add, R.id.menu_item_add_paste, R.id.menu_item_add_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu_item_add:
                menu.close(true);
                break;
            case R.id.menu_item_add_paste:
                menu.close(true);
                break;
            case R.id.menu_item_add_img:
                menu.close(true);
                break;
            default:
        }
    }

    @Override
    public void onLoadMoreRequested() {
        if (true) {
            contentAdapter.loadMoreEnd();
        } else {
            if (true) {
                contentAdapter.loadMoreComplete();
            } else {
                contentAdapter.loadMoreFail();
            }
        }
    }
}
