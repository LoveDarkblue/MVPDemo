package com.lcp.mvpdemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lcp.mvpdemo.R;
import com.lcp.mvpdemo.data.bean.IpInfo;
import com.lcp.mvpdemo.presenter.IpInfoPresenter;
import com.lcp.mvpdemo.ui.view.IIPinfoView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Aislli on 2016/4/12.
 */
public class IpInfoActivity extends BaseActivity<IpInfoPresenter> implements IIPinfoView<IpInfo> {
    @Bind(R.id.ai_et_ipinfo)
    EditText aiEtIpinfo;
    @Bind(R.id.ai_btn_find)
    Button aiBtnFind;
    @Bind(R.id.ai_tv_content)
    TextView aiTvContent;

    @Override
    protected void initPresenter() {
        mPresenter = new IpInfoPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_ipinfo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.ai_btn_find)
    public void onClick() {
        mPresenter.getData();
    }

    @Override
    public void setViewData(IpInfo data) {
        if (TextUtils.isEmpty(data.getCountry())) {
            aiTvContent.setText(R.string.no_result);
            return;
        }
        StringBuffer stb = new StringBuffer();
        stb.append(getString(R.string.addr)).append(data.getCountry()).append(" ").append(data.getArea()).append(" ").append(data.getRegion()).append(" ").append(data.getCity()).append("\n");
        stb.append(getString(R.string.net)).append(data.getIsp()).append("\n");
        aiTvContent.setText(stb.toString());
    }

    @Override
    public String getIpStr() {
        return aiEtIpinfo.getText()+"";
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(aiTvContent, msg, Snackbar.LENGTH_INDEFINITE)
                .setAction("click to close toast!", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aiTvContent.setText(R.string.change_addr);
                    }
                })
                .show();
    }

}
