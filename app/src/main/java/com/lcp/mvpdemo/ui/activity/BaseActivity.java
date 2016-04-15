package com.lcp.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lcp.mvpdemo.R;
import com.lcp.mvpdemo.presenter.BasePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by Aislli on 2016/4/13.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;
    /**
     * the presenter of this Activity
     */
    protected P mPresenter;

    /**
     * TODO use Dagger2 instance Presenter
     */
    protected abstract void initPresenter();

    /**
     * set layout of this activity
     * @return the id of layout
     */
    protected abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresenter();
        checkPresenterIsNull();
        initToolBar();
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }*/

    private void checkPresenterIsNull(){
        if(mPresenter == null){
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    /**
     * set the id of menu
     * @return if values is less then zero ,and the activity will not show menu
     */
    protected int getMenuRes(){
        return -1;
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(getMenuRes()<0)return true;
        getMenuInflater().inflate(getMenuRes(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //don't use finish() and use onBackPressed() will be a good practice , trust me !
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    final private void initToolBar() {
        if(mToolbar == null){
            throw new NullPointerException("please add a Toolbar in your layout.");
        }
        setSupportActionBar(mToolbar);
    }

    public void setTitle(String strTitle,boolean showHome){
        setTitle(strTitle);
        getSupportActionBar().setDisplayShowHomeEnabled(showHome);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHome);
    }
}
