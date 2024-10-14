package com.example.rakutentv.lstUser;

import com.example.rakutentv.beans.User;

import java.util.ArrayList;

public interface LoginUserContract {

    public interface View {
        void sucessLogin(User usuario);
        void failureLogin(String message);

    }
    public interface Presenter {
        void getUser(User usuario);
    }
    public interface Model {
        /*Programación Reactiva*/
        interface OnLoginUserListener {
            void onFinished(User usuario);
            void onFailure(String error);
        }
        void getUserService(OnLoginUserListener onLoginUserListener, User usuario);

    }
}
