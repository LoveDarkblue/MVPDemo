package com.lcp.mvpdemo.data.bean;

/**
 * Created by Aislli on 2016/4/12.
 */
public class GitHubUser {
    /**
     * gists_url : https://api.github.com/users/JakeWharton/gists{/gist_id}
     * repos_url : https://api.github.com/users/JakeWharton/repos
     * following_url : https://api.github.com/users/JakeWharton/following{/other_user}
     * bio : null
     * created_at : 2009-03-24T16:09:53Z
     * login : JakeWharton
     * type : User
     * blog : http://jakewharton.com
     * subscriptions_url : https://api.github.com/users/JakeWharton/subscriptions
     * updated_at : 2016-04-05T18:49:58Z
     * site_admin : false
     * company : Square, Inc.
     * id : 66577
     * public_repos : 76
     * gravatar_id :
     * email : jakewharton@gmail.com
     * organizations_url : https://api.github.com/users/JakeWharton/orgs
     * hireable : null
     * starred_url : https://api.github.com/users/JakeWharton/starred{/owner}{/repo}
     * followers_url : https://api.github.com/users/JakeWharton/followers
     * public_gists : 54
     * url : https://api.github.com/users/JakeWharton
     * received_events_url : https://api.github.com/users/JakeWharton/received_events
     * followers : 20474
     * avatar_url : https://avatars.githubusercontent.com/u/66577?v=3
     * events_url : https://api.github.com/users/JakeWharton/events{/privacy}
     * html_url : https://github.com/JakeWharton
     * following : 13
     * name : Jake Wharton
     * location : Pittsburgh, PA, USA
     */
    private String gists_url;
    private String repos_url;
    private String following_url;
    private String bio;
    private String created_at;
    private String login;
    private String type;
    private String blog;
    private String subscriptions_url;
    private String updated_at;
    private boolean site_admin;
    private String company;
    private int id;
    private int public_repos;
    private String gravatar_id;
    private String email;
    private String organizations_url;
    private String hireable;
    private String starred_url;
    private String followers_url;
    private int public_gists;
    private String url;
    private String received_events_url;
    private int followers;
    private String avatar_url;
    private String events_url;
    private String html_url;
    private int following;
    private String name;
    private String location;

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getBio() {
        return bio;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getLogin() {
        return login;
    }

    public String getType() {
        return type;
    }

    public String getBlog() {
        return blog;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public String getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getHireable() {
        return hireable;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public String getUrl() {
        return url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public int getFollowers() {
        return followers;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public int getFollowing() {
        return following;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
