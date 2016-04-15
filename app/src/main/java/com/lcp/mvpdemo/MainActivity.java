package com.lcp.mvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lcp.mvpdemo.ui.activity.GitHubUserListActivity;
import com.lcp.mvpdemo.ui.activity.IpInfoActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_github)
    Button btnGithub;
    @Bind(R.id.btn_ip)
    Button btnIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_github, R.id.btn_ip})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_github:
                intent.setClass(this, GitHubUserListActivity.class);
                break;
            case R.id.btn_ip:
                intent.setClass(this, IpInfoActivity.class);
                break;
        }
        startActivity(intent);
    }
}
