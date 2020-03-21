package com.rrdev.simplemvp.Presenter;

public class LoginPresenterImp implements LoginPresenter.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginPresenter loginPresenter;

    public LoginPresenterImp(LoginView loginView, LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
        this.loginView = loginView;
    }

    @Override
    public void onLoginError() {
        if (loginView!=null)
        {
            loginView.onLoginError();
        }
    }

    public void validateCredentials(String username, String password)
    {
        if (loginView!=null)
        {
            loginPresenter.canLogin(username,password,this);
        }
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
        }

    }

    @Override
    public void onLoginSuccess(String username) {
        if (loginView != null) {
            loginView.onLoginSuccess(username);
        }

    }
}