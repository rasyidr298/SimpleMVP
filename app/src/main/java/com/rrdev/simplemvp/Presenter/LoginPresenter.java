package com.rrdev.simplemvp.Presenter;

import android.os.Handler;
import android.text.TextUtils;

public class LoginPresenter {
    interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onLoginSuccess(String username);
        void onLoginError();
    }

    public void canLogin(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }
                if (username.equalsIgnoreCase("rasyid") && password.equalsIgnoreCase("1234")) {
                    listener.onLoginSuccess(username);
                    return;
                }
                listener.onLoginError();
            }
        }, 2000);
    }
}
