package com.lcp.mvpdemo.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lcp.mvpdemo.R;
import com.lcp.mvpdemo.data.bean.GitHubUser;
import com.lcp.mvpdemo.widget.ARecyclerBaseAdapter;

import java.util.List;

/**
 * Created by Aislli on 2016/2/23.
 */
public class GithubUserListAdapter extends ARecyclerBaseAdapter<GithubUserListAdapter.MyViewHolder,GitHubUser> {


    public GithubUserListAdapter(Context mContext, List<GitHubUser> mList) {
        super(mContext, mList);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_githubuser, parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GitHubUser gitHubUser = mList.get(position);
        holder.ig_tv_name.setText(gitHubUser.getName());
        holder.ig_tv_blog.setText(gitHubUser.getBlog());
        holder.ig_tv_email.setText(gitHubUser.getEmail());
        holder.ig_tv_followers.setText(gitHubUser.getFollowers()+"");
        holder.ig_tv_following.setText(gitHubUser.getFollowing()+"");
        holder.ig_tv_repos.setText(gitHubUser.getPublic_repos()+"");
        holder.ig_tv_gists.setText(gitHubUser.getPublic_gists()+"");

        Uri uri = Uri.parse(gitHubUser.getAvatar_url());
        holder.ig_iv_avatar.setImageURI(uri);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView ig_iv_avatar;
        TextView ig_tv_name;
        TextView ig_tv_blog;
        TextView ig_tv_email;
        TextView ig_tv_followers;
        TextView ig_tv_following;
        TextView ig_tv_repos;
        TextView ig_tv_gists;

        public MyViewHolder(View view) {
            super(view);
            ig_iv_avatar = (SimpleDraweeView) view.findViewById(R.id.ig_iv_avatar);
            ig_tv_name = (TextView) view.findViewById(R.id.ig_tv_name);
            ig_tv_blog = (TextView) view.findViewById(R.id.ig_tv_blog);
            ig_tv_email = (TextView) view.findViewById(R.id.ig_tv_email);
            ig_tv_followers = (TextView) view.findViewById(R.id.ig_tv_followers);
            ig_tv_following = (TextView) view.findViewById(R.id.ig_tv_following);
            ig_tv_repos = (TextView) view.findViewById(R.id.ig_tv_repos);
            ig_tv_gists = (TextView) view.findViewById(R.id.ig_tv_gists);
        }
    }
}
